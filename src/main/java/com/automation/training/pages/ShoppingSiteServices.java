package com.automation.training.pages;

import org.pmw.tinylog.Logger;

import com.automation.baseservice.BaseService;
import com.automation.pojos.ProductPOJO;
import com.automation.training.utils.Utils;

import io.restassured.response.Response;

/**
 * Service Page One
 *
 * @author Brayhan.Criollo
 */
public class ShoppingSiteServices extends BaseService {
	public String url ;
	public Integer productId;
	private static final String NAME = "name";
	private static final String TYPE = "type";
	private static final String PRICE = "regular_price";
	private static final String DESCRIPTION = "description";
	private static final String SHORT_DESCRIPTION = "short_description";
	public ShoppingSiteServices(String url) {
		url = Utils.getUserProperty(url);
		this.url =url;
		
	}
	
    public String getResponseAsString() {
    	Response response = requestGetMethod(url);
    	String responseText = getBodyResponse(response);
    	Logger.info("Alert Message: " + responseText);
    	return responseText;
    }

    
    public int createProduct(Object object) {
    	String aut =Utils.getUserProperty("AUTHORIZATION_PRODUCT");
    	Response response = requestPostMethod(url, object, aut);
    	productId = getBodyParamInteger(response,"id");
    	Logger.info(response);
    	Logger.info("The product id is" +productId);
    	return getStatus(response);
	   
    }
    public int deleteProduct() {
    	String aut =Utils.getUserProperty("AUTHORIZATION_PRODUCT");
    	String URL= url+"/"+productId;
    	Response response = requestDeleteMethod(URL, aut);
    	Logger.info(response.asString());
    	return getStatus(response);
    }
  
     
    public ProductPOJO createBody() {
    	String name = Utils.getJsonDataProvider(NAME);
    	String type = Utils.getJsonDataProvider(TYPE);
    	String price = Utils.getJsonDataProvider(PRICE);
    	String description = Utils.getJsonDataProvider(DESCRIPTION);
    	String shortDescription =Utils.getJsonDataProvider(SHORT_DESCRIPTION);
    	ProductPOJO productPOJO = new ProductPOJO(); 
    	productPOJO.setName(name);
    	productPOJO.setType(type);
    	productPOJO.setRegular_price(price);
    	productPOJO.setDescription(description);
    	productPOJO.setShort_description(shortDescription);
    	return productPOJO;
     }
    public int getStatusCodePost(Response response) {
    	return getStatus(response);
	   
    }
   
	
}