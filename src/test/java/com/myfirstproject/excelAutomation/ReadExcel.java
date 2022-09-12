package com.myfirstproject.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {

//        Import the apache poi dependency in your pom file
//        Create resources directory under java folder(right click on java and create the folder)
//        Add the excel file on the resources folder
//        Create a new package: excelautomation
//        Create a new class : ReadExcel
//        Create a new test method : readExcel()
//        Store the path of the  file in a string
//        Open the file
//        Open the workbook using fileinputstream
//        Open the first worksheet
//        Go to first row


// or        String path="./src/test/java/resources/capitals.xlsx";
        String path = ".\\src\\test\\java\\resources\\capitals.xlsx";
// or   String path="C:\\Users\\nm.kljöm\\IdeaProjects\\myseleniumproject\\src\\test\\java\\resources\\capitals.xlsx";


    // accessing the excel file
        FileInputStream fileInputStream=new FileInputStream(path);

    // open the workbook
        Workbook workbook= WorkbookFactory.create(fileInputStream);

    //Open the first worksheet
        //Sheet sheet1= workbook.getSheet("Sheet1");  // reach by name; case sensitive
        Sheet sheet1= workbook.getSheetAt(0);   // reach by index; starts from 0

    //Go to first row
        Row row1=sheet1.getRow(0); // reach by index; starts from 0

    //Go to first cell
//        Go to first cell on that first row and print
        Cell cell1=row1.getCell(0);     // reach by index; starts from 0
        System.out.println(cell1);  //Country

//        Go to second cell on that first row and print
        Cell r1c2=row1.getCell(1);
        System.out.println(r1c2);   //Capital

//        Go to 2nd row first cell  and assert if the data equal to USA
        String r2c1=sheet1.getRow(1).getCell(0).toString();
        System.out.println(r2c1);   //USA
        Assert.assertEquals(r2c1,"USA");

//        Go to 3rd row 2nd cell-chain the row and cell
        Cell r3c2=sheet1.getRow(2).getCell(1);
        System.out.println(r3c2);   //Ottowa

//        Find the number of  rows
        int numOfRows=sheet1.getLastRowNum()+1;   // index starts from 0
        System.out.println("Number of Rows: "+numOfRows);              // counts including empty rows

//        Find the number of used rows
        int numUsedRows=sheet1.getPhysicalNumberOfRows();   // index starts from 1
        System.out.println("Number of Used Rows: "+numUsedRows);            // will count only data inserted rows

//        Print country, capitol key value pairs as map object
        Map<String,String> capitals=new HashMap<>();
    // we need loop to get the data
        for (int rowNum=1;rowNum< numOfRows;rowNum++) {
            String country=sheet1.getRow(rowNum).getCell(0).toString();
            System.out.println(country);
            String capital=sheet1.getRow(rowNum).getCell(1).toString();
            System.out.println(capital);
        capitals.put(country,capital);

        }
        System.out.println(capitals);
    }
}
