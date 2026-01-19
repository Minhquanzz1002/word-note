package com.vn.toeic.repository;

import com.vn.toeic.common.Constant;
import com.vn.toeic.entity.AuthBaseUser;
import com.vn.toeic.mapper.IAuthBaseUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthBaseUserRepository extends BaseRepository<AuthBaseUser, Integer> {

    private final IAuthBaseUserMapper authBaseUserMapper;

    /**
     * Inserts a new entity into the database.
     *
     * @param entity the entity to save
     * @return the number of rows affected
     */
    @Override
    public int save(AuthBaseUser entity) {
        this.setAuditFields(entity, Constant.AuditAction.CREATE);
        return authBaseUserMapper.save(entity);
    }

    /**
     * Updates an existing entity in the database.
     *
     * @param entity the entity to update
     * @return the number of rows affected
     */
    @Override
    public int update(AuthBaseUser entity) {
        this.setAuditFields(entity, Constant.AuditAction.UPDATE);
        return authBaseUserMapper.update(entity);
    }

    /**
     * Deletes an entity from the database by its ID.
     *
     * @param entity the entity to delete
     * @return the number of rows affected
     */
    @Override
    public int delete(AuthBaseUser entity) {
        this.setAuditFields(new AuthBaseUser(), Constant.AuditAction.DELETE);
        return authBaseUserMapper.delete(entity);
    }

    /**
     * Retrieves an entity from the database by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the matching entity, or null if not found
     */
    @Override
    public AuthBaseUser findById(Integer id) {
        return authBaseUserMapper.findById(id);
    }

    /**
     * Retrieves an entity from database by its username.
     *
     * @param username the username.
     * @return the auth base user.
     */
    public AuthBaseUser findByUsername(String username) {
        return authBaseUserMapper.findByUsername(username);
    }
}
