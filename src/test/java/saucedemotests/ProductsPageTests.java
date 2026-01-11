package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsPageTests {

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

        //pre-requisite
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test
    public void titleProductClickTest() {
        productsPage.titleProductClick(0);
    }

    @Test
    public void shoppingCartLinkTest() {
        assertTrue(productsPage.isShoppingCartLinkDisplayed());
    }

    @Test
    public void addFirstProductToCartTest() {
//        assertTrue();
    }

    @Test
    public void orderingDropDownValuesTest() {
        assertEquals("Name (A to Z)", productsPage.getAllOptionsFromOrderingDropDown().get(0).getText());
        assertEquals("Name (Z to A)", productsPage.getAllOptionsFromOrderingDropDown().get(1).getText());
        assertEquals("Price (low to high)", productsPage.getAllOptionsFromOrderingDropDown().get(2).getText());
        assertEquals("Price (high to low)", productsPage.getAllOptionsFromOrderingDropDown().get(3).getText());
    }

    @Test
    public void orderingProductsFromHighToLowPriceTest() {
        productsPage.selectOrderingDropDownOption(3);

        assertEquals("Price (high to low)", productsPage.getTextFromOrderingDropDown());
        assertTrue(productsPage.areAllProductsPricesDescending());
    }

    @Test
    public void orderingProductsZtoAAlphabeticallyTest() {
        List<String> initialNamesList = productsPage.getAllProductsNames();

//        for (int i = 0; i < initialNamesList.size(); i++) {
//            System.out.println("initial list -> " + initialNamesList.get(i));
//        }

        productsPage.selectOrderingDropDownOption(1);

//        System.out.println("--------------");

        List<String> namesListAfterSelectionZToA = productsPage.getAllProductsNames();
//        for (int i =0; i < namesListAfterSelectionZToA.size(); i++) {
//            System.out.println("initial list -> " + namesListAfterSelectionZToA.get(i));
//        }
        assertEquals(initialNamesList.reversed(), namesListAfterSelectionZToA);

    }

//    Hover_color_title_product
    @Test
    public void validateColorChangeOnTitleHoverTest() throws InterruptedException{
        Thread.sleep(3000);
        assertEquals("#18583a", productsPage.getColorFromBackPackTitle());

        productsPage.hoverBackPackTitle();
        Thread.sleep(3000);
        assertEquals("#3ddc91", productsPage.getColorFromBackPackTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
