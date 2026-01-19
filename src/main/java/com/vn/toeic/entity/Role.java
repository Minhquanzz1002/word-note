package com.vn.toeic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity representing a role.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    /**
     * The unique identifier of the role.
     */
    private Integer roleId;

    /**
     * The name of the role.
     */
    private String name;

}
