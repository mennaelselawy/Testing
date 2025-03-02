package alerts;

import base.BaseTests;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
       var alertsPage = homePage.clickJavaScriptAlerts();
       alertsPage.clickJSAlert();
       alertsPage.alert_acceptAlert();
       assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "the alert is not clicked");
    }
    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickJSConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickCancelButton();
        assertEquals(text, "I am a JS Confirm", "the alert text is incorrect");
    }
    @Test
    public void testEnterTextInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickJSPrompt();
        String text ="Menna";
        alertsPage.alert_enterJSPrompt(text);
        alertsPage.alert_acceptAlert();
        assertEquals(alertsPage.getResult() , "You entered: " + text,"the result tex is incorrect");
    }
}
