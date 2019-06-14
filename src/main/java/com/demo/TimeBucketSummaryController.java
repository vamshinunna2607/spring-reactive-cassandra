package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TimeBucketSummaryController {

	@Autowired
	TimeBucketSummaryService bucketSummaryService;
	
	@GetMapping("/call")
	public Mono<TimeBucketSummary> findTimeBucket(@RequestParam(name = "timebucketdate") String timeBucketDate, @RequestParam(name = "timebucket") String timeBucket,@RequestParam(name="eventid") String eventId){
		return bucketSummaryService.getTimeBucket(timeBucketDate, timeBucket, eventId);
	}
	
	@GetMapping("/ball")
	public Flux<TimeBucketSummary> findTimeBuckets(@RequestParam(name = "timebucketdate") String timeBucketDate, @RequestParam(name = "timebucket") String timeBucket){
		return bucketSummaryService.findTimeBuckets(timeBucketDate, timeBucket);
	}
	
	@GetMapping("/doll")
	public Flux<TimeBucketSummary> findTimeBucketsPage(@RequestParam(name = "timebucketdate") String timeBucketDate, @RequestParam(name = "timebucket") String timeBucket){
		return bucketSummaryService.findTimeBucketsPage(timeBucketDate, timeBucket,PageRequest.of(1,2));
	}
}
