package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class FooterTests {

    WebDriver driver;
    private LoginPage loginPage;
    private FooterPage footerPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        footerPage = new FooterPage(driver);

        //pre-requisite
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(500);
    }

    @Test
    public void socialTwitterTest() {
        footerPage.socialTwitter();
    }

    @Test
    public void socialFacebookTest() {
        footerPage.socialFacebook();
    }

    @Test
    public void socialLinkedinTest() {
        footerPage.socialLinkedin();
    }

    @Test
    public void footerTextTest() {
        assertEquals("© 2026 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy",
                footerPage.footerText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
