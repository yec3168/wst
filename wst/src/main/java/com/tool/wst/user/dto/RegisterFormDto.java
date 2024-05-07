package com.tool.wst.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public class RegisterFormDto {
    private String company_id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;

}
