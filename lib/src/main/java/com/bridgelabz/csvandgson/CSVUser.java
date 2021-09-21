package com.bridgelabz.csvandgson;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
	@CsvBindByName
	private String name;
	
	@CsvBindByName (column = "email", required = true)
	private String email;
	
	@CsvBindByName (column = "phoneNo")
	private String phoneNo;
	
	@CsvBindByName
	private String country;
	
	public CSVUser() {

    }

    public CSVUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }
	
	@Override
	public String toString() {
		return "CSVUser{name='" + name +'\'' +", email='"+ email +'\'' + ", phoneNo='" + phoneNo + ", country='" + country +'\''+'}';
	}
	
	
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPhoneNo() {
		return this.phoneNo;
	}
	public String getCountry() {
		return this.country;
	}
}
