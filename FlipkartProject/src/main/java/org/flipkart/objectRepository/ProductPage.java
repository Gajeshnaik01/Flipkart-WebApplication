package org.flipkart.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.ThreadSafeClass;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@class='_396cs4 _3exPp9']/ancestor::a[@class='_2rpwqI']/following-sibling::a[@class='s1Q9rs']")
	private WebElement product ;

	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchTxtBx ;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchBtn ;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart ;


	private String clickOnProduct="//a[contains(text(),'%s')]";

	private WebElement convertDynamicXathToElement(String partialXpath, String replaceData ) {
		String xpath = String.format(partialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}

	public ProductPage clickOnProduct(String replaceData) {
		convertDynamicXathToElement(clickOnProduct,replaceData).click();
		ThreadSafeClass.getWebDriverUtility().switchWin(replaceData);
		return new ProductPage(ThreadSafeClass.getDriver());
	}

	public void addProductToCart() {
		addToCart.click();
	}


	public void setProduct() {
		String text=product.getText();
		ThreadSafeClass.getExcelUtility().setExcelData("FLIPKART", 2, 2, text);
		ThreadSafeClass.getExcelUtility().saveExceldata(IConstants.EXCELFILEPATH);
		System.out.println("Excel data set");

	}



}
