package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class PaymentPage {

    WebDriver driver = null;
    WebDriverWait wait;


    By CARD_NUMBER_FIELD_BY = By.xpath("//input[@id='number']");
    By CARD_NAME_FIELD_BY = By.xpath("//input[@id='name']");
    By CARD_EXPIRATION_DATE_FIELD_BY = By.xpath("//input[@id='expiry']");
    By CARD_CVV_FIELD_BY = By.xpath("//input[@id='verification_value']");
    By COMPLETE_ORDER_BY = By.xpath("//div[@data-step='payment_method']//button[@type='submit']");
    By CARD_NUMBER_IFRAME_BY = By.xpath("//iframe");


    PaymentPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
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
        driver.findElement(COMPLETE_ORDER_BY).click();
    }



}
