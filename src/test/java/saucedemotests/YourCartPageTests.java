package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YourCartPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);

        //pre-requisite
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

//        Thread.sleep(1000);
        productsPage.addFirstProductToCart();
//        Thread.sleep(1000);
        productsPage.addSecondProductToCart();
        Thread.sleep(2000);
        productsPage.shoppingCartLinkClick();
        Thread.sleep(1000);
    }

    @Test
    public void productsTitleTextDisplayedTest() {
        assertEquals("Sauce Labs Backpack", yourCartPage.productsTitleTextDisplayed());
    }

    @Test
    public void cartQuantityLabelDisplayedTest() {
        assertEquals("QTY", yourCartPage.cartQuantityLabelDisplayed());
        assertTrue(yourCartPage.isCartQuantityLabelDisplayed());
    }

    @Test
    public void cartQuantityTest() {
        assertEquals("1", yourCartPage.cartQuantity());
//        assertEquals(Integer.valueOf(2), yourCartPage.cartQuantity());
    }

    @Test
    public void cartDescriptionLabelDisplayedTest() {
        assertEquals("Description", yourCartPage.cartDescriptionLabelDisplayed());
        assertTrue(yourCartPage.isCartDescriptionLabelDisplayed());
    }

    @Test
    public void isInventoryItemNameDisplayedTest() {
        assertTrue(yourCartPage.isInventoryItemNameDisplayed());
    }

    @Test
    public void inventoryItemDescriptionTest() {
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                yourCartPage.inventoryItemDescription());
    }

    @Test
    public void inventoryItemPriceTest() {
        assertEquals("$29.99", yourCartPage.inventoryItemPrice());
    }

    @Test
    public void isRemoveBackpackBtnDisplayedTest() {
        assertTrue(yourCartPage.removeBackpackBtn());
        assertEquals("2", yourCartPage.shoppingCartBadge());
    }

    @Test
    public void removeFirstProductsTest() throws InterruptedException{
        yourCartPage.removeFirstProductToCart();
        Thread.sleep(1000);
        assertEquals("1", yourCartPage.shoppingCartBadge());
        assertEquals("Sauce Labs Bike Light", yourCartPage.productsTitleTextDisplayed());
    }

    @Test
    public void removeSecondProductsTest() throws InterruptedException{
        yourCartPage.removeSecondProductToCart();
        Thread.sleep(1000);
        assertEquals("1", yourCartPage.shoppingCartBadge());
        assertEquals("Sauce Labs Backpack", yourCartPage.productsTitleTextDisplayed());
    }

    @Test
    public void continueShoppingBtnTest() throws InterruptedException {
        yourCartPage.continueShoppingBtn();
        Thread.sleep(1000);
    }

    @Test
    public void checkoutBtnTest() throws InterruptedException {
        yourCartPage.checkoutBtn();
        Thread.sleep(1000);
    }

    /*------ Hover --------*/
    @Test
    public void hoverProductsTitleTest() throws InterruptedException {
        Thread.sleep(1000);
        yourCartPage.hoverProductsTitle();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
