package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by brandoncornel on 6/3/17.
 */
public class CartPage {

    private WebDriver driver = null;
    private WebDriverWait wait;

    private By CHECKOUT_BY = By.xpath("//input[@type='submit' and @value='CHECK OUT' and @name='checkout']");

    CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void waitForPage(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BY));

    }

    public void checkout(){
        driver.findElement(CHECKOUT_BY).click();
    }
}
