package forgetpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.RetrievePasswordPage;

import static org.testng.Assert.assertTrue;

public class ForgetPasswordTests extends BaseTests {
    @Test
    public void testForgetPassword(){
        ForgetPasswordPage forgetPasswordPage = homePage.clickForgetPassword();
        forgetPasswordPage.writeEmail("MennaAshraf@gmail.com");
        RetrievePasswordPage retrievePassword = forgetPasswordPage.clickRetrievePasswordButton();
        assertTrue(retrievePassword.getText().contains("Internal Server Error"), "Text is incorrect");
    }

}
