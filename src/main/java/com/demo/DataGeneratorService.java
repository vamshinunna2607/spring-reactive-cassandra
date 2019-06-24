package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGeneratorService {
	
	SimpleDateFormat time = new SimpleDateFormat("HH:mm");
	SimpleDateFormat date = new SimpleDateFormat("MM/DD/yyyy");
	
	@Autowired
	AccTimebucketRepo accTimebucketRepo;

	public int createRandomIntBetween(long start, long end) {
		return (int) (start + (int) Math.round(Math.random() * (end - start)));
	}

	@PostConstruct
	public void run() {
		System.out.println("Data generation started");
		final int recordCount = 1000;
		long now =  System.currentTimeMillis();
		long _24HrsInMilli = TimeUnit.MILLISECONDS.convert(24, TimeUnit.HOURS);
		long start = now- _24HrsInMilli;
		long end = now + _24HrsInMilli; 
		for (int i = 1; i <= recordCount; i++) {
			long dateTime = createRandomIntBetween(start, end);
			Date dt = new Date(dateTime);
			String timeBucket = time.format(dt);
			String timeBucketDate = date.format(dt);
			AccTimebucketKey key = new AccTimebucketKey();
			key.setEventId(UUID.randomUUID().toString());
			key.setTimeBucket(timeBucket);
			key.setTimeBucketDate(timeBucketDate);
			key.setTimeslot(createRandomIntBetween(1, 120));
			AccTimebucket accTimebucket = new AccTimebucket();
			accTimebucket.setAccTimebucketKey(key);
			
			accTimebucket.setArn(RandomStringUtils.random(16, false, true));
			accTimebucket.setEventtime(dt);
			accTimebucket.setPayload("PAYLOAD");
			accTimebucket.setStatus((i%2==0)?"SUCCESS":"FAILURE");
			AccTimebucket returnAcc = accTimebucketRepo.save(accTimebucket);
			System.out.println("saved record" + i + " "+ returnAcc.getStatus());
		}
		System.out.println("Data generation complete");
		
	}
}
