package com.kkj.carrotback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private Instant createDate;

    @LastModifiedDate
    @Column(name = "LAST_UPDATE", updatable = true)
    private Instant lastDate;


}
