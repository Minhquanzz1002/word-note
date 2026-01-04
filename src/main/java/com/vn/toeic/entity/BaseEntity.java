package com.vn.toeic.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public abstract class BaseEntity {
    private Integer updater;
    private Integer creator;
    private OffsetDateTime updatedAt;
    private OffsetDateTime createdAt;
    private Byte delFlg;
    private Integer versionNo;
}
