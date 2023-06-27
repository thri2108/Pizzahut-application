package Testng.Testcases;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;


public class testcase001 {
ChromeDriver driver;
	
	@BeforeTest
public void openbrowser(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.pizzahut.co.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		
		
	}
	
	@Test
	public void location() throws InterruptedException {
		driver.findElement(By.tagName("input")).sendKeys("Hyderabad");
		Thread.sleep(2000);		
	}
	@Test
	public void selectfirstoption() throws InterruptedException {
		List<WebElement> selectoption = driver.findElements(By.xpath("//div[@class='flex flex-col']/button"));
		
		 int count = selectoption.size();
		 System.out.println(count);
		 selectoption.get(1).click();
		 Thread.sleep(2000);
				 
	}
	@Test
	public  void Actualtitle(){
		System.out.println(driver.getTitle());
		
		}
	
		
	@Test
		public void sidespage() throws InterruptedException {
		
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[3]")).click();
		WebDriverWait  add = new  WebDriverWait(driver,Duration.ofSeconds(2));
		add.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[2]/div[3]/div/button"))).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[3]/div[1]/div/a[5]")).click();
		try {
			Thread.sleep(1500);
			
				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[1]/div[3]/div/button")).click();
	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a")).click();
		Thread.sleep(1500);
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("(//i)[6]"));
		action.scrollToElement(btn).build().perform();
		WebElement btn1 = driver.findElement(By.xpath("(//i)[10]"));
		action.scrollToElement(btn1).build().perform();
		btn1.click();
		WebElement chkbx = driver.findElement(By.xpath("//*[@id=\"marketingOptIn\"]"));
		action.scrollToElement(chkbx).build().perform();
		chkbx.isSelected();
		WebElement name = driver.findElement(By.id("checkout__name"));
		action.scrollToElement(name).build().perform();
		name.sendKeys("jhon");
		WebElement phn = driver.findElement(By.id("checkout__phone"));
		action.scrollToElement(phn).build().perform();
		phn.sendKeys("9999955788");
		WebElement email = driver.findElement(By.id("checkout__email"));
		action.scrollToElement(email).build().perform();
		email.sendKeys("jhon@exampl.com");
		WebElement giftcard = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]/div[1]/span[2]"));
		action.scrollToElement(giftcard).build().perform();
		giftcard.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[1]/div[1]")).click();
		driver.findElement(By.name("voucherId")).sendKeys("12345");
		driver.findElement(By.cssSelector("button[type='submit'] span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
	
	}
	
	
		
		@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
