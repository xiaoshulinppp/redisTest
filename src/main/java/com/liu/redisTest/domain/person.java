package com.liu.redisTest.domain;

import java.io.Serializable;
import java.util.List;

public class person implements Serializable{
    private Long id;

    private String name;

    private Integer age;

    private Long addrId;
    
    private List<address> address;
    
    private events events;
    
    public events getEvents() {
		return events;
	}

	public void setEvents(events events) {
		this.events = events;
	}

	public List<address> getAddress() {
		return address;
	}

	public void setAddresslist(List<address> address) {
		this.address = address;
	}

	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getAddrId() {
        return addrId;
    }

    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }
}