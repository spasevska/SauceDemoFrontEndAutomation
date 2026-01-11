package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage {

    public WebDriver driver;

    public FooterPage (WebDriver driver) {
        this.driver = driver;
    }

    // ---------------- Locators --------------
    public By socialTwitter = By.className("social_twitter");
    public By socialFacebook = By.className("social_facebook");
    public By socialLinkedin = By.className("social_linkedin");
    public By footerText = By.className("footer_copy");

    // ------------ Actions -------------------
    public void socialTwitter() {
        driver.findElement(socialTwitter).click();
    }

    public void socialFacebook() {
        driver.findElement(socialFacebook).click();
    }

    public void socialLinkedin() {
        driver.findElement(socialLinkedin).click();
    }

    public String footerText() {
        return driver.findElement(footerText).getText();
    }

}
