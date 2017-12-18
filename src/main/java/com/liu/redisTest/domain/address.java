package com.liu.redisTest.domain;

import java.io.Serializable;

public class address implements Serializable{
    private Long id;

    private String country;

    private String province;

    private String city;

    private String street;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }
}