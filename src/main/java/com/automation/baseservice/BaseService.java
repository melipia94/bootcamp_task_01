package com.automation.baseservice;


import  io.restassured.response.Response;

import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import org.pmw.tinylog.Logger;





/**
 * Base Service TestNG + Rest Assured
 * Core API Methods
 *
 * @author Brayhan.Criollo
 */
public class BaseService {

    public Response requestGetMethod(String url) {
    	Response response;
    	response = given().when().get(url);
    	return response;   
    }

   
    public Response requestPostMethod(String url, Object object) {
        Response response;
        response = given().contentType("application/json").body(object).when().post(url);
        return response;
    }
    
    public Response requestDeleteMethod(String url, String aut) {
        Response response;
        response = given().contentType("application/json").header("Authorization","Basic "+aut).when().delete(url);
        return response;
    }
    
    public Response requestPostMethod(String url, Object object, String aut) {
        Response response;
        response = given().contentType("application/json").header("Authorization","Basic "+aut).body(object).when().post(url);
        System.out.println(response.asString());
        return response;
    }
   
    public String getBodyResponse(Response response) {
    	return response.body().asString();
    	
    	
    }
    
    public ArrayList<String> getBodyParam(Response response, String param) {
    	 return response.path(param);
    	 
    	
    }
    public String getBodyParamString(Response response, String param) {
   	 return response.path(param);
   }
    public Integer getBodyParamInteger(Response response, String param) {
      	 return response.path(param);
      }
    
    public boolean getBodyIsEmpty(Response response) {
    
    	Logger.info("Alert Message: " + response.then().extract().body().asString());
    	String respuesta=response.body().asString();
    	response.then().assertThat().body("isEmpty()", Matchers.is(true));
    	if(respuesta.length()==2) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    public int getStatus(Response response) {
       return response.getStatusCode();
    	
    	
    }
}
