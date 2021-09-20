package com.scott.reserved.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@ToString(exclude = {"id", "created", "lastModified"})
public abstract class BaseEntity {
    @Id
    private String id;

    @CreatedDate
    private long created;

    @LastModifiedDate
    private long lastModified;
}




