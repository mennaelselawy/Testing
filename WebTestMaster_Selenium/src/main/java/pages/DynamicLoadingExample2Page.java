package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");
    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
    }

    /**
     * to assert on the start button that is displayed or not
     * @return boolean
     */
    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
