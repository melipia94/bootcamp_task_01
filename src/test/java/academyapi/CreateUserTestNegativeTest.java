package academyapi;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import academyapi.pojos.BankUsers;
import academyapi.servicepage.BankTransactionsServices;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class CreateUserTestNegativeTest {
    Response response;

    @Test
    public void createUserTestNegativeTest() {
    	BankTransactionsServices bankTransactionsServices = new BankTransactionsServices("https://5f82445106957200164333a4.mockapi.io/api/v1/test");
    	BankUsers user = new BankUsers();
    	user= bankTransactionsServices.createUser("Melissa", "Pineda","10234","10000",  "Ahorros","obiqyp@gmail.com", "Active", "Colombia","31473344321");
     	Assert.assertTrue(bankTransactionsServices.verityEmailAcoount(user.getEmail()));
    	Assert.assertEquals(bankTransactionsServices.getStatusCode(), 200);
    	    }
}