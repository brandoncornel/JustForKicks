package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by brandoncornel on 6/3/17.
 */
public class CheckoutPage {

    WebDriver driver = null;
    WebDriverWait wait;

    By CHECKOUT_BY = By.xpath("//input[@type='submit' and @value='CHECK OUT' and @name='checkout']");

    //By addToCartButton = By.xpath("//form//input[@type='submit' and contains(@value, 'PURCHASE')]");


    CheckoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void waitForPage(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BY));

    }

    public void checkout(){
        System.out.println(driver.getPageSource());
        driver.findElement(CHECKOUT_BY).click();

    }
}
