package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class ProductPage {

    WebDriver driver = null;
    WebDriverWait wait;


    By SIZE_SELECTION_BY = By.xpath("//form//select");
    By ADD_TO_CART_BY = By.xpath("//form//input[@type='submit' and contains(@value, 'PURCHASE')]");


    ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BY));
    }

    public void addShoeToCart(String size){
        Select dropdown = new Select(driver.findElement(SIZE_SELECTION_BY));
        dropdown.selectByVisibleText(size);
        driver.findElement(ADD_TO_CART_BY).click();
    }



}
