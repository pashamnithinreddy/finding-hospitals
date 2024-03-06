package BasePackage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtilities {
	public static File file2;
	public static FileOutputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow r1;
 
	public static void excelInit() throws FileNotFoundException
	{
	    file2 =new File(System.getProperty("user.dir")+"\\Excel\\data.xlsx");
        file = new FileOutputStream(file2);
        workbook=new XSSFWorkbook();
        sheet=workbook.createSheet();
	}
	
	public static XSSFRow createRow(int j) {
		return sheet.createRow(j);
	}
	
	public static void setData(XSSFRow r1,int j,String data)
	{
		r1.createCell(j).setCellValue(data);
	}
	public static void closeExcel() throws IOException
	{
		  workbook.write(file);
		  workbook.close();
		  file.close();
	}
}
