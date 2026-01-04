package com.vn.toeic.mapper;

import com.vn.toeic.entity.BaseEntity;

/**
 * BaseMapper defines the common CRUD operations for MyBatis mappers.
 *
 * @param <T> the entity type
 * @param <D> the type of the primary key (ID)
 */
public interface BaseMapper<T extends BaseEntity, D> {

    /**
     * Inserts a new entity into the database.
     *
     * @param entity the entity to save
     * @return the number of rows affected
     */
    int save(T entity);

    /**
     * Updates an existing entity in the database.
     *
     * @param entity the entity to update
     * @return the number of rows affected
     */
    int update(T entity);

    /**
     * Deletes an entity from the database by its ID.
     *
     * @param entity the entity to delete
     * @return the number of rows affected
     */
    int delete(T entity);

    /**
     * Retrieves an entity from the database by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the matching entity, or null if not found
     */
    T findById(D id);
}
