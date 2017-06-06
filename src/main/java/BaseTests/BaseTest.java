/**
 * Created by brandoncornel on 5/17/17.
 */
package BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver = null;

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
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        setup("Chrome");
        driver.navigate().to("http://www.facebook.com");
    }
}
