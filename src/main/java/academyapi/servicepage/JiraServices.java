package academyapi.servicepage;


import java.util.ArrayList;
import java.util.Map;

import org.pmw.tinylog.Logger;

import academyapi.baseservice.BaseService;
import academyapi.pojos.BankUsers;
import academyapi.pojos.BugJira;
import io.restassured.response.Response;

/**
 * Service Page One
 *
 * @author Brayhan.Criollo
 */
public class JiraServices extends BaseService {
	public String url ;
	private String jiraNumber;
	private String firstJiraNumber;
	
	public JiraServices(String url) {
		this.url =url;
		
	}
	
    public String getResponseAsString() {
    	Response response = requestGetMethod(url);
    	String responseText = getBodyResponse(response);
    	Logger.info("Alert Message: " + responseText);
    	return responseText;
    }
    public Response getResponse() {
    	Response response = requestGetMethod(url);
    	String responseText = getBodyResponse(response);
    	return response;
    }
 
    
    public boolean getResposeEmpty() {
    	Response response = requestGetMethod(url);
    	return getBodyIsEmpty(response);
	   
    }
    public int getStatusCode() {
    	Response response = requestGetMethod(url);
    	return getStatus(response);
	   
    }
    
    public void setJiraNumber(Response response) {
    	String jiraNumber = getBodyParamString(response, "id");
    	this.jiraNumber=jiraNumber;
    }
    
    public String getJiraNumber() {
    	return jiraNumber;
    }
    
    public void setFirstJiraNumber(Response response) {
    	String jiraNumber = getBodyParamString(response, "id");
    	this.firstJiraNumber=jiraNumber;
    }
    
    public String getFirstJiraNumber() {
    	return firstJiraNumber;
    }
    
    public int createBug(BugJira bugJira, String aut) {
    	Response response ;
    	response = requestPostMethod(url, bugJira.getFields2(), aut);
    	Logger.info(getBodyResponse(response));
    	setJiraNumber(response);
    	return getStatusCodePost(response);
    }
    
    public int createFirstJiraNumber(BugJira bugJira, String aut) {
    	Response response ;
    	response = requestPostMethod(url, bugJira.getFields2(), aut);
    	setFirstJiraNumber(response);
    	return getStatusCodePost(response);
    }
    
    public int createBug(Object bugJira, String aut) {
    	Response response ;
    	response = requestPostMethod(url, bugJira, aut);
    	setFirstJiraNumber(response);
    	return getStatusCodePost(response);
    }
    
    public BugJira createPojoBug(String key, String summary, String description, String name) {
    	BugJira bug = new BugJira();
    	bug.setKey(key);
    	bug.setProject();
    	bug.setSummary(summary);
    	bug.setDescription(description);
    	bug.setName(name);
    	bug.setIssueType();
    	bug.setFields();
    	bug.setFields2();
    	return bug;
     }
    public int getStatusCodePost(Response response) {
    	return getStatus(response);
	   
    }
    public boolean compareJiraNumbers() {
	   	 Logger.info(getFirstJiraNumber());
		 Logger.info(getFirstJiraNumber());
    	return Integer.parseInt(getFirstJiraNumber())<Integer.parseInt(getJiraNumber());
	   
    }
	
}