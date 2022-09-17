package org.flipkart.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {


	public	AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	private WebElement productName;




	public String getProductNameInCart() {
		return productName.getText();
	}

}
