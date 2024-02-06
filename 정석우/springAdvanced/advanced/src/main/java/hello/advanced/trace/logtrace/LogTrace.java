package hello.advanced.trace.logtrace;

import org.springframework.stereotype.Component;

import hello.advanced.trace.TraceStatus;

public interface LogTrace {

	TraceStatus begin(String message);
	
	void end(TraceStatus status);
	
	void exception(TraceStatus status, Exception e);
}
