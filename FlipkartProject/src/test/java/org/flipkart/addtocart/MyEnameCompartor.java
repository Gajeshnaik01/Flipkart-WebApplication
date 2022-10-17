package org.flipkart.addtocart;

import java.util.Comparator;

public class MyEnameCompartor implements Comparator<Flipkart3>{

	@Override
	public int compare(Flipkart3 o1, Flipkart3 o2) {
		
		
		if(o1.productPrice==o2.productPrice) {
			return 0;
		}
		else if(o1.productPrice>o2.productPrice){
			return 1;
		}
		else {
			return -1;
		}
	}
}
