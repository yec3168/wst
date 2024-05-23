package com.tool.wst.mail.controller;

import com.tool.wst.mail.dto.MailFormDto;
import com.tool.wst.mail.service.MailService;
import com.tool.wst.user.entity.Member;
import com.tool.wst.user.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MailService mailService;

    @GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
    public String mailList(Principal principal)throws Exception{
        if(principal != null) {
            Member member = memberService.findMemberByEmail(principal.getName());
        }

        return "mail/List";
    }

    @GetMapping("/write")
    @PreAuthorize("isAuthenticated()")
    public String mailWrite(Principal principal, Model model)throws Exception{
        model.addAttribute("mailFormDto", new MailFormDto());
        return "mail/Write";
    }

    @PostMapping("/write")
    @PreAuthorize("isAuthenticated()")
    public String mailWrite(@RequestParam(value = "type", defaultValue = "you") String boardSort,
                            MailFormDto mailFormDto, Model model, Principal principal){

        Member sender = memberService.findMemberByEmail(principal.getName());
        if(mailFormDto.getMail_receiver() == null){
            // 1. 내게 쓰기
            mailService.toMeSave(mailFormDto, sender.getEmail());
        }
        else{
            // 2. 상대방한태 보내기.
            mailService.mailSave(mailFormDto, sender.getEmail());
        }


        return "redirect:/mail/list";
    }

}
