package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class LoginPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void successfulLoginTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();

        //both methods are validating yhe technically same thing, if the user is redirected to the same page.
        assertEquals("Products", productsPage.productsTextDisplayed());
        assertTrue(productsPage.isProductsTextDisplayed());

    }

    //--color_font-size validation-----------------------
    @Test
    public void loginFormInitialStateUITest() {
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getUsernameFieldFontType());
        assertEquals("14px", loginPage.getUsernameFieldFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getPasswordFieldFontType());
        assertEquals("14px", loginPage.getPasswordFieldFontSize());

        assertEquals("Login", loginPage.getLoginButtonText());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getLoginButtonFontType());
        assertEquals("16px", loginPage.getLoginButtonFontSize());

        assertEquals("#3ddc91", loginPage.getLoginButtonColor());
    }
//    -----End color_font-size validation --------------------------------------------

    //----------Error Message--------------------------
    @Test
    public void errorMessageTestInvalidUsernameAndPassword() {
        loginPage.enterUsername("standard_user123");
        loginPage.enterPassword("secret_sauce123");

        loginPage.clickLogin();

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageTestDisplayed());
        assertTrue(loginPage.isErrorMessageTestDisplayed());

    }

    @Test
    public void errorMessageTestInvalidPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce123");

        loginPage.clickLogin();

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageTestDisplayed());
        assertTrue(loginPage.isErrorMessageTestDisplayed());

    }

    @Test
    public void errorMessageEmptyFieldTest() {
        loginPage.clickLogin();

        assertEquals("Epic sadface: Username is required", loginPage.errorMessageTestDisplayed());
        assertTrue(loginPage.isErrorMessageTestDisplayedEmptyField());
    }

    @Test
    public void errorMessageEmptyUsernameValidPasswordTest() {
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();

        assertEquals("Epic sadface: Username is required", loginPage.errorMessageTestDisplayed());
        assertTrue(loginPage.isErrorMessageTestDisplayedEmptyField());
    }

    @Test
    public void errorMessageEmptyPasswordValidUsernameTest() {
        loginPage.enterUsername("standard_user");

        loginPage.clickLogin();

        assertEquals("Epic sadface: Password is required", loginPage.errorMessageTestDisplayed());
    }

    @Test
    public void errorMessageInvalidUsernameEmptyPasswordTest() {
        loginPage.enterUsername("standard_user123");

        loginPage.clickLogin();

        assertEquals("Epic sadface: Password is required", loginPage.errorMessageTestDisplayed());
    }

    //Error message close
    @Test
    public void removingErrorMessage() {
        loginPage.clickLogin();

        loginPage.clickErrorMessageXButton();
        assertTrue(loginPage.isErrorMessageDisplayed());
        //kaj mene e obratno, kaj Stefan ovde e so assertFalse
    }

    //Error message background color and text color validation
    @Test
    public void loginFormInitialStateErrorMessageTest() {
        loginPage.clickLogin();
        assertEquals("#e2231a", loginPage.getErrorMessageBackgroundColor());
        assertEquals("#ffffff", loginPage.getErrorMessageTextColor());
        assertEquals("14px", loginPage.getErrorMessageFontSize());

    }
    //    -----End Error Message---------------------------------

    @After
    public void tearDown() {
        driver.quit();
    }
}
