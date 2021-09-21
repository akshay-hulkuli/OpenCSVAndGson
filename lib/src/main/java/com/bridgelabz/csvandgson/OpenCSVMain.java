package com.bridgelabz.csvandgson;

import java.util.ArrayList;
import java.util.List;

public class OpenCSVMain {
	
	static OpenCSVServiceProvider openCSVServiceProvider = new OpenCSVServiceProvider();
	
	public static void writeData(List<CSVUser> myUsers) {
		
		try{
			openCSVServiceProvider.openCSVWriter(myUsers);
		}
		catch( Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void readDataByBean() {
	
		try{
			openCSVServiceProvider.openCSVReadAndParseToBean();
		}
		catch( Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readAllIntoString() {
		
		try{
			openCSVServiceProvider.readAll();
		}
		catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readData() {
		
			try{
				openCSVServiceProvider.openCSVReader();
			}
			catch( Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		 List<CSVUser> myUsers = new ArrayList<>();
         myUsers.add(new CSVUser("Sundar", "sundar@gmail.com", "+91-1111111111", "India"));
         myUsers.add(new CSVUser("Satya ", "satya@outlook.com", "+91-1111111112", "India"));
         
         writeData(myUsers);
         readData();
         readAllIntoString();
         readDataByBean();
         

	}
}
