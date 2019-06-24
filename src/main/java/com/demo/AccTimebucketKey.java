package com.demo;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class AccTimebucketKey implements Serializable {

	@Column
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private String timeBucketDate;
	@Column
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private String timeBucket;
	@Column
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
	private String eventId;
	@Column
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
	private int timeslot;
	public String getTimeBucketDate() {
		return timeBucketDate;
	}
	public void setTimeBucketDate(String timeBucketDate) {
		this.timeBucketDate = timeBucketDate;
	}
	public String getTimeBucket() {
		return timeBucket;
	}
	public void setTimeBucket(String timeBucket) {
		this.timeBucket = timeBucket;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}
	
	
	
		
}
