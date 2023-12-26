package testcases;

import org.testng.annotations.Test;
import pages.P01_Login;


public class TC01_Login extends TestBase {

            //Todo Define parameters values
    String userName="standard_user";
    String password="secret_sauce";

    @Test(priority = 1, description ="Log in with valid email and password")
    public void loginWithValidEmailAndPassword_P() throws InterruptedException {
        new P01_Login(driver).insertUserName(userName).insertPassword(password).clickLoginButton();
    Thread.sleep(3000);
    }


}
