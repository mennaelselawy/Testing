package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetrievePasswordPage {
    private WebDriver driver;
    public By retrievePasswordNewPage = By.xpath("//h1[text()='Internal Server Error']");
    //constructor
    RetrievePasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public String getText(){
        return driver.findElement(retrievePasswordNewPage).getText();
    }
}
