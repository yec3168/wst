package com.tool.wst.mail.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_id")
    private Long mail_id;

    private String mail_title;
    private String mail_content;
    private String mail_sender; // 발신자 이메일

    private String from_date;   //발신 시간
    private String to_date;     //수신 시간.
}
