package fr.univrouen.pollen.repositories;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseRepository<T extends Identifiable> implements Repository<T>, AutoCloseable {

    protected Class<?> classType;
    protected Session session;

    public BaseRepository() {
        //Don't ask any question about this line pls
        classType = ((Class<?>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        session = open();
    }

    public int count() {
        return ((Long)session.createQuery("select count(*) from " + classType.getSimpleName()).uniqueResult()).intValue();
    }

    public List<T> getAll() {
        List<T> entities = session.createQuery("From " + classType.getSimpleName()).list();

        return entities;
    }

    public List<T> getAll(int start, int nb) {
        List<T> entities =
                session.createQuery("From " + classType.getSimpleName())
                .setFirstResult(start)
                .setMaxResults(nb)
                .list();

        return entities;
    }

    public T getById(long id) {
        T entity = (T) session.get(classType, id);

        return entity;
    }

    public long insert(T object) {
        long id = -1;

        try {
            session.save(object);
        } catch (RuntimeException e) {
            reset();
            throw e;
        }

        //Get the id for check the insertion validity
        T persistentInstance = (T) session.load(classType, object.getId());
        if (persistentInstance != null) {
            id = persistentInstance.getId();
        }

        return id;
    }

    public boolean update(T object) {
        boolean bool = true;

        try {
            session.merge(object);
        } catch(HibernateException e) {
            reset();
            throw e;
        }

        return bool;
    }

    public boolean delete(T object) {
        boolean bool = true;

        try {
            session.delete(object);
        } catch(HibernateException e) {
            bool = false;
            reset();
            throw e;
        }

        return bool;
    }

    /**
     * Utility method for opening an Hibernate session
     * @return a new hibernate session
     */
    protected Session open() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (!session.getTransaction().isActive()) {
            session.beginTransaction();
        }
        return session;
    }

    public void reset() {
        if (!session.getTransaction().wasRolledBack()) {
            session.getTransaction().rollback();
            session = open();
        }
    }

    @Override
    public void close() throws Exception {
        if (session != null) {
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }

            if (session.isOpen()) {
                session.close();
                session = null;
            }
        }
    }
}
