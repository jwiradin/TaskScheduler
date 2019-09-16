package com.example.demo.component;

import com.example.demo.domain.Account;
import com.example.demo.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.StreamSupport;

@Component
public class Tasks {

	private final Logger logger = LoggerFactory.getLogger(DataReaderTask.class);

	@Autowired
	private AccountRepository accountRepository;

	@Scheduled(fixedDelay = 5000)
	public void getAccountCount(){
		Iterable<Account> accountList = accountRepository.findAll();

		logger.debug("Count {}", StreamSupport.stream(accountList.spliterator(), false).count());

	}

	@Scheduled(fixedDelay = 5000)
	public void updateAccount(){
		try{
			Account account = accountRepository.findById(1).get();

			account.setLastUpdate(new Date());
			logger.debug("Sleeping 3 seconds");
			Thread.sleep(3000);
			logger.debug("Updating account 1");
			accountRepository.save(account);
			logger.debug("Done");
			throw new JpaSystemException(new RuntimeException("Test"));
		} catch (InterruptedException ex){
			logger.error("interupted", ex);
		}
	}
}
