package com.accenture.createdb;

import java.io.File;
import java.io.IOException;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Database.FileFormat;
import com.healthmarketscience.jackcess.DatabaseBuilder;

public class Runner {

	    public static void main(String[] args) {
	        String dbPath = "C:\\Users\\chandan.soni\\Documents\\Chandan_Java.accdb";
	        // using try-with-resources is recommended to ensure that 
	        //   the Database object will be closed properly
	        try (Database db = DatabaseBuilder.create(FileFormat.V2010, new File(dbPath))) {
	            System.out.println("The database file has been created.");
	        } catch (IOException ioe) {
	            ioe.printStackTrace(System.err);
	        }

	    }

}
