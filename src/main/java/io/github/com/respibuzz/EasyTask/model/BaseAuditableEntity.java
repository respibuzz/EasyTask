package io.github.com.respibuzz.EasyTask.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseAuditableEntity {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void onCreate() {createdOn = LocalDateTime.now();}
    @PreUpdate
    public void onMerge() {updatedOn = LocalDateTime.now();}
}
