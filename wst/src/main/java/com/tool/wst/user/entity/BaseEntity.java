package com.tool.wst.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*
* abstract : 반드시 오버라이딩 해야만 사용 가능한 메소드라는 의미.
* */
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
public abstract class BaseEntity extends  BaseTimeEntity{
    @CreatedBy
    @Column(updatable = false)
    private String createBy;

    @LastModifiedBy
    private String updateBy;
}
