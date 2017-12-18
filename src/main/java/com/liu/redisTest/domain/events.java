package com.liu.redisTest.domain;

import java.io.Serializable;
import java.util.Date;

public class events implements Serializable{
    private Long id;

    private String title;

    private Date date;

    private person person;
    
    
    
    public person getPerson() {
		return person;
	}

	public void setPerson(person person) {
		this.person = person;
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
        this.title = title == null ? null : title.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}