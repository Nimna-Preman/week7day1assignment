package week7day1assignment;


	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Parameters;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClassDataProvider {
	public ChromeDriver driver;
		public String fileName;
		public String sheetName;
		@Parameters({"url","username","password"})
		@BeforeMethod
		public void preCondition( String url, String username, String password) throws InterruptedException
		{
		      
			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			
			
				driver.get(url);
				driver.manage().window().maximize();
				
				
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.className("decorativeSubmit")).click();
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 driver.findElement(By.linkText("Leads")).click();
			
		}
		
		@DataProvider(name="importData")
		public String[][] setDataFile() throws IOException
		{
			return Importdata.excelData(fileName,sheetName);
		}
		@AfterMethod
		public void postConditon()
		{
			driver.close();
		}

	}


