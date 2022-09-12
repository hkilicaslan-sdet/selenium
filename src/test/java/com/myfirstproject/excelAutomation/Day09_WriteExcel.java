package com.myfirstproject.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_WriteExcel {
    @Test
    public void writeExcel() throws IOException {
//        Create a new class: WriteExcel
//        Create a new method: writeExcel()
//        Store the path of the file as string and open the file

        // Path of the workbook
        String path = ".\\src\\test\\java\\resources\\capitals.xlsx";

        // accessing the excel file
        FileInputStream fileInputStream=new FileInputStream(path);

        // open the workbook
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        //Sheet sheet1= workbook.getSheet("Sheet1");  // reach by name; case sensitive
        Sheet sheet1= workbook.getSheetAt(0);   // reach by index; starts from 0

        //Go to first row
        Row row1=sheet1.getRow(0); // reach by index; starts from 0

//        Create a cell on the 3rd column (2nd index) on the first row
        Cell r1c3=row1.createCell(2);

//        Write “POPULATION” on that cell
        r1c3.setCellValue("POPULATION");
//        Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet1.getRow(1).createCell(2).setCellValue("15000");
//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue("25000");
//        Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");
        sheet1.getRow(4).createCell(2).setCellValue("64000");
        sheet1.getRow(5).createCell(2).setCellValue("74000");
        sheet1.getRow(6).createCell(2).setCellValue("84000");

//        Write and save the workbook
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

//        Close the file
        fileInputStream.close();
        fileOutputStream.close();

//        Close the workbook
        workbook.close();
    }
}
