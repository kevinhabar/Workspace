package com.accenture.createdb;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

public class CreateAccessDb {
	
	private static Database createDatabase(String databaseName) throws IOException {
       // return Database.create(new File(databaseName));
        
        File file = new File(databaseName);
        Database db = new DatabaseBuilder(file)
          .setFileFormat(Database.FileFormat.V2010)
          .create();
        return db;
    }

    private static TableBuilder createTable(String tableName) {
        return new TableBuilder(tableName);
    }

    public static void addColumn(Database database, TableBuilder tableName, String columnName, Types sqlType) throws SQLException, IOException {
        tableName.addColumn(new ColumnBuilder(columnName).setSQLType(Types.INTEGER).toColumn()).toTable(database);
    }

    public static void startDatabaseProcess() throws IOException, SQLException {
        String databaseName = "C:/Users/chandan.soni/Documents/Chandan_Java.accdb"; // Creating an MS Access database
       // String databaseName = " C:\\Users\\chandan.soni\\Documents\\Chandan_Java.accdb";
        Database database = createDatabase(databaseName);

        String tableName = "Employee"; // Creating table
        Table table = createTable(tableName)
                .addColumn(new ColumnBuilder("Emp_Id").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Emp_Name").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Emp_Employer").setSQLType(Types.VARCHAR).toColumn())
                .toTable(database);

        table.addRow(122875, "Sarath Kumar Sivan","Infosys Limited.");//Inserting values into the table
    }

    public static void main(String[] args) throws IOException, SQLException {
    	CreateAccessDb.startDatabaseProcess();
    }

}
