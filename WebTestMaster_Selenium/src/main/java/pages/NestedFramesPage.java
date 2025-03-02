package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String leftFrame = "frame-left";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";
    private String bottomFrame = "frame-bottom";
    private String topFrame = "frame-top";
    private By body = By.tagName("body");
    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }
    public void switchToTopFrame(){
        driver.switchTo().frame(topFrame);
    }
    public void switchToLeftFrame(){
        driver.switchTo().frame(leftFrame);
    }
    public void switchToMiddleFrame(){
        driver.switchTo().frame(middleFrame);
    }
    public void switchToRightFrame(){
        driver.switchTo().frame(rightFrame);
    }
    public void switchToBottomFrame(){
        driver.switchTo().frame(bottomFrame);
    }
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    public String getLeftFrameText(){
        switchToTopFrame();
        switchToLeftFrame();
        String leftFrameText = getFrameText();
        switchToParentFrame();
        switchToParentFrame();
        return leftFrameText;
    }
    public String getBottomFrameText(){
        switchToBottomFrame();
        String bottomFrameText = getFrameText();
        switchToParentFrame();
        return bottomFrameText;
    }
    public String getFrameText(){
        return driver.findElement(body).getText();
    }
}
