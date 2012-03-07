package com.alexander.concepts.hibernate.hibernatedemo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity //marks the object down as a persistent entity
@Table(name="ANNOTATED_EVENTS")
public class AnnotatedEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EVENT_ID")
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="EVENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public AnnotatedEvent(){
		//this is required by hibernate for reflective instantiation
	}
	
	public AnnotatedEvent(String title, Date date){
		//for application use, to create new events
		this.title = title;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
