package com.vn.toeic.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseEntity {
    private Integer updater;
    private Integer creator;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Byte delFlg;
    private Integer versionNo;
}
