package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutYourInformationTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);

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
        Thread.sleep(1500);
    }

    @Test
    public void isTitleYourInformationDisplayedTest() {
        assertTrue(checkoutYourInformationPage.isTitleYourInformationDisplayed());
    }

    @Test
    public void enterFirstLastNamePostalCodeInputFieldTest() throws InterruptedException {
        checkoutYourInformationPage.enterFirstNameInputField("Petar");
        assertEquals("14px", checkoutYourInformationPage.getFirstNameInputFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",
                checkoutYourInformationPage.getFirstNameInputFieldFontType());
        Thread.sleep(500);
        checkoutYourInformationPage.enterLastNameInputField("Petrovski");
        assertEquals("14px", checkoutYourInformationPage.getLastNameInputFieldFontSize());
        Thread.sleep(500);
        checkoutYourInformationPage.enterPostalCodeInputField("1000");
        assertEquals("14px", checkoutYourInformationPage.getPostalCodeInputFieldFontSize());
        Thread.sleep(500);
    }

    @Test
    public void getErrorMessageContainerBackgroundColorAndTextMessageFirstNameTest() throws InterruptedException {
        Thread.sleep(500);
        checkoutYourInformationPage.continueBtn();
        Thread.sleep(500);
        assertEquals("#e2231a", checkoutYourInformationPage.getErrorMessageContainerBackgroundColor());

        assertEquals("Error: First Name is required", checkoutYourInformationPage.errorMessageText());

        assertEquals("#ffffff", checkoutYourInformationPage.getErrorMessageTextColor());
    }

    @Test
    public void getErrorMessageContainerBackgroundColorAndTextMessageLastNameTest() throws InterruptedException {
        checkoutYourInformationPage.enterFirstNameInputField("Petar");
        Thread.sleep(500);
        checkoutYourInformationPage.enterLastNameInputField("Petrovski");
        Thread.sleep(500);
        checkoutYourInformationPage.continueBtn();
        Thread.sleep(500);
        assertEquals("#e2231a", checkoutYourInformationPage.getErrorMessageContainerBackgroundColor());

        assertEquals("Error: Postal Code is required", checkoutYourInformationPage.errorMessageText());

        assertEquals("#ffffff", checkoutYourInformationPage.getErrorMessageTextColor());
    }

    @Test
    public void errorMessageXBtnTest() throws InterruptedException {
        checkoutYourInformationPage.continueBtn();
        Thread.sleep(500);
        checkoutYourInformationPage.errorMessageXBtn();
        Thread.sleep(500);

    }

    @Test
    public void cancelBtnTest() {
        checkoutYourInformationPage.cancelBtn();
    }

    @Test
    public void getErrorMessageContainerBackgroundColorAndTextMessagePostalCodeTest() throws InterruptedException {
        checkoutYourInformationPage.enterFirstNameInputField("Petar");
        Thread.sleep(500);
        checkoutYourInformationPage.continueBtn();
        Thread.sleep(500);
        assertEquals("#e2231a", checkoutYourInformationPage.getErrorMessageContainerBackgroundColor());

        assertEquals("Error: Last Name is required", checkoutYourInformationPage.errorMessageText());

        assertEquals("#ffffff", checkoutYourInformationPage.getErrorMessageTextColor());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
