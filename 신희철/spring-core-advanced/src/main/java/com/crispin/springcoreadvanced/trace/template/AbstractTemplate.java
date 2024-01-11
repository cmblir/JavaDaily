package com.crispin.springcoreadvanced.trace.template;

import com.crispin.springcoreadvanced.trace.TraceStatus;
import com.crispin.springcoreadvanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    protected AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception exception) {
            trace.exception(status, exception);
            throw exception;
        }
    }

    protected abstract T call();
}
