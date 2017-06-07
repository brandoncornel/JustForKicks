package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Created by brandoncornel on 6/3/17.
 */
public class CheckoutPage {

    WebDriver driver = null;
    WebDriverWait wait;

    By EMAIL_FIELD_BY = By.xpath("//input[@placeholder='Email']");
    By FIRST_NAME_FIELD_BY = By.xpath("//input[@placeholder='First name']");
    By LAST_NAME_FIELD_BY = By.xpath("//input[@placeholder='Last name']");
    By ADDRESS_FIELD_BY = By.xpath("//input[@placeholder='Address']");
    By APT_SUITE_FIELD_BY = By.xpath("//input[@placeholder='APT/SUITE']");
    By CITY_FIELD_BY = By.xpath("//input[@placeholder='City']");
    By ZIP_CODE_FIELD_BY = By.xpath("//input[@placeholder='ZIP CODE']");
    By PHONE_FIELD_BY = By.xpath("//input[@placeholder='Phone']");
    By COUNTRY_DROPDOWN_BY = By.xpath("//select[@data-backup='country']");
    By STATE_DROPDOWN_BY = By.xpath("//select[@data-backup='province']");
    By CONTINUE_BUTTON_BY = By.xpath("//div[@data-step='contact_information']//button[@type='submit']");


    //By addToCartButton = By.xpath("//form//input[@type='submit' and contains(@value, 'PURCHASE')]");


    CheckoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void waitForPage(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD_BY));

    }

    public void fillOutFormAndCheckout(HashMap userInfo){
        driver.findElement(EMAIL_FIELD_BY).sendKeys(userInfo.get("Email").toString());
        driver.findElement(FIRST_NAME_FIELD_BY).sendKeys(userInfo.get("First Name").toString());
        driver.findElement(LAST_NAME_FIELD_BY).sendKeys(userInfo.get("Last Name").toString());
        driver.findElement(ADDRESS_FIELD_BY).sendKeys(userInfo.get("Address").toString());
        driver.findElement(APT_SUITE_FIELD_BY).sendKeys(userInfo.get("Apt/Suite").toString());
        driver.findElement(CITY_FIELD_BY).sendKeys(userInfo.get("City").toString());
        driver.findElement(ZIP_CODE_FIELD_BY).sendKeys(userInfo.get("Zip Code").toString());
        driver.findElement(PHONE_FIELD_BY).sendKeys(userInfo.get("Phone").toString());

        Select countryDropdown = new Select(driver.findElement(COUNTRY_DROPDOWN_BY));
        countryDropdown.selectByVisibleText(userInfo.get("Country").toString());

        Select cityDropdown = new Select(driver.findElement(STATE_DROPDOWN_BY));
        cityDropdown.selectByVisibleText(userInfo.get("State").toString());

        driver.findElement(CONTINUE_BUTTON_BY).click();


    }
}
