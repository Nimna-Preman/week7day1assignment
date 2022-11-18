package week7day1assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClassDataProvider
	{
		@Test(dataProvider="importData")
		public void deleteLead(String company_Name,String first_Name, String last_Name, String country_Code, String area_Code, String primary_Code,String countryCode_1, String area_Code1, String primary_Code1) throws InterruptedException
		{
			
			
			//Create Leads with phone number
			
	 driver.findElement(By.linkText("Create Lead")).click();
	 driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company_Name);
	 driver.findElement(By.id("createLeadForm_firstName")).sendKeys(first_Name);
	 driver.findElement(By.id("createLeadForm_lastName")).sendKeys(last_Name);
     driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys(country_Code);
	 driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys(area_Code);
	 driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(primary_Code);
	 driver.findElement(By.name("submitButton")).click();
	 driver.findElement(By.linkText("Find Leads")).click();
	 driver.findElement(By.xpath("//span[text()='Phone']")).click();
	 driver.findElement(By.xpath("(//input[contains(@name,'Country')])[4]")).sendKeys(countryCode_1);
	 driver.findElement(By.xpath("(//input[contains(@name,'Area')])[4]")).sendKeys(area_Code1);
	 driver.findElement(By.xpath("(//input[contains(@name,'Number')])[4]")).sendKeys(primary_Code1);
	 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	driver.findElement(By.xpath("(//div[contains(@class,'cell-inner')]/child::a[@class='linktext'])[1]"));
			WebElement firstResultingLead = null;
			String resultingLead = firstResultingLead.getText();
			System.out.println("Lead ID of First Resulting Lead "+resultingLead);
			
	 driver.findElement(By.xpath("(//div[contains(@class,'cell-inner')]/child::a[@class='linktext'])[1]")).click();
	 driver.findElement(By.xpath("//a[text()='Delete']")).click();
	 driver.findElement(By.linkText("Find Leads")).click();
	 driver.findElement(By.xpath("//input[@name='id']")).sendKeys(resultingLead);
	 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
     driver.findElement(By.xpath("//div[text()='No records to display']"));
			WebElement verifyMessage = null;
			String recordsDisplay = verifyMessage.getText();
			System.out.println("Successful Deletion "+recordsDisplay);
			

			
		}
		@BeforeTest
		public void importData()
		{
			fileName="TestData";
			sheetName="DeleteLead";
		
			
		}
		
		
	}


