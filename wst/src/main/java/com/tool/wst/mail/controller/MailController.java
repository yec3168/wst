package com.tool.wst.mail.controller;

import com.tool.wst.mail.dto.MailFormDto;
import com.tool.wst.user.entity.Member;
import com.tool.wst.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MemberService memberService;

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
    public String mailWrite(@RequestParam(value = "type", defaultValue = "v1") String boardSort){
        return null;
    }

}
