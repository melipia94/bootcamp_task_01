package com.automation.training.tests;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pojos.ProductPOJO;
import com.automation.training.pages.ShoppingSiteCart;
import com.automation.training.pages.ShoppingSitePage;
import com.automation.training.pages.ShoppingSiteServices;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class ShoppingSiteTest extends BaseTests {
 

    @Test
    public void  ShoppingSiteTest(){
    	ShoppingSiteServices shoppingSiteServices= new ShoppingSiteServices("URL_SERVICE_PRODUCT");
    	ProductPOJO productPOJO = new ProductPOJO(); 
    	productPOJO = shoppingSiteServices.createBody();
    	Assert.assertEquals(shoppingSiteServices.createProduct(productPOJO), 201);
    	ShoppingSitePage shoppingSitePage = new ShoppingSitePage(getDriver(),"URL_SHOPPING_SITE");
    	Assert.assertTrue(shoppingSitePage.productInformation(), "The information is't the same");
    	Assert.assertTrue(shoppingSitePage.verifyCartBefore());
    	shoppingSitePage.addProducts();
    	Assert.assertTrue(shoppingSitePage.verifyCartAfter());
    	Assert.assertTrue(shoppingSitePage.verifyQuantityAfter());
    	ShoppingSiteCart shoppingSiteCart = shoppingSitePage.goToCart();
    	Assert.assertEquals(shoppingSiteCart.verifyURL(), "http://34.205.174.166/cart/");
    	Assert.assertTrue(shoppingSiteCart.verifyProduct(), "The product isn't showed");
    	Assert.assertTrue(shoppingSiteCart.verifyPriceAndCount(), "The product isn't showed");
    	Assert.assertEquals(shoppingSiteServices.deleteProduct(), 200);
  
    }
}
