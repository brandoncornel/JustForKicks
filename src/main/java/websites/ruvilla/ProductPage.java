package websites.ruvilla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class ProductPage {

    private WebDriver driver = null;
    private WebDriverWait wait;


    private By SIZE_SELECTION_BY = By.id("attribute196");
    private By ADD_TO_CART_BY = By.id("product-addtocart-button");
    private By CART_BY = By.xpath("//header[@id='body-header']//div[@class='header-top-cart']/a");
    private By FINISHED_ADD_TO_CART_BY = By.xpath("//button[@class='action validation-passed loading loading-done']");

    ProductPage(WebDriver driver, int waitTime){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BY));
    }

    public void addShoeToCart(String size){
        Select dropdown = new Select(driver.findElement(SIZE_SELECTION_BY));
        dropdown.selectByVisibleText(size);
        driver.findElement(ADD_TO_CART_BY).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISHED_ADD_TO_CART_BY));
        driver.findElement(CART_BY).click();
    }



}
