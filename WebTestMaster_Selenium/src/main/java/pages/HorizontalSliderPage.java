package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.tagName("input");
    private By value = By.id("range");
    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }
    public void moveSliderRight(){
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
    }
    public void moveSliderLeft(){
        driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
    }
    public void setSliderValue(String value){
        while(!getValue().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public String getValue(){
        return driver.findElement(value).getText();
    }

}
