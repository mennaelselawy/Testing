package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");
    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * scroll until paragraph with index specified is in view
     * @param index 1-based
     */
    public void scrollToParagraph(int index){
        /* srollTo ---> java script function on window element
        takes two integers: x axis , y axis
        so we can scroll horizontally or vertically
        document.body.scrollHeight > this will do a normal scroll for the user
        */
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;
        // we need to say keep scroll until certain number of paragraphs
        while(getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
    }
    private int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }
}
