package utils;

import org.openqa.selenium.WebDriver;

/*
for any class to interact with the browser at all it needs the driver
 */
public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;
    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }
    /**
     * method to go back one item in the browser's history
     */
    public void goBack(){
        //way to get to the navigation
        //driver.navigate().back(); to make it simpler
        navigate.back();
    }
    //util methods for going forward, refreshing and navigating to a page
    public void goForward(){
        navigate.forward();
    }
    public void refreshPage(){
        navigate.refresh();
    }
    public void goTo(String url){
        navigate.to(url);
    }
    /**
     * to manage multiple tabs
     * @param : the name of the tab want to switch to
     */
    public void switchToTab(String tabTitle){
        //will return handles to all of the open windows or tabs
        var windows = driver.getWindowHandles();
        //how many tabs are they
        System.out.println("Number of tabs: " + windows.size());
        //print statements so that we see what is going on when we run the tests
        System.out.println("Window handles: ");  // window handles are unique identifiers for those windows and created when window runs
        windows.forEach(System.out::println);
        //loop through all of the window handles
        for(String window:windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current window title: " + driver.getTitle());
            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    /**
     * opens the link in a new tab not on the same tab
     */
    public void switchToNewTab(){
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
