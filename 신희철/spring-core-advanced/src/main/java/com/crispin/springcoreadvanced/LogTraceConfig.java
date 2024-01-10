package com.crispin.springcoreadvanced;

import com.crispin.springcoreadvanced.trace.logtrace.LogTrace;
import com.crispin.springcoreadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
