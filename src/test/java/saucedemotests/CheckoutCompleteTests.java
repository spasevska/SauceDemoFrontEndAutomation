package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutCompleteTests {

    WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;


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
        checkoutCompletePage = new CheckoutCompletePage(driver);

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

        checkoutOverviewPage.finishBtn();
        Thread.sleep(500);
    }

    @Test
    public void isTitleDisplayedTest() {
        assertTrue(checkoutCompletePage.isTitleDisplayed());
    }

    @Test
    public void isCheckoutCompleteHeaderDisplayedTest() {
        assertTrue(checkoutCompletePage.isCheckoutCompleteHeaderDisplayed());
    }

    @Test
    public void completeTextTest() {
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                checkoutCompletePage.completeText());
    }

    @Test
    public void backToProductsBtnTest() throws InterruptedException {
        checkoutCompletePage.backToProductsBtn();
        Thread.sleep(500);
    }

    @Test
    public void shoppingCartTest() throws InterruptedException {
        checkoutCompletePage.shoppingCart();
        Thread.sleep(1000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
