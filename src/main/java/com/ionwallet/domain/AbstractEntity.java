package com.ionwallet.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.StringUtils;

import com.ionwallet.hibernate.jpa.utils.LocalDateTimeAttributeConverter;


@MappedSuperclass
public class AbstractEntity {

	@CreatedDate
	@Column(name = "CREATED_TS")
	@Convert(converter=LocalDateTimeAttributeConverter.class)
	protected LocalDateTime createdTime;

	@CreatedBy
	@Column(name = "CREATED_BY")
	protected String createdBy;

	@LastModifiedDate
	@Column(name = "UPDATED_TS")
	@Convert(converter=LocalDateTimeAttributeConverter.class)
	protected LocalDateTime updatedTime;

	@LastModifiedBy
	@Column(name = "UPDATED_BY")
	protected String updatedBy;

	@Version
	@Column(name = "VERSION", nullable = false)
	protected Long version;

	@PrePersist
	public void beforeCreate() {
		String authenticatedUser = "2";
		if (null != authenticatedUser) {
			this.createdBy = authenticatedUser;
		} else if (StringUtils.isEmpty(this.createdBy)) {
			this.createdBy = "1";
		}
		this.createdTime = LocalDateTime.now();
		this.updatedBy = null;
		this.updatedTime = null;
		}

	@PreUpdate
	public void beforeUpdate() {
		String authenticatedUser = "2";
		if(null!=authenticatedUser){
				this.updatedBy = authenticatedUser;
			}
		else if (StringUtils.isEmpty(this.updatedBy)) {
			this.updatedBy = "1";
		}
		this.updatedTime = LocalDateTime.now();
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getupdatedTime() {
		return updatedTime;
	}

	public void setupdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getVersion() {
		return version;
	}

	/**
	 * Performs optimistic locking
	 *
	 * @param version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	
}
