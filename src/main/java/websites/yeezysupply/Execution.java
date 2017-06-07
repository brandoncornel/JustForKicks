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

    @Test(invocationCount = 1)
    public void buyYeezys(){
        populateUserInfo();
        setup("Chrome");
        driver.navigate().to("https://yeezysupply.com/products/womens-tubular-boot-pvc-smoke");

        ProductPage productPage = new ProductPage(driver);
        productPage.waitForPage();
        productPage.addShoeToCart("35");

        CartPage cartPage = new CartPage(driver);
        cartPage.waitForPage();
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillOutFormAndCheckout(userInfo);

        ConfirmAddressPage confirmAddressPage = new ConfirmAddressPage(driver);
        confirmAddressPage.waitForPage();
        confirmAddressPage.confirmAddressPageContinue();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.waitForPage();
        paymentPage.inputPaymentCardInfo(userInfo);

    }
}
