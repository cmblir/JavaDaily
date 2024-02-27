package hello.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldServiceTest {

	private FieldService fieldService = new FieldService();

	@Test
	void field() {
		log.info("main start");
		Runnable userA = () -> {
			fieldService.logic("userA");
		};
		
		Runnable userB = () -> {
			fieldService.logic("userB");
		};
		
		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
		//sleep(2000);	//동시성 문제 발생 x
		sleep(100);		//동시성 문제 발생 o	
		threadB.start();
		sleep(2000);
	}
	
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
