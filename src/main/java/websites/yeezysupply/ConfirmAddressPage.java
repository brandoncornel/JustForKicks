package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class ConfirmAddressPage {

    private WebDriver driver = null;
    private WebDriverWait wait;


    private By CONTINUE_BUTTON_BY = By.xpath("//div[@data-step='shipping_method']//button[@type='submit']");



    ConfirmAddressPage(WebDriver driver, int waitTime){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON_BY));
    }

    public void confirmAddressPageContinue(){
        driver.findElement(CONTINUE_BUTTON_BY).click();
    }



}
