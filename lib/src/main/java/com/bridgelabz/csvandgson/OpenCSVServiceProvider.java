package com.bridgelabz.csvandgson;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class OpenCSVServiceProvider  {
	private static final String STRING_ARRAY_SAMPLE = "./csv-example.csv";
	List<CSVUser> myUsers = new ArrayList<>();
	public void openCSVWriter(List<CSVUser> listToBeWritten)throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException  {
		try( Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));) {

	            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
	                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	                    .build();
	           
		       beanToCsv.write(listToBeWritten); 	
		}
	}
	
	public  void openCSVReadAndParseToBean() throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(STRING_ARRAY_SAMPLE));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
	}

    public static void openCSVReader() throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(STRING_ARRAY_SAMPLE));
            CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
                System.out.println("==========================");
            }
        }
    }
    public static void readAll() throws IOException {
    	try (
    		Reader reader = Files.newBufferedReader(Paths.get(STRING_ARRAY_SAMPLE));
            CSVReader csvReader = new CSVReader(reader);
    	){
		    List<String[]> records = csvReader.readAll();
		    for (String[] record : records) {
		        System.out.println("Name : " + record[0]);
		        System.out.println("Email : " + record[1]);
		        System.out.println("Phone : " + record[2]);
		        System.out.println("Country : " + record[3]);
		        System.out.println("---------------------------");
		    }
    	}
    }
}
