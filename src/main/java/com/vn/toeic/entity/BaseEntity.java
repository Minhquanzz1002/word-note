package com.vn.toeic.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {
    private Integer updater;
    private Integer creator;
    private Date updatedAt;
    private Date createdAt;
    private Byte delFlg;
    private Integer versionNo;
}
