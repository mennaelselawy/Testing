package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");
    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStartButton(){
        driver.findElement(startButton).click();
        /**
         * EXPLICIT WAIT for a specific method
         * webDriver class called WebDriverWait in support UI Package
         *takes two arguments: the driver , timeout in seconds
         * this statement will not do anything just a setup statement to create this wait object
         //
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        /*
         * expected condition class also in support UI package
         * contains all sorts of methods that allow you to wait for some condition to be met before proceeding
         * here we use invisibilityOf which takes a web element so we wait till this webElement disappear
         //
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        */
        /**
         * FLUENT WAIT
         * more flexible , tell how often it should poll and you can specify any exceptions that you want to ignore
         *
         */
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
