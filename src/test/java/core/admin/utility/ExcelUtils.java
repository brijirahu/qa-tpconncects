package core.admin.utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import static core.admin.tests.initTest .testDataExcelFileName;

public class ExcelUtils {

    //Main Directory of the project
    public static final String currentDir = System.getProperty("user.dir");

    //Location of Test data excel file
    public static String testDataExcelPath = currentDir + "\\src\\test\\testData\\";
    //Excel WorkBook
    private static XSSFWorkbook excelWBook;
    //Excel Sheet
    private static XSSFSheet excelWSheet;
    //Excel cell
    private static XSSFCell cell;
    //Excel row
    private static XSSFRow row;
    //Row Number
    public static int rowNumber;
    //Column Number
    public static int columnNumber;

//    static Object data[][];

    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }
    public static int getRowNumber() {
        return rowNumber;
    }
    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }
    public static int getColumnNumber() {
        return columnNumber;
    }
    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    public static void setExcelFileSheet( String sheetName) {


            try {
            // Open the Excel file
                FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
                excelWBook = new XSSFWorkbook(ExcelFile);
                excelWSheet = excelWBook.getSheet(sheetName);
            } catch (Exception e) {
                try {
                    throw (e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

    }

    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public static String getCellData(int RowNum, int ColNum) {
        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            System.out.println("cell value" + cellData);
            return cellData;
        } catch (Exception e) {
            throw (e);
        }
    }

    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }

    //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData( String value, int RowNum, int ColNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static String getTestCaseName(String sTestCase){

        String value = sTestCase;

        try{

            int posi = value.indexOf("@");

            value = value.substring(0, posi);

            posi = value.lastIndexOf(".");

            value = value.substring(posi + 1);

            return value;

        }catch (Exception e){

            throw (e);

        }

    }

    public static String[][] getData(String sheetName, String testCaseName){

        System.out.println("Inside getData excel");
        String[][] tabArray = null;
        try {
        FileInputStream file = new FileInputStream(currentDir + "\\src\\test\\testData\\TestData.xlsx");

            XSSFWorkbook workbook = null;
            int ci,cj;
            workbook = new XSSFWorkbook(file);
            // taking the firstSheet
            XSSFSheet sheet = workbook.getSheet(sheetName);
            System.out.println("rows -- " + sheet.getPhysicalNumberOfRows());
            // this give total ROWS in the sheet
            /**
             * For data generator each row should have equal number of columns
             * Total number of rows = number of times test gets executed total
             * number of column = number of argument in test method
             */
        //  int totalRows = sheet.getLastRowNum()-sheet.getFirstRowNum();
            int totalRows = sheet.getLastRowNum();
            System.out.println(totalRows);
            int totalCols = 1;
            int startRow = 1;
            int startCol = 1;

            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow;i <= totalRows; i++, ci++) {
                cj=0;
                for (int j=startCol;j <= totalCols; j++, cj++){
                    tabArray[ci][cj] = getCellData(i,j);
                    System.out.println( "tabarray value -- "+tabArray[ci][cj]);
                }

            }

//            for (int i=1; i <= sheet.getPhysicalNumberOfRows()-1; i++) {
//
//                    System.out.println(" cell value " + sheet.getRow(i).getCell(0).getStringCellValue());
//                    if (sheet.getRow(i).getCell(0).getStringCellValue().contains(testCaseName)) {
//
//                        int totalColumns = sheet.getRow(i).getPhysicalNumberOfCells();
//
//                        System.out.println(totalColumns-1);
//                        //0 is testcase name, so starting from 1
//                        for (int j = 1; j <= totalColumns-1; j++) {
//                            XSSFCell x = sheet.getRow(i).getCell(j);
//                            if (x != null) {
////                                x.setCellType(Cell.CELL_TYPE_STRING);
//                                System.out.println(x.getStringCellValue());
//                                System.out.print(i);
//                                System.out.println(j);
//                                data[i][j] = x.getStringCellValue();
//                            }
//                        }
//
//                    }
//
//                }

        } catch ( IOException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tabArray;
    }
}


