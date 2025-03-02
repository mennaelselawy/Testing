package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By table = By.id("large-table");
    public LargeAndDeepDomPage(WebDriver driver){
        this.driver = driver;
    }
    public void scrollToTable(){
        WebElement tableElement = driver.findElement(table);
        //scrollIntoView() ---> java script method
        String script = "arguments[0].scrollIntoView()";
        //it will replace tableElement with argument[0] element
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
