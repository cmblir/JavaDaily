package com.crispin.springcoreadvanced;

import com.crispin.springcoreadvanced.trace.logtrace.FieldLogTrace;
import com.crispin.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
