package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;
    private By figureElement = By.className("figure");
    private By eachFigureCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * we have three figure each figure has it is own name and link , to Hover we use the Actions class witch uses BUILDER PATTERN
     * @param index  starts with 1 , for the three figures
     * @return void
     */
    public FigureCaption hoverOverFigure(int index){

        WebElement figure = driver.findElements(figureElement).get(index - 1);

        Actions actions = new Actions(driver);       //Actions takes the web driver object
        actions.moveToElement(figure).perform();             //moveToElement takes a WebElement and move the mouse to the element then execute by .perform()
        return new FigureCaption(figure.findElement(eachFigureCaption));
    }

    public class FigureCaption{
        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");
        // private By link = By.linkText("View profile");

        FigureCaption(WebElement caption){
            this.caption = caption;
        }
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }
        public String getTitle(){
            return caption.findElement(header).getText();
        }
        public String getTheLink(){
            return caption.findElement(link).getAttribute("href");
        }
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}

