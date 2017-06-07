package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class ConfirmAddressPage {

    WebDriver driver = null;
    WebDriverWait wait;


    By CONTINUE_BUTTON_BY = By.xpath("//div[@data-step='shipping_method']//button[@type='submit']");



    ConfirmAddressPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON_BY));
    }

    public void confirmAddressPageContinue(){
        driver.findElement(CONTINUE_BUTTON_BY).click();
    }



}
