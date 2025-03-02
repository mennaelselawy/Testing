package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    //protected WebDriver driver;
    //EVENT LISTENER web driver FOR OLDER SELENIUM
    // change the driver type from a web driver to a specific instance of webdriver called the event firing web driver
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //driver = new ChromeDriver();
        //instead to make it from EventFiringWebDriver
        WebDriver originalDriver = new ChromeDriver(getChromeOptions());  //create the chrome instance
        driver = new EventFiringDecorator<>(new EventReporter()).decorate(originalDriver); // Attach listener
        //we have to register a class that implementing the web driver event listener interface to say to it to listen to events
        //register takes the instance of listener class
        //driver.register(new EventReporter);
        /**
         * timeouts object , implicitlyWait takes two arguments: the amount of time to wait , time unit
         * means: anytime webDriver needs to interact with elements then it should poll the website for 30 seconds until it found that element
         * if it found the element before 30 seconds then it will interact with it
         * if not then it will wait and continue to poll until it finds the element or until this 30 seconds is up
         * if 30 seconds is up and it did not find the element it will throw an exception no such element
         * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         * implicit wait for the entire app but explicit for specific method
         */
        gohome();
        //setCookie();

        // FIRST BASE TESTS TRIAL BEFORE MAKING FRAMEWORK LAYER BUT TO BE UPDATED THIS CODE SHOULD BE IN THE FRAMEWORK LAYER NO THE TEST LAYER
        /*
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        WebElement inputsLink = driver.findElement(By.linkText("Menna")); //will throw exception NoSuchElement
        inputsLink.click();

        System.out.println(driver.getTitle());
        -------------------------------
        //assignment
        driver.findElement(By.linkText("Shifting Content")).click();
        shiftingContentLink.click();

        driver.findElement(By.partialLinkText("Example 1:")).click();

        List<WebElement> menuElements = driver.findElements(By.tagName("li"));
        System.out.println(menuElements.size());
        for(WebElement item : menuElements)
        {
            System.out.println(item.getText());
        }
         */
    }
    @BeforeMethod
    public void gohome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /**
     * will run after each test runs so we can take our photo here
     * @return
     */
    /*@AfterMethod
    public void takeScreenShot(){
        //cast our driver to selenium class TakesScreenshot
        var camera = (TakesScreenshot)driver;
        //save th screenshot as a file using java IO package
        //getScreenshotAs --> takes an output type
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        //print the path where the screenshot stored
        //System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        //this is not compiling throws an I/O exception SO, use TRY CATCH
        try{
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        }catch( IOException e){
            e.printStackTrace();
        }
    }*/

    /**
     * what if i want to take screenshot only after failure
     * @param : ITestResult from testNG package and this is the result of the test
     */
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                //instead of writing test.png we write the name of the test tha is failed
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch( IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * method will give us a handle to the window manager
     */
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    //because we used TestNG so we commented the main we do not need it any more
    /*
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
    }*/
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //it will run our test without opening our browser up, So run faster
        //options.addArguments("--headless=new");
        return options;
    }
    /*private void setCookie(){
        //this only creates the cookie
        // the builder takes a name and a value for the cookie, DOMAIN needs to be the website that we are actually storing this cookie for
        Cookie cookie = new Cookie.Builder("tau","123" )
                .domain("the-internet.herokuapp.com")
                .build();
        //then set the cookie
        driver.manage().addCookie(cookie);
    }*/
    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
}
