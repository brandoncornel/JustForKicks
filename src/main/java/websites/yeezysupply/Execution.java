package websites.yeezysupply;

import BaseTests.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by brandoncornel on 6/3/17.
 */
public class Execution extends BaseTest{


    private HashMap userInfo = new HashMap();

    private void populateUserInfo(){
        userInfo.put("Email", "brandbread@gmail.com");
        userInfo.put("First Name", "Brandon");
        userInfo.put("Last Name", "Cornel");
        userInfo.put("Address", "140 Warren St");
        userInfo.put("Apt/Suite", "1A");
        userInfo.put("City", "Brooklyn");
        userInfo.put("Country", "United States");
        userInfo.put("State", "New York");
        userInfo.put("Zip Code", "11201");
        userInfo.put("Phone","570-419-5079");

        userInfo.put("Card Number", "12345678910");
        userInfo.put("Name on Card", "Brandon Cornel");
        userInfo.put("Card Expiration Date", "05/18");
        userInfo.put("CVV","051");
    }

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void buyYeezys(){
        populateUserInfo();
        setup("Chrome");
        driver.navigate().to("https://yeezysupply.com/products/womens-tubular-boot-pvc-smoke");
        //driver.navigate().to("https://yeezysupply.com/pages/footwear");

        //SneakerCategoryPage sneakerCategoryPage = new SneakerCategoryPage(driver);
        //sneakerCategoryPage.waitForPage();
        //sneakerCategoryPage.goToProductPage();
        int waitTime = 300;
        ProductPage productPage = new ProductPage(driver, waitTime);
        productPage.waitForPage();
        productPage.addShoeToCart("35");

        CartPage cartPage = new CartPage(driver, waitTime);
        cartPage.waitForPage();
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver, waitTime);
        checkoutPage.fillOutFormAndCheckout(userInfo);

        ConfirmAddressPage confirmAddressPage = new ConfirmAddressPage(driver, waitTime);
        confirmAddressPage.waitForPage();
        confirmAddressPage.confirmAddressPageContinue();

        PaymentPage paymentPage = new PaymentPage(driver, waitTime);
        paymentPage.waitForPage();
        paymentPage.inputPaymentCardInfo(userInfo);

        Long id = Thread.currentThread().getId();
        System.out.println("Instance is at payment page " + id);


    }
}
