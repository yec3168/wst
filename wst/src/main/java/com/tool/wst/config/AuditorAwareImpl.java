package com.solution.pmt.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        // 현재 로그인한 사용자 정보 가져옴.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 정보 저장.
        String userId = "";
        if(authentication != null)
            userId =authentication.getName(); // email을 저장.

        return Optional.of(userId);
    }
}
