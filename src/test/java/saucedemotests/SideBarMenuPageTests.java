package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SideBarMenuPage;

import static org.junit.Assert.assertEquals;

public class SideBarMenuPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private SideBarMenuPage sideBarMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        sideBarMenu = new SideBarMenuPage(driver);

        //pre-requisite
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        sideBarMenu.clickBurgerMenu();
    }

    @Test
    public void allItemsTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("All Items", sideBarMenu.allLinksSideBarMenu(0));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
