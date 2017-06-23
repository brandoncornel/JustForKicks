package websites.ruvilla;

import BaseTests.BaseTest;
import org.testng.annotations.Test;
import websites.Paypal.First_Paypal_Page_Login;
import websites.Paypal.Second_Paypal_Page_Login;

import java.util.HashMap;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class Execution extends BaseTest{


    private HashMap userInfo = new HashMap();

    private void populateUserInfo(){
        userInfo.put("Email", "brandbread@gmail.com");
        userInfo.put("Password","naruto21");


    }

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void buyYeezys(){
        populateUserInfo();
        setup("Chrome");
        driver.navigate().to("https://www.ruvilla.com/men/footwear/basketball/nike-air-force-1-high-07-university-red-team-red-white.html");
        int waitTime = 300;

        ProductPage productPage = new ProductPage(driver, waitTime);
        productPage.waitForPage();
        productPage.addShoeToCart("8");

        CartPage cartPage = new CartPage(driver, waitTime);
        cartPage.waitForPage();
        cartPage.checkout();

        First_Paypal_Page_Login first_paypal_page_login = new First_Paypal_Page_Login(driver, waitTime);
        first_paypal_page_login.waitForPage();
        first_paypal_page_login.login();

        Second_Paypal_Page_Login second_paypal_page_login = new Second_Paypal_Page_Login(driver, waitTime);
        second_paypal_page_login.waitForPage();
        second_paypal_page_login.login(userInfo);

        Long id = Thread.currentThread().getId();
        System.out.println("Instance is at payment page " + id);


    }

}
