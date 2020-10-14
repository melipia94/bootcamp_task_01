package academyapi.baseservice;



import io.restassured.path.json.JsonPath;
import  io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.parser.JSONParser;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.pmw.tinylog.Logger;

import academyapi.pojos.BankUsers;




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
    
    public Response requestPostMethod(String url, Object object, String auto) {
        Response response;
        response = given().contentType("application/json").header("Authorization","Basic "+auto).body(object).when().post(url);
        return response;
    }
    public Response requestPostMethodWithAutorization(String url, BankUsers bankUser) {
        Response response;
        response = given().contentType("application/json").body(bankUser).when().post(url);
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
