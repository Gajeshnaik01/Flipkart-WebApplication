package org.flipkart.addtocart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart3 {
	
	String productName;
	int productPrice;
	
	public Flipkart3(String productName,int productPrice) {
		this.productName=productName;
		this.productPrice=productPrice;
	}
	
	public String toString() {
		return productName+" "+productPrice;
		
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("phones"+Keys.ENTER);
		
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']/parent::div[@class='col col-7-12']/following-sibling::div[@class='col col-5-12 nlI3QM']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		int n=list1.size();
		List<Flipkart3> flip = new ArrayList<Flipkart3>();
		for (int i = 0; i < n; i++) {
			String name=list1.get(i).getText();
			String s=list.get(i).getText().substring(1);
			if(s.contains(",")) {
				s=s.replace(",","");
			}
			int price=Integer.parseInt(s);
			flip.add(new Flipkart3(name,price));
			 
		}
		Collections.sort(flip, new MyEnameCompartor());
		System.out.println(flip.size());
		for (Flipkart3 integer : flip) {
			System.out.println(integer);
		}
		driver.quit();
	}

}
