package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {


    public static String getCellData(int n,int m){ // apache POI provides java library to read and write xls file
        String value="";
        try {
            String excelPath = "./singleEmpRecord/empid.xlsx"; // path of xlsx file in project
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath); // created workbook
            XSSFSheet sheet = workbook.getSheetAt(0);// created a sheet
            sheet.getRow(n).getCell(m).setCellType(CellType.STRING); //  setting the cell type to string
            value = sheet.getRow(n).getCell(m).getStringCellValue(); // reading  value

        }catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }
/*
    public void getRowCount() throws IOException {
        try {

            String excelPath = "./singleEmpRecord/empid.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
          int rowCount = sheet.getPhysicalNumberOfRows();
          System.out.println("No Of Rows:"+ rowCount);
        }



        catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());

            exp.printStackTrace();
        }*/

    }






