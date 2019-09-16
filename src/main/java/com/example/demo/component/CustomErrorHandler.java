package com.example.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class CustomErrorHandler implements ErrorHandler {
	Logger logger = LoggerFactory.getLogger(CustomErrorHandler.class);

	@Override
	public void handleError(Throwable throwable) {
		logger.error(throwable.getMessage());
	}
}
