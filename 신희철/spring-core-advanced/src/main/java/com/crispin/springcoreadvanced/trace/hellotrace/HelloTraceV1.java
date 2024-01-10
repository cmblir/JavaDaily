package com.crispin.springcoreadvanced.trace.hellotrace;

import com.crispin.springcoreadvanced.trace.TraceId;
import com.crispin.springcoreadvanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EXCEPTION_PREFIX = "<X-";

    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        long startTimeMillis = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMillis, message);
    }

    public void end(TraceStatus status) {
        complete(status, null);
    }

    public void exception(TraceStatus status, Exception exception) {
        complete(status, exception);
    }

    private void complete(TraceStatus status , Exception exception) {
        long stopTimeMillis = System.currentTimeMillis();
        long resultTimeMillis = stopTimeMillis - status.getStartTime();
        TraceId traceId = status.getTraceId();
        if (exception == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMillis);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EXCEPTION_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMillis, exception.getClass());
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stringBuilder.append( (i == level -1 ? "|" + prefix : "|   "));
        }
        return stringBuilder.toString();
    }
}
