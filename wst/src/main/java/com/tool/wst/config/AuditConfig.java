package com.solution.pmt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // Auditing 기능을 활성화.
public class AuditConfig {

    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
