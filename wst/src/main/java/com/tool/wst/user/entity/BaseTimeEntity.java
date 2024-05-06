package com.tool.wst.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@Setter
@MappedSuperclass // 공통 매핑 정보가 필요시 사용.
public class BaseTimeEntity {

    @CreatedDate //DB에 데이터를 저장시 자동으로 저장.
    @Column(updatable = false) // 업데이트 안함.
    private LocalDateTime createDate;

    @LastModifiedDate // 변경시 시간을 저장.
    private LocalDateTime updateDate;
}
