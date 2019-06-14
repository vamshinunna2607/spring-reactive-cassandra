package com.demo;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value="time_bucket_summary")
public class TimeBucketSummary {

	@PrimaryKey
	@Column
	private TimeBucketSummaryKey bucketSummaryKey;
	@Column
	private String arn;
	@Column
	private String url;
	
	
	public TimeBucketSummaryKey getBucketSummaryKey() {
		return bucketSummaryKey;
	}
	public void setBucketSummaryKey(TimeBucketSummaryKey bucketSummaryKey) {
		this.bucketSummaryKey = bucketSummaryKey;
	}
	public String getArn() {
		return arn;
	}
	public void setArn(String arn) {
		this.arn = arn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
