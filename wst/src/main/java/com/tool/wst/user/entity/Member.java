package com.tool.wst.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* form에서 받아올 것*/
    private String company_id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String photo;
    private String url;


    /*admin만 수정 가능.*/
    private LocalDateTime hireDate; //입사일  // admin만 수정
    private LocalDateTime retireDate; // 퇴사일
    private String department_id; //부서명 (솔루션사업부, erp사업부, si사업부, 경영지원실, 교육사업부...)
    private String rank; // 사장, 전무, 상무, 이사, 부장, 차장, 과장, 대리 ,사원, 교육생.
    private int annual; // 연차


    @Builder
    public Member(String company_id, String name, String address, String phone, String email, String password,
                  String photo, String url, String department_id, String rank,
                  LocalDateTime hireDate, LocalDateTime retireDate, int annual){
        this.company_id = company_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.url = url;
        this.department_id = department_id;
        this.rank = rank;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.annual = annual;
    }
}
