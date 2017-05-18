/**
 * Created by brandoncornel on 5/17/17.
 */

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver = null;

    public void setupProperties(){
        System.setProperty("webdriver.chrome.driver", "/Users/brandoncornel/Desktop/Projects/JustForKicks/chromedriver");
    }

    public void setup(String browser){
        setupProperties();
        if(browser.toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }else if(browser.toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }

    }

    @Test
    public void test1(){
        setup("Chrome");
        driver.navigate().to("http://www.facebook.com");

    }
}
