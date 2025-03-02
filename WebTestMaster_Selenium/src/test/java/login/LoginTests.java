package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
   @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        //secureAreaPage.getAlertText();
        //Use assertEquals from TestNG to asserts the message
        //assertEqauls(actual , expected , "message"); the message will appear in case the assert fails
        /*assertEquals(secureAreaPage.getAlertText(),
                "You logged into a secure area!",
                "Alert text is incorrect");*/
        //assertTrue(condition to be verified, message if the condition in wrong);
       assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
               "Alert text is incorrect");
    }
}
