package fr.univrouen.pollen.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

    private static final SessionFactory sessionFactory = open();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory open() {
        Configuration configuration = new Configuration().configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static void close() throws Exception {
        sessionFactory.close();
    }
}
