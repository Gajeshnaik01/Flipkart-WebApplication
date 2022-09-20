package org.flipkart.addtocart;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.ListenerImpClass;
import org.yantra.genericUtility.ThreadSafeClass;
@Listeners(org.yantra.genericUtility.ListenerImpClass.class)
public class InsertProductInAddToCart extends BaseClass{

	
	
	@Test(retryAnalyzer = org.yantra.genericUtility.RetryImpClass.class)
	public void insertProductToCart() throws InterruptedException {
		homePage.clickCancelBtn();
		String productName=ThreadSafeClass.getExcelUtility().getExcelData(IConstants.sheetName, 2, 1);
		homePage.sendTxtToSearch(productName).setProduct();
		String expectedProduct=ThreadSafeClass.getExcelUtility().getExcelData(IConstants.sheetName, 2, 2);
		productPage.clickOnProduct(expectedProduct).addProductToCart();
		ListenerImpClass.testLog.info("Product is added to cart");
		String actualProduct=addToCart.getProductNameInCart();
		expectedProduct=expectedProduct.substring(0, 20);
		ListenerImpClass.testLog.info("Validating cart");
		Assert.assertTrue(actualProduct.contains(expectedProduct));
		ListenerImpClass.testLog.info("Product Successfully Added to Cart");
		System.out.println("Product Successfully Added to Cart");
	
	}

}
