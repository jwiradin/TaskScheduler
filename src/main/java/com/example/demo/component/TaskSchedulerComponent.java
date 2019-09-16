package com.example.demo.component;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedulerComponent  {

	@Bean
	ThreadPoolTaskScheduler scheduler(){
		ThreadPoolTaskScheduler result = new ThreadPoolTaskScheduler();
		result.setPoolSize(3);
		return result;
	}

}
