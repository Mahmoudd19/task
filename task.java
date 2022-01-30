package project1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task {

	WebDriver driver;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test(priority = 1)
	public void login() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

	}

	 @Test(priority = 2)
	public void AddUser() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		new Select(driver.findElement(By.id("systemUser_userType"))).selectByVisibleText("ESS");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("David Morris");
		driver.findElement(By.id("systemUser_userName")).sendKeys("DavidMorris1");
		new Select(driver.findElement(By.id("systemUser_status"))).selectByVisibleText("Enabled");
		driver.findElement(By.id("systemUser_password")).sendKeys("Ma@12345");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Ma@12345");
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void SearchForUser() {

		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("DavidMorris1");
		new Select(driver.findElement(By.id("searchSystemUser_userType"))).selectByVisibleText("ESS");
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("David Morris");
		driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
	}

	@Test(priority = 4)
	public void UserDetails() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		Thread.sleep(3000);
		String Employee = driver.findElement(By.name("systemUser[employeeName][empName]")).getText();
		
		
		
		Thread.sleep(3000);
		assertEquals(Employee,"David Morris");
		

	}
}
