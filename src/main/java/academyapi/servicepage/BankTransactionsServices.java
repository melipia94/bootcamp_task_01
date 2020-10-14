package academyapi.servicepage;


import java.util.ArrayList;
import java.util.Locale;

import org.pmw.tinylog.Logger;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import academyapi.baseservice.BaseService;
import academyapi.pojos.BankUsers;
import academyapi.pojos.BugJira;
import academyapi.pojos.Fields;
import academyapi.pojos.Fields2;
import academyapi.pojos.Issuetype;
import academyapi.pojos.Project;
import io.restassured.response.Response;

/**
 * Service Page One
 *
 * @author Brayhan.Criollo
 */
public class BankTransactionsServices extends BaseService {
	public String url ;
	
	public BankTransactionsServices(String url) {
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
	   	 Logger.info(getBodyResponse(response));
		 Logger.info(getStatus(response));
    	return getStatus(response);
	   
    }
    public Fields2 getJiraInformation() {
    	Response response = requestGetMethod(url);
    	Fields fields = new Fields();
        Fields2 fields2 = new Fields2();
        Project project = new Project();
        Issuetype issueType = new Issuetype();
    	fields.setDescription(getBodyParam(response, "fields.description").get(0));
    	fields.setSummary(getBodyParam(response, "fields.summary").get(0));
    	project.setKey(getBodyParam(response, "fields.project.key").get(0));
    	issueType.setName(getBodyParam(response, "fields.issuetype.name").get(0));
    	fields.setProject(project);
    	fields.setIssuetype(issueType);
    	fields2.setFields(fields);
        return fields2;
    	
    }
    
    public boolean verityEmailAcoount(String email) {
    	Response response = getResponse();
    	if (getBodyParam(response, "email").contains(email)) {Logger.info("The email accout alredy exists");}
    	else Logger.info("The email accout doesn't exist");
    	return getBodyParam(response, "email").contains(email);
	   
    }
    public int addAccount(BankUsers bankUsers) {
    	Response response ;
       if(!verityEmailAcoount(bankUsers.getEmail())) {
    	    response = requestPostMethod(url, bankUsers);
    	    Logger.info(getBodyResponse(response));
    	    Logger.info(getStatusCodePost(response));
    	    return getStatusCodePost(response);
    	    
       }
       else {
    	   return 400;
       }
	  
    }
    
    public BankUsers createUser() {
    	BankUsers user = new BankUsers();
    	FakeValuesService faker = new FakeValuesService(
    		      new Locale("es-CO"), new RandomService());
    	user.setName(faker.letterify("????"));
    	user.setLastName(faker.letterify("??????"));
    	user.setAccountNumber(faker.numerify("####"));
    	user.setAmount(faker.numerify("#####"));
    	user.setTransactionType("Ahrros");
    	user.setEmail(faker.letterify("??????")+"@gmail.com");
    	user.setActive(faker.letterify("??????"));
    	user.setCountry(faker.letterify("??????"));
    	user.setTelephone(faker.numerify("301#######"));
    	return user;
     }
    public BankUsers createUser(String name, String lastName, String accountNumber, String amount, String transactionType, String email, String active, String country, String teplephoneNumber) {
    	BankUsers user = new BankUsers();
    	user.setName(name);
    	user.setLastName(lastName);
    	user.setAccountNumber(accountNumber);
    	user.setAmount(amount);
    	user.setTransactionType(transactionType);
    	user.setEmail(email);
    	user.setActive(active);
    	user.setCountry(country);
    	user.setTelephone(teplephoneNumber);
    	return user;
     }
    public int getStatusCodePost(Response response) {
    	return getStatus(response);
	   
    }
	
}