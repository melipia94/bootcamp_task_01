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
public class CreateUserTest {
    Response response;

    @Test
    public void createUser() {
    	BankTransactionsServices bankTransactionsServices = new BankTransactionsServices("https://5f82445106957200164333a4.mockapi.io/api/v1/test");
    	BankUsers user = new BankUsers();
    	user= bankTransactionsServices.createUser();
    	Assert.assertEquals(bankTransactionsServices.addAccount(user), 201);
   
    }
}