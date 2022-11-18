package week7day1assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BaseClassDataProvider
		{
			@Test(dataProvider="importData")
			public void createLead(String companyName,String firstName, String lastName)  throws InterruptedException 
			{
				
				
   driver.findElement(By.linkText("Create Lead")).click();
   driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
   driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
   driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
   driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Nimna");
   driver.findElement(By.name("departmentName")).sendKeys("Software Testing");
   driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium WebDriver");
   driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("nimna123@gmail.com");
   driver.findElement(By.name("submitButton")).click();
			
				String title = driver.getTitle();
				System.out.println("Title of the webpage is "+title);
				
			}
			
			@BeforeTest
			public void importData()
			{
				fileName="TestData";
				sheetName="CreateLead";
			
				
			}

	}


