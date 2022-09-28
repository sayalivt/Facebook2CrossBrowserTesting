package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Utility
{
	//How to capture screenshot
	public static void captureScreenshot(int testID,WebDriver driver) throws IOException, InterruptedException
	{	
		String value=new SimpleDateFormat("yyyy_MM_dd hh-mm-ss").format(new Date());
		TakesScreenshot take =(TakesScreenshot)driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Screenshot File\\DateAndTime\\test"+testID+" "+value+".jpeg");//png//jpg//jpeg"
		FileHandler.copy(src, dest);
		Thread.sleep(3000);
		String FileName = value.toString().replace("_", "/").replace("-", ":").replace("_", " ");
		System.out.println(FileName);
	}

//How to fetch data from Excel sheet in Application	
	public static String fetchDataFromExcel(String sheet,int row,int cell) throws IOException
	{
		try
		{
		String path="C:\\Users\\DELL\\Desktop\\Test.xlsx";
		FileInputStream file=new FileInputStream(path);
		String value=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		//System.out.println(value);
		return value;
		}
		catch(IllegalStateException e)
		{
			String path="C:\\Users\\DELL\\Desktop\\Test.xlsx";
			FileInputStream file=new FileInputStream(path);
			double value=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			String s=String.valueOf(value);
			//System.out.println(s);
			return s;			
		}
		/*catch(IllegalStateException e1)
		{
			String path="C:\\Users\\DELL\\Desktop\\Test.xlsx";
			FileInputStream file=new FileInputStream(path);
			Date date=WorkbookFactory.create(file).getSheet(sheet).getRow(a).getCell(i).getDateCellValue();
			String s1=String.valueOf(date);
			//System.out.println(s);
			return s1;
		}*/
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return sheet;
	}
}	



