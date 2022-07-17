package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("VzCompany");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Divya",Keys.TAB,"Swaminathan");
		Thread.sleep(3000);
		//driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Swaminathan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Tester");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality Assurance");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test lead who confirms testing quality of products");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mynewemail@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDropdown1= new Select(state);
		stateDropdown1.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println("Create Lead is Successful");
		}


	}
}