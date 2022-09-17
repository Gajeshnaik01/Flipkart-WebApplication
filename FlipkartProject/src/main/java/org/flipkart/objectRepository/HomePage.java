package org.flipkart.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.ThreadSafeClass;


public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[text()='✕']")
	private WebElement cancelBtn ;

	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchTxtBx ;

	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchBtn ;


	public void clickCancelBtn() {
		cancelBtn.click();
	}
	public ProductPage sendTxtToSearch(String text) {
		searchTxtBx.sendKeys(text);
		searchBtn.click();
		return new ProductPage(ThreadSafeClass.getDriver());
	}


}
