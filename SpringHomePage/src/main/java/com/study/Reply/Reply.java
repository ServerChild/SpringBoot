package com.study.Reply;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Reply {
	@Id
	@GeneratedValue
	private Long rno;
	
	private String rname;
	
	private String rcontent;
	
	private Long refBno;
	
	@CreatedDate
	@Column(name="create_rdate")
	private LocalDateTime redate;
	

	public Reply() { }
	
	public Reply(String rname, String rcontent, LocalDateTime redate) {
		this.rname = rname;
		this.rcontent = rcontent;
		this.redate = redate;
	}
	
	
}
