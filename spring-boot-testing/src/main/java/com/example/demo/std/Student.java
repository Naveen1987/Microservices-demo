package com.example.demo.std;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seqStudent", sequenceName = "seq_student")
	@GeneratedValue(generator = "seqStudent", strategy = GenerationType.SEQUENCE)
	private Long sid;
	@NotEmpty(message="Name required")
	private String sname;
	@NotNull(message="Fee is required")
	private Double sfee;
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private LocalDateTime createdOn;
	@LastModifiedBy
	private String lastModifiedby;
	@LastModifiedDate
	private LocalDateTime lastModifiedOn;
	public Long getSid() {
		return sid;
	}
	public Student setSid(Long sid) {
		this.sid = sid;
		return this;
	}
	public String getSname() {
		return sname;
	}
	public Student setSname(String sname) {
		this.sname = sname;
		return this;
	}
	public Double getSfee() {
		return sfee;
	}
	public Student setSfee(Double sfee) {
		this.sfee = sfee;
		return this;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Student setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public Student setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	public String getLastModifiedby() {
		return lastModifiedby;
	}
	public Student setLastModifiedby(String lastModifiedby) {
		this.lastModifiedby = lastModifiedby;
		return this;
	}
	public LocalDateTime getLastModifiedOn() {
		return lastModifiedOn;
	}
	public Student setLastModifiedOn(LocalDateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
		return this;
	}
	
}
