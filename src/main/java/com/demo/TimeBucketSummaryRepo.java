package com.demo;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import reactor.core.publisher.Flux;
import org.springframework.data.domain.Pageable;

public interface TimeBucketSummaryRepo extends ReactiveCassandraRepository<TimeBucketSummary, TimeBucketSummaryKey> {

public Flux<TimeBucketSummary> findByBucketSummaryKeyTimeBucketDateAndBucketSummaryKeyTimeBucket(String timeBucketDate, String timeBucket);

public Flux<TimeBucketSummary> findByBucketSummaryKeyTimeBucketDateAndBucketSummaryKeyTimeBucket(String timeBucketDate, String timeBucket, Pageable page);

}
