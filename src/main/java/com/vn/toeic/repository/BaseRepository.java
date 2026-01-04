package com.vn.toeic.repository;

import com.vn.toeic.common.SystemValue.*;
import com.vn.toeic.entity.BaseEntity;

import java.util.Date;

/**
 * BaseRepository defines the common CRUD operations for MyBatis mappers.
 *
 * @param <T> the entity type
 * @param <D> the type of the primary key (ID)
 */
public abstract class BaseRepository<T extends BaseEntity, D> {

    /**
     * Inserts a new entity into the database.
     *
     * @param entity the entity to save
     * @return the number of rows affected
     */
    public abstract int save(T entity);

    /**
     * Updates an existing entity in the database.
     *
     * @param entity the entity to update
     * @return the number of rows affected
     */
    public abstract int update(T entity);

    /**
     * Deletes an entity from the database by its ID.
     *
     * @param entity the entity to delete
     * @return the number of rows affected
     */
    public abstract int delete(T entity);

    /**
     * Retrieves an entity from the database by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the matching entity, or null if not found
     */
    public abstract T findById(D id);

    /**
     * Applies audit metadata to the given entity based on the specified action.
     * <p>
     * This method automatically updates fields such as:
     * <ul>
     *   <li><b>createdAt</b> – set only during CREATE</li>
     *   <li><b>updatedAt</b> – set during CREATE, UPDATE, and DELETE</li>
     *   <li><b>versionNo</b> – initialized during CREATE</li>
     *   <li><b>delFlg</b> – marked as deleted during DELETE</li>
     * </ul>
     *
     * @param entity the entity to which audit fields should be applied
     * @param action the audit action being performed (CREATE, UPDATE, DELETE)
     */
    protected void setAuditFields(T entity, AuditAction action) {
        Date now = new Date();

        switch (action) {
            case CREATE -> {
                entity.setCreatedAt(now);
                entity.setUpdatedAt(now);
                entity.setVersionNo(VersionNo.INIT);
            }
            case UPDATE -> entity.setUpdatedAt(now);
            case DELETE -> {
                entity.setUpdatedAt(now);
                entity.setDelFlg(DelFlg.DELETED);
            }
        }
    }
}
