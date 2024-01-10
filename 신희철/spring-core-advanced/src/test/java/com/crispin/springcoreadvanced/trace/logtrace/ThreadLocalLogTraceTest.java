package com.crispin.springcoreadvanced.trace.logtrace;

import com.crispin.springcoreadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void beginEndLevel2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void beginExceptionLevel2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());
    }

}