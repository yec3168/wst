package com.tool.wst.mail.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private String mail_receiver;



    private LocalDateTime from_date;   //발신 시간
    private LocalDateTime to_date;     //수신 시간.

    @Builder
    public Mail(String mail_title, String mail_content, String mail_sender,
                String mail_receiver){
        this.mail_title = mail_receiver;
        this.mail_content = mail_receiver;
        this.mail_sender = mail_sender;
        this.mail_receiver = mail_receiver;
        this.from_date = LocalDateTime.now();
        this.to_date = LocalDateTime.now().plusSeconds(5);
    }
}
