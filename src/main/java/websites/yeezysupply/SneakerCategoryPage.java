package websites.yeezysupply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by brandoncornel on 6/3/17.
 */
public class SneakerCategoryPage {

    private WebDriver driver = null;
    private WebDriverWait wait;

    private By SNEAKERS_BY = By.xpath("//div[@id='js-main']//a");

    SneakerCategoryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void waitForPage(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(SNEAKERS_BY));

    }

    public void goToProductPage(){
        List<WebElement> shoes = driver.findElements(SNEAKERS_BY);
        for(int i = 0;i<shoes.size();i++){
            String[] hrefSplit = shoes.get(i).getAttribute("href").split("-");
            for(int j = 0;j<hrefSplit.length;j++){
                System.out.println(hrefSplit[j]);
                if(hrefSplit[j].equals("cream")){
                    System.out.println("FOUND");
                    break;
                }
            }
        }
    }
}
