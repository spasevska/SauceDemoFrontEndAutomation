package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SingleProductPage;

import static org.junit.Assert.*;

public class SingleProductTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SingleProductPage singleProductPage;


    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        singleProductPage = new SingleProductPage(driver);

        //pre-requisite
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        productsPage.titleProductClick(0);
        Thread.sleep(2000);

    }

    @Test
    public void titleProductTest() {
        assertEquals("Sauce Labs Backpack", singleProductPage.titleProduct(0));
        assertEquals("\"DM Mono\", sans-serif", singleProductPage.titleProductFontFamily(0));
        assertEquals("20px", singleProductPage.titleProductFontSize(0));
    }

    @Test
    public void descriptionProductTest() {
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                singleProductPage.descriptionProduct(0));
        System.out.println(singleProductPage.descriptionProduct(0));
    }

    @Test
    public void priceProductTest() {
        assertEquals("$29.99", singleProductPage.priceProduct(0));
        System.out.println(singleProductPage.priceProduct(0));
    }

    @Test
    public void backToProductsBtnTest() {
        singleProductPage.backToProductsBtn();
    }

    @Test
    public void addAndRemoveBtnTest() {
        singleProductPage.addToCardBtn();
        assertEquals("#e2231a", singleProductPage.removeBtnColor());
        assertEquals("#ffffff", singleProductPage.removeBtnBackgroundColor());
        assertEquals("4px", singleProductPage.removeBtnBorderRadius());
        assertEquals("0.8px solid rgb(226, 35, 26)", singleProductPage.removeBtnBorder());
        assertEquals("16px", singleProductPage.removeBtnFontSize());
        assertEquals("1", singleProductPage.shoppingCartBadge());

        singleProductPage.removeBtn();
        assertTrue(singleProductPage.isShoppingCartBadgeDisplayed());
    }

    @Test
    public void shoppingCartClickTest() throws InterruptedException {
        singleProductPage.shoppingCartClick();
        Thread.sleep(500);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
