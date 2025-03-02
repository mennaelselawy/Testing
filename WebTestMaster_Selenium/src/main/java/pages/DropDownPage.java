package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage{
    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    //constructor
    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    //method to select the option from dropdown
    public void selectFromDropDown(String option){
        //Select dropdownElement = new Select(driver.findElement(dropdown));
        //dropdownElement.selectByVisibleText(option);
        findDropDownElement().selectByVisibleText(option);
    }

    //method to get the selected options , will return that text value
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

    /**
     * to add multiple options in the dropDown to select from
     */
    public void addMoreOptions(){
        String script = "arguments[0].setAttribute('multiple', '')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }
}
