package com.bridgelabz.csvandgson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
public class JsonDataExample {
 
	private static final String SAMPLE_CSV_FILE_PATH = "csv-example.csv";
	private static final String SAMPLE_JSON_FILE_PATH = "json-example.json";
	
	public static void main(String[] args){
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			CsvToBeanBuilder<CSVUser> csvToBeabBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeabBuilder.withType(CSVUser.class);
			csvToBeabBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVUser> csvToBean = csvToBeabBuilder.build();
			List<CSVUser> csvUsers = csvToBean.parse();
			Gson gson = new Gson();
			String json = gson.toJson(csvUsers);
			FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
			CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
			List<CSVUser> csvUSerList = Arrays.asList(usrObj);
			System.out.println(csvUSerList);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
