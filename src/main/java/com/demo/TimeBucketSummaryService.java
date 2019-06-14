package com.demo;

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
		return bucketSummaryRepo.findById(new TimeBucketSummaryKey(timeBucketDate,timeBucket,eventId));
	}
	
	public Flux<TimeBucketSummary> findTimeBuckets(String timeBucketDate, String timeBucket){
		return bucketSummaryRepo.findByBucketSummaryKeyTimeBucketDateAndBucketSummaryKeyTimeBucket(timeBucketDate, timeBucket);
	}
	
	public Flux<TimeBucketSummary> findTimeBucketsPage(String timeBucketDate, String timeBucket, Pageable page){
		return bucketSummaryRepo.findByBucketSummaryKeyTimeBucketDateAndBucketSummaryKeyTimeBucket(timeBucketDate, timeBucket,page);
	}
}
