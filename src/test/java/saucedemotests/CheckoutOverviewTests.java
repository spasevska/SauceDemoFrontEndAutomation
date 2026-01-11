package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.security.PublicKey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutOverviewTests {

    WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);

        //pre-requisite
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        productsPage.addFirstProductToCart();
        productsPage.addSecondProductToCart();
        Thread.sleep(2000);
        productsPage.shoppingCartLinkClick();
        Thread.sleep(1000);

        yourCartPage.checkoutBtn();
        Thread.sleep(500);

        checkoutYourInformationPage.enterFirstNameInputField("Petar");
        Thread.sleep(500);
        checkoutYourInformationPage.enterLastNameInputField("Petrovski");
        Thread.sleep(500);
        checkoutYourInformationPage.enterPostalCodeInputField("1000");
        Thread.sleep(500);
        checkoutYourInformationPage.continueBtn();
        Thread.sleep(500);
    }

    @Test
    public void isTitleOverviewDisplayedTest() {
        assertTrue(checkoutOverviewPage.isTitleOverviewDisplayed());
    }

    @Test
    public void isCartQuantityLabelDisplayedTest() {
        assertTrue(checkoutOverviewPage.isCartQuantityLabelDisplayed());
    }

    @Test
    public void cartQuantityTest() {
        assertEquals("1", checkoutOverviewPage.cartQuantity());
    }

    @Test
    public void isCartDescriptionLabelDisplayedTest() {
        assertTrue(checkoutOverviewPage.isCartDescriptionLabelDisplayed());
    }

    @Test
    public void productsTitleTextDisplayedTest() {
        assertEquals("Sauce Labs Backpack", checkoutOverviewPage.productsTitleTextDisplayed());
    }

    @Test
    public void inventoryItemDescriptionTest() {
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                checkoutOverviewPage.inventoryItemDescription());
    }

    @Test
    public void inventoryItemDescription2Test() {
        assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                checkoutOverviewPage.inventoryItemDescription2());
    }

    @Test
    public void inventoryItemPriceTest() {
        assertEquals("$29.99", checkoutOverviewPage.inventoryItemPrice());
    }

    @Test
    public void summaryPaymentLabelTest() {
        assertEquals("Payment Information:", checkoutOverviewPage.summaryPaymentLabel());
    }

    @Test
    public void summaryValueLabelTest() {
        assertEquals("SauceCard #31337", checkoutOverviewPage.summaryValueLabel());
    }

    @Test
    public void shippingInfoLabelTest() {
        assertEquals("Shipping Information:", checkoutOverviewPage.shippingInfoLabel());
    }

    @Test
    public void shippingValueLabelTest() {
        assertEquals("Free Pony Express Delivery!", checkoutOverviewPage.shippingValueLabel());
    }

    @Test
    public void priceTotalLabelTest() {
        assertEquals("Price Total", checkoutOverviewPage.priceTotalLabel());
    }

    @Test
    public void subtotalInfoTest() {
        assertEquals("Item total: $39.98", checkoutOverviewPage.subtotalInfo());
    }

    @Test
    public void taxInfoTest() {
        assertEquals("Tax: $3.20", checkoutOverviewPage.taxInfo());
    }

    @Test
    public void totalInfoTest() {
        assertEquals("Total: $43.18", checkoutOverviewPage.totalInfo());
    }

    @Test
    public void cancelBtnTest() throws InterruptedException{
        checkoutOverviewPage.cancelBtn();
        Thread.sleep(1000);
    }

    @Test
    public void finishBtnTest() throws InterruptedException{
        checkoutOverviewPage.finishBtn();
        Thread.sleep(500);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
