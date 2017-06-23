package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class PaymentPage {

    private WebDriver driver = null;
    private WebDriverWait wait;


    private By CARD_NUMBER_FIELD_BY = By.xpath("//input[@id='number']");
    private By CARD_NAME_FIELD_BY = By.xpath("//input[@id='name']");
    private By CARD_EXPIRATION_DATE_FIELD_BY = By.xpath("//input[@id='expiry']");
    private By CARD_CVV_FIELD_BY = By.xpath("//input[@id='verification_value']");
    private By COMPLETE_ORDER_BY = By.xpath("//div[@data-step='payment_method']//button[@type='submit']");
    private By CARD_NUMBER_IFRAME_BY = By.xpath("//iframe");


    PaymentPage(WebDriver driver, int waitTime){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(CARD_NUMBER_IFRAME_BY));
    }

    public void inputPaymentCardInfo(HashMap userInfo){
        driver.switchTo().defaultContent();
        List<WebElement> options = driver.findElements(CARD_NUMBER_IFRAME_BY);
        driver.switchTo().frame(options.get(0).getAttribute("id"));
        driver.findElement(CARD_NUMBER_FIELD_BY).sendKeys(userInfo.get("Card Number").toString());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(options.get(1).getAttribute("id"));
        driver.findElement(CARD_NAME_FIELD_BY).sendKeys(userInfo.get("Name on Card").toString());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(options.get(2).getAttribute("id"));
        driver.findElement(CARD_EXPIRATION_DATE_FIELD_BY).sendKeys(userInfo.get("Card Expiration Date").toString());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(options.get(3).getAttribute("id"));
        driver.findElement(CARD_CVV_FIELD_BY).sendKeys(userInfo.get("CVV").toString());

        driver.switchTo().defaultContent();
    }



}
