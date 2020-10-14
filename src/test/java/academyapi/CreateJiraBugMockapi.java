package academyapi;

import io.restassured.response.Response;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import academyapi.pojos.BankUsers;
import academyapi.pojos.BugJira;
import academyapi.pojos.Fields2;
import academyapi.servicepage.BankTransactionsServices;
import academyapi.servicepage.JiraServices;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class CreateJiraBugMockapi {
    Response response;

    @Test
    public void createBugMockapi() {
    	JiraServices jiraServices = new JiraServices("https://bootcamptest.atlassian.net/rest/api/2/issue/");
    	BankTransactionsServices bankTransactionsServices = new BankTransactionsServices("https://5f82445106957200164333a4.mockapi.io/api/v1/test");
    	Fields2 fields2 = new Fields2();
    	Assert.assertEquals(bankTransactionsServices.getStatusCode(), 200);
    	fields2= bankTransactionsServices.getJiraInformation();
    	Assert.assertEquals(jiraServices.createBug(fields2, "bWVsaXBpYTlAZ21haWwuY29tOnJudURvTW1CYzh0czRibXk2QWs3RDU1Mw=="), 201);

    }
}