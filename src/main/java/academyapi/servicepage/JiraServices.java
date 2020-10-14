package academyapi.servicepage;


import java.util.ArrayList;
import java.util.Map;

import org.pmw.tinylog.Logger;

import academyapi.baseservice.BaseService;
import academyapi.pojos.BankUsers;
import academyapi.pojos.BugJira;
import academyapi.pojos.Fields2;
import academyapi.pojos.Fields;
import academyapi.pojos.Issuetype;
import academyapi.pojos.Project;
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
    
    public int createFirstJiraNumber(Fields2 fieldsParams, String aut) {
    	Response response ;
    	response = requestPostMethod(url,fieldsParams, aut);
    	setFirstJiraNumber(response);
    	Logger.info(getBodyResponse(response));
      	Logger.info(getStatusCodePost(response));
    	return getStatusCodePost(response);
    }
    
    public int createBug(Object fields, String aut) {
    	Response response ;
    	response = requestPostMethod(url, fields, aut);
    	setJiraNumber(response);
    	Logger.info(getBodyResponse(response));
    	Logger.info(getStatusCodePost(response));
    	return getStatusCodePost(response);
    }
    
    public Fields2 createPojoBug(String key, String summary, String description, String name) {
   
       Fields fields = new Fields();
       Fields2 fields2 = new Fields2();
       Project project = new Project();
       Issuetype issueType = new Issuetype();
       fields.setDescription(description);
       fields.setSummary(summary);
       project.setKey(key);
       issueType.setName(name);
       fields.setIssuetype(issueType);
       fields.setProject(project);
       fields2.setFields(fields);
       return fields2;
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