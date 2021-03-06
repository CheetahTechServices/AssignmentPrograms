package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Lib implements IAutoConstant
{
	public static Workbook wb;
	public static String getPropertyValue(String propertyName)
	{
		Properties prop=new Properties();
		String propertyValue="";
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue = prop.getProperty(propertyName);
		} catch (Exception e) { } 
		return propertyValue;
	}

	public static String getCellValue(String sheet,int rowNum,int colNum)
	{
		String cellValue="";
		try {
			wb=WorkbookFactory.create(new FileInputStream(EXCEl_PATH));
			cellValue=wb.getSheet(sheet).getRow(rowNum).getCell(colNum).toString();
		} catch (Exception e) {	}
		return cellValue;

	}
	public static int getRowCount(String sheet)
	{
		int rowCount=0;
		try {
			wb=WorkbookFactory.create(new FileInputStream(EXCEl_PATH));
			rowCount=wb.getSheet(sheet).getLastRowNum();
		} catch(Exception e) {	}
		return rowCount;
	}
	public static void getScreenshot(WebDriver driver,String methodName)
	{
		Date d=new Date();
		String dateAndTime = d.toString().replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String name=SCREENSHOT_PATH+methodName+dateAndTime+".png";
		System.out.println(name);
		File destFile=new File(name);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			Reporter.log("Screenshot Taken Failed",true);
		}
	}
}
