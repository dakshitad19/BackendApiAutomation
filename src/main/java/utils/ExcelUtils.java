package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {


    public static String getCellData(int n,int m){
        String value="";
        try {
            String excelPath = "./singleEmpRecord/empid.xlsx"; // path of xlsx file in project
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheetAt(0);
            sheet.getRow(n).getCell(m).setCellType(CellType.STRING);
            value = sheet.getRow(n).getCell(m).getStringCellValue();

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






