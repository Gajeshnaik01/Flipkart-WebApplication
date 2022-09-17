package org.yantra.genericUtility;

import org.flipkart.objectRepository.AddToCartPage;
import org.flipkart.objectRepository.HomePage;
import org.flipkart.objectRepository.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class InstanceClass {

	public WebDriver driver;
	public WebDriverUtility WebDriverUtility;
	public ExcelUtility excelUtility;
	public FileUtility fileUtility;
	public JavaUtility javaUtility;
	public JavaScriptExeUtility js;
	public SoftAssert soft;
	
	public String url;
	public String userusername;
	public String userpassword;
	public String browser;
	public String to;
	public long timeouts;
	public HomePage homePage;
	public ProductPage productPage;
	public AddToCartPage addToCart;
	
}
