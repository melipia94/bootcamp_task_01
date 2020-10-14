package academyapi;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import academyapi.pojos.BankUsers;
import academyapi.pojos.BugJira;
import academyapi.pojos.Fields2;
import academyapi.pojos.Fields;
import academyapi.servicepage.BankTransactionsServices;
import academyapi.servicepage.JiraServices;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class VerifyJiraNumber {
    Response response;

    @Test
    public void verifyJiraNumber() {
    	JiraServices jiraServices = new JiraServices("https://bootcamptest.atlassian.net/rest/api/2/issue/");
    	Fields2 fields2 = new Fields2();
    	fields2= jiraServices.createPojoBug("PRUEB", "REST ye merry gentlemen.","Creating of an issue using project keys and issue type names using the REST API","Bug");
    	Assert.assertEquals(jiraServices.createFirstJiraNumber(fields2, "bWVsaXBpYTlAZ21haWwuY29tOnJudURvTW1CYzh0czRibXk2QWs3RDU1Mw=="), 201);
    	Assert.assertEquals(jiraServices.createBug(fields2, "bWVsaXBpYTlAZ21haWwuY29tOnJudURvTW1CYzh0czRibXk2QWs3RDU1Mw=="), 201);
    	Assert.assertTrue(jiraServices.compareJiraNumbers());

    }
}