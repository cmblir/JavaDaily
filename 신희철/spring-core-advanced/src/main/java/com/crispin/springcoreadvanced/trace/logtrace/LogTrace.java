package com.crispin.springcoreadvanced.trace.logtrace;

import com.crispin.springcoreadvanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception exception);
}
