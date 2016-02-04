package fr.univrouen.pollen.repositories;

import fr.univrouen.pollen.domain.Identifiable;

import java.util.List;

public interface Repository<T extends Identifiable> {

    /**
     * all the object in the current table
     * @return the list of object in the current table
     */
    public List<T> getAll();

    /**
     * Return the object in relation with the given id
     * @param id of the object
     * @return the user with the given id, or null
     */
    public T getById(long id);

    /**
     * insert a new element in the database
     * @param object to update
     * @return the id of the element inserted
     */
    public long insert(T object);

    /**
     * updates the given element in Database
     * @param object to update
     * @return true success, false failure
     */
    public boolean update(T object);

    /**
     * deletes the given element
     * @param object to delete
     * @return true success, false failure
     */
    public boolean delete(T object);

}
