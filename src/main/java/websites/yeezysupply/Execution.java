package websites.yeezysupply;

import BaseTests.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class Execution extends BaseTest{

    @Test(invocationCount = 1)
    public void buyYeezys(){
        setup("Chrome");
        ProductPage pp = new ProductPage(driver);
        driver.navigate().to("https://yeezysupply.com/products/womens-tubular-boot-pvc-smoke");
        pp.waitForPage();
        pp.addShoeToCart("35");
        CartPage cp = new CartPage(driver);
        cp.waitForPage();
        cp.checkout();

    }
}
