package com.vn.toeic.mapper;

import com.vn.toeic.entity.AuthBaseUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAuthBaseUserMapper extends BaseMapper<AuthBaseUser, Integer> {

    /**
     * Retrieves an entity from database by its username.
     *
     * @param username the username.
     * @return the auth base user.
     */
    AuthBaseUser findByUsername(String username);

}
