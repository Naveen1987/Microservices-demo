package com.example.demo.std;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
	private Long sid;
	private String sname;
	private Double sfee;
	private String createdBy;
	private LocalDateTime createdOn;
	private String lastModifiedby;
	private LocalDateTime lastModifiedOn;
	private String msg;
	public Long getSid() {
		return sid;
	}
	public StudentDto setSid(Long sid) {
		this.sid = sid;
		return this;
	}
	public String getSname() {
		return sname;
	}
	public StudentDto setSname(String sname) {
		this.sname = sname;
		return this;
	}
	public Double getSfee() {
		return sfee;
	}
	public StudentDto setSfee(Double sfee) {
		this.sfee = sfee;
		return this;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public StudentDto setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public StudentDto setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	public String getLastModifiedby() {
		return lastModifiedby;
	}
	public StudentDto setLastModifiedby(String lastModifiedby) {
		this.lastModifiedby = lastModifiedby;
		return this;
	}
	public LocalDateTime getLastModifiedOn() {
		return lastModifiedOn;
	}
	public StudentDto setLastModifiedOn(LocalDateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public StudentDto setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", sname=" + sname + ", sfee=" + sfee + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", lastModifiedby=" + lastModifiedby + ", lastModifiedOn="
				+ lastModifiedOn + ", msg=" + msg + "]";
	}
	
}
