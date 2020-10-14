package academyapi;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import academyapi.servicepage.BankTransactionsServices;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class ResponseEmptyTest {
    Response response;

    @Test
    public void responseEmpty() {
    	BankTransactionsServices bankTransactionsServices = new BankTransactionsServices("https://5f82445106957200164333a4.mockapi.io/api/v1/users");
    	Assert.assertTrue(bankTransactionsServices.getResposeEmpty());
    	Assert.assertEquals(bankTransactionsServices.getStatusCode(), 200);
    	
    }
}