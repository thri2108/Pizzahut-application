package pizzahut_Cucumber.page_objects;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class page_object_model {
	ChromeDriver driver;
	public void openbrowser(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.pizzahut.co.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		
		
	}
	
	public void location() throws InterruptedException {
		driver.findElement(By.tagName("input")).sendKeys("Hyderabad");
		Thread.sleep(2000);		
	}
	
	public void selectfirstoption() throws InterruptedException {
		List<WebElement> selectoption = driver.findElements(By.xpath("//div[@class='flex flex-col']/button"));
		
		 int count = selectoption.size();
		 System.out.println(count);
		 selectoption.get(1).click();
		 Thread.sleep(2000);
				 
	}
	public  void Actualtitle(){
		System.out.println(driver.getTitle());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickradiobtn() {
		
		List<WebElement> btn = driver.findElements(By.xpath("//div[@class='flex items-center w-full pr-10 justify-end']/input"));
		btn.get(0).isSelected();
	}
	
	public void navtoPizza() {
		driver.findElement(By.linkText("Pizzas")).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addpizza() {
		
		driver.findElement(By.xpath("//button[@data-synth='button--margherita-pan-medium--one-tap']")).click();
	}
	
	public void validatebasket() {
		System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")).getText());
	}
	
	public void checkoutprice() {
		WebElement subtotal = driver.findElement(By.className("subtotal"));
		String subtotal1 = subtotal.getText().replace("₹", "");
		System.out.println(subtotal1);
		double a = Double.parseDouble(subtotal1);
		
		WebElement handlingcharges = driver.findElement(By.className("display-supplement-value"));
		String subtotal2 = handlingcharges.getText().replace("₹", "");
		System.out.println(subtotal2);
		double b = Double.parseDouble(subtotal2);
		
		WebElement tax = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/span[2]"));
		String taxprice = tax.getText().replace("₹", "");
		System.out.println(taxprice);
		double c = Double.parseDouble(taxprice);
		
		WebElement total = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/span[3]/span[1]"));
		String totalprice = total.getText().replace("₹", "");
		System.out.println(totalprice);
		double expectedprice = Double.parseDouble(totalprice);
		double Actualprice = a+b+c;
		System.out.println(Actualprice);
		
		Assertions.assertEquals(expectedprice, Actualprice);
		
	}
	
	public void itemcount() {
		WebElement items = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]"));
		String itemcount = items.getText();
		System.out.println(itemcount);
		Assertions.assertEquals("1 item", itemcount);
		
	}
	public void drinkspage() {
		driver.findElement(By.linkText("Drinks")).click();
	}
	public void adddrinks() {
		
		driver.findElement(By.xpath("(//span[contains(text(),'Add')])[1]")).click();
	}
	public void itemcount2() {
		WebElement items = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]"));
		String itemcount = items.getText();
		System.out.println(itemcount);
		Assertions.assertEquals("2 items", itemcount);
	}
	
	public void price() throws InterruptedException {
		double previousprice = 340.20;
		
		WebElement updatedprice = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/span[3]/span[1]"));
		String newprice = updatedprice.getText().replace("₹", "");
		System.out.println(newprice);
		double expectedprice = Double.parseDouble(newprice);
		boolean price= expectedprice > previousprice;
		System.out.println(price);
		
	
	}
	public void removeitems() {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/button[2]"))).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cartPrice() {
		WebElement Amountdue = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/span[2]"));
		String newprice = Amountdue.getText().replace("₹", "");
		System.out.println(newprice);
		double expectedprice = Double.parseDouble(newprice);
		
		if(expectedprice<200.0) {
			System.out.println("Minimum Checkout price is 200.00");
			System.out.println("Please Add more items");
		}
		else {
			System.out.println("Proceed to checkout.");
		}
	
	}
	
	public void newcartitem() {
		WebElement items = driver.findElement(By.cssSelector(".bg-green-dark.pl-5.pr-5.rounded"));
		String itemcount = items.getText();
		System.out.println(itemcount);
		Assertions.assertEquals("1 item", itemcount);
	}
	
	public void checkout() {
		WebElement chkout = driver.findElement(By.xpath("(//div[contains(@class,'basket-checkout')])[1]"));
		chkout.click();
		System.out.println(driver.getTitle());
	}

	public void pop_up() {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/button[2]/span[1]")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closebrowser() {
		
		driver.close();
		
	}

	
}
