package com.tool.wst.mail.service;

import com.tool.wst.mail.dto.MailFormDto;
import com.tool.wst.mail.entity.Mail;
import com.tool.wst.mail.repository.MailRepository;
import com.tool.wst.user.entity.Member;
import com.tool.wst.user.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailService {

    @Autowired
    private MailRepository mailRepository;

    @Autowired
    private MemberService memberService;

    public void mailSave(MailFormDto mailFormDto, String sender){
        Mail mail = Mail.builder().mail_title(mailFormDto.getMail_title())
                .mail_content(mailFormDto.getMail_content())
                .mail_sender(sender)
                .mail_receiver(mailFormDto.getMail_receiver())
                .build();

        mailRepository.save(mail);

    }
    public void toMeSave(MailFormDto mailFormDto, String sender){
        Mail mail = Mail.builder().mail_title(mailFormDto.getMail_title())
                .mail_content(mailFormDto.getMail_content())
                .mail_sender(sender)
                .mail_receiver(sender)
                .build();
        mailRepository.save(mail);
    }

}
