package com.demo;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("acc_timebucket")
public class AccTimebucket {
	
	private String arn;
	private String status;
	private String payload;
	private Date eventtime;
	@PrimaryKey
	private AccTimebucketKey accTimebucketKey;
	
	
	public String getArn() {
		return arn;
	}
	public void setArn(String arn) {
		this.arn = arn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public Date getEventtime() {
		return eventtime;
	}
	public void setEventtime(Date eventtime) {
		this.eventtime = eventtime;
	}
	public AccTimebucketKey getAccTimebucketKey() {
		return accTimebucketKey;
	}
	public void setAccTimebucketKey(AccTimebucketKey accTimebucketKey) {
		this.accTimebucketKey = accTimebucketKey;
	}
	
	
	

}
