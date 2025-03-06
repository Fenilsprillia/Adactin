package org.base;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileReader;
	import java.io.IOException;
	import java.math.BigDecimal;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Properties;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Baseclassjunit {
		public static WebDriver driver;
		Select select;
		Actions actions;
	//Launch the web browser
		public void launch() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
	//Maximize the windows
		public void maxim() {
			driver.manage().window().maximize();
		}
	//launch website
		public void website(String url) {
			driver.get(url);
			}
	//take screenshot
		public void screenshot(String name) {
			try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target=new File("C:\\Users\\admin\\eclipse-workspace\\intro\\screenshot\\"+name+".png");
			FileUtils.copyFile(source, target);
			} catch (IOException e) {
				e.printStackTrace();
			}}
	//to get text
		public void text(WebElement element) {
			System.out.println(element.getText());
		}
	//credentials
		public void sendkeysByJava(WebElement e,String keysToSend ) {
			e.sendKeys(keysToSend);
		}
	//click
		public void click(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()",e);
	     }
		
		public void sendKeysByJSE(WebElement e , String keysToSend) {
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','"+keysToSend+"')",e);

		}
	//windows handling
		public void window(int index) {
			String homepage = driver.getWindowHandle();
			Set<String> childwindowHandles = driver.getWindowHandles();
			List<String> li=new LinkedList<String>();
			li.addAll(childwindowHandles);
			String windowsid = li.get(index);
			driver.switchTo().window(windowsid);
			}
	//control has to switch from current window to exact window
		public void switchToFrames(WebElement frameRefElement) {
			driver.switchTo().frame(frameRefElement);
		}
	//selector
		public void required(WebElement element,String searchby,String value) {
			select=new Select(element);
			switch (searchby) {
			case "value":
				select.selectByValue(value);
				break;
	        case "text":
				select.selectByVisibleText(value);
				break;
	        default:
				break;
			}

		}
	//sleep
		public void sleep(long millis) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
	//alert
		public void confirmalert(String ok_cancel) {
			switch (ok_cancel) {
			case "ok":
				driver.switchTo().alert().accept();
				break;
			case "cancel":
				driver.switchTo().alert().dismiss();
				break;

			default:
				break;
			}
			
		}
		public void promptAlert(String keysToSend, String accept_dismiss) {

			driver.switchTo().alert().sendKeys(keysToSend);

			switch (accept_dismiss) {

			case "accept":
				driver.switchTo().alert().accept();
				break;

			case "dismiss":
				driver.switchTo().alert().dismiss();
				break;

			default:
				break;
			}
		}
	//Actions
		public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {

			actions = new Actions(driver);

			actions.dragAndDrop(sourceElement, targetElement).build().perform();

		}

		public void mouseOverACtions(WebElement targetElement) {

			actions = new Actions(driver);

			actions.moveToElement(targetElement).build().perform();
		}
	//To read data from excel
		public static String getDataFromWorkbook(String sheetName, int rownum, int cellnum) {

			String value = null;

			try {

				// To Locate Where the Workbook (Excel)
				File file = new File("excel\\inputDatas.xlsx");

				// To get File as a Input
				FileInputStream fileInputStream = new FileInputStream(file); // throws FileNotFoundException

				// To Define Workbook XSSFWorkbook || HSSFWorkbook'
				Workbook book = new XSSFWorkbook(fileInputStream); // throws IOException

				// to get sheet from book
				Sheet sheet = book.getSheet(sheetName);

				// To get Row from Sheet
				Row row = sheet.getRow(rownum);

				// To get Cell from Row
				Cell cell = row.getCell(cellnum);

				// To Define Cell Type
				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:
					// to get String value from Cell
					value = cell.getStringCellValue();

					break;

				case NUMERIC:

					// to get Date format numeric value
					if (DateUtil.isCellDateFormatted(cell)) {

						// to get Date cell value from Cell
						Date dateCellValue = cell.getDateCellValue();

						// To define Date Format for our desired
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
						value = simpleDateFormat.format(dateCellValue);

					} else {

						// To get numeric value
						double numericCellValue = cell.getNumericCellValue();
						// To convert numeric double into BigDecimal
						BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
						// To Convert BigDecimal to String
						value = valueOf.toString();

					}

					break;

				default:
					break;
				}

			} catch (Exception e) {

			}

			return value;
		}
	//Properties file

		public static String getDataFromProperties(String propertyKey) {

			String property = null;

			try {

				// To Locate where the properties file will be
				File file = new File("DataBase\\Config.properties");

				// To read the File
				FileReader fileReader = new FileReader(file); // Throws FileNotFoundException

				// To Define Properties File Class by using Object
				Properties properties = new Properties();

				// To Load File into Properties Class
				properties.load(fileReader); // throws IOException

				// To get required / desired value from File by using key
				property = properties.getProperty(propertyKey);

			} catch (Exception e) {

			}

			return property;

		}


		
	}





