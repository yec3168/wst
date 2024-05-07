package com.tool.wst.user.controller;

import com.tool.wst.user.dto.RegisterFormDto;
import com.tool.wst.user.entity.Member;
import com.tool.wst.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입
    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("registerFormDto", new RegisterFormDto());
        return "member/Register";
    }

    @PostMapping("/sign-up")
    public String signUp(RegisterFormDto registerFormDto,
                         @RequestParam("photoFile") MultipartFile photoFile,
                         Model model){
        System.out.println("memberFormDto.getName() = " + registerFormDto.getName());
        Member user = memberService.save(registerFormDto, photoFile);
        if(user == null){
            model.addAttribute("msg", "회원가입에 실패했습니다.");
            return "redirect:/error";
        }
        return "redirect:/member/sign-in";
    }

    //로그인
    @GetMapping("/sign-in")
    public String signIn(){
        return "member/SignIn";
    }

    // db에 등록된 회사리스트 가져오기. (임시데이터)
    @GetMapping("/company-list")
    @ResponseBody
    public List<String> getCompanyList(){
        List<String> company_list = new ArrayList<>();
        for(int i =0; i < 10; i++){
            company_list.add("회사"+(i+1));
        }
        return company_list;
    }
}
