package org.thibaut.thelibrary.service.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class CheckLoanScheduler {

	@Scheduled(fixedRate = 1000)
	public void scheduleFixedRateTask() {
		System.out.println(
				"Fixed rate task - " + System.currentTimeMillis() / 1000);
	}
}
