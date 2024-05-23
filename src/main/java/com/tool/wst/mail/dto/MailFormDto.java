package com.tool.wst.mail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailFormDto {
    private String mail_sender; // 발신자 이메일
    private String mail_receiver;
    private String mail_title;
    private String mail_content;

}
