package com.demo;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TimeBucketSummaryService {

	@Autowired
	TimeBucketSummaryRepo bucketSummaryRepo;
	
	public Mono<TimeBucketSummary> getTimeBucket(String timeBucketDate, String timeBucket, String eventId) {
		Mono<TimeBucketSummary> tbs =  bucketSummaryRepo.findById(new TimeBucketSummaryKey(timeBucketDate,timeBucket,eventId));
		System.out.println("I am not blocked" + Thread.currentThread().getName());
		return tbs;
	}
	
	public Flux<TimeBucketSummary> findTimeBuckets(String timeBucketDate, String timeBucket){
		System.out.println("Blocked" + Thread.currentThread().getName());
		Flux<TimeBucketSummary> tbsList =  bucketSummaryRepo.findByBucketSummaryKeyTimeBucketDateAndBucketSummaryKeyTimeBucket(timeBucketDate, timeBucket);
		return tbsList.delayElements(Duration.ofMinutes(1));
		
	}
	
	public Flux<TimeBucketSummary> findTimeBucketsPage(String timeBucketDate, String timeBucket, Pageable page){
		return bucketSummaryRepo.findByBucketSummaryKeyTimeBucketDateAndBucketSummaryKeyTimeBucket(timeBucketDate, timeBucket,page);
	}
}
