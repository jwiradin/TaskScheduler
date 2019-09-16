package com.example.demo.component;

import com.example.demo.domain.Account;
import com.example.demo.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class DataReaderTask implements Runnable {

	@Autowired
	private AccountRepository accountRepository;

	private final Logger logger = LoggerFactory.getLogger(DataReaderTask.class);

	@Override
	public void run() {
			Iterable<Account> accountList = accountRepository.findAll();

			logger.debug("Count {}", StreamSupport.stream(accountList.spliterator(), false).count());
	}
}
