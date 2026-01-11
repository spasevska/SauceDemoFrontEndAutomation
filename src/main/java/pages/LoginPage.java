package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.util.NoSuchElementException;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Components -> Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private By errorMessageText = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    private By errorMessageXButton = By.className("error-button");

    //Actions
    public void enterUsername(String value) {
        driver.findElement(usernameField).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(passwordField).sendKeys(value);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getUsernameFieldFontType() {
        return driver.findElement(usernameField).getCssValue("font-family");
    }

    public String getUsernameFieldFontSize() {
        return driver.findElement(usernameField).getCssValue("font-size");
    }

    public String getPasswordFieldFontType() {
        return driver.findElement(passwordField).getCssValue("font-family");
    }

    public String getPasswordFieldFontSize() {
        return driver.findElement(passwordField).getCssValue("font-size");
    }

    public String getLoginButtonText() {
        return driver.findElement(loginButton).getAttribute("value");
    }

    public String getLoginButtonFontType() {
        return driver.findElement(loginButton).getCssValue("font-family");
    }

    public String getLoginButtonFontSize() {
        return driver.findElement(loginButton).getCssValue("font-size");
    }

    public String getLoginButtonColor() {
        Color loginButtonBackgroundColor =
                Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
        return loginButtonBackgroundColor.asHex();
    }

    //Error Message
    //Invalid username and password
    public String errorMessageTestDisplayed() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isErrorMessageTestDisplayed() {
        return driver.findElement(errorMessage).getText().equals("Epic sadface: Username and password do not match any user in this service");
    }

    public boolean isErrorMessageTestDisplayedEmptyField() {
        return driver.findElement(errorMessage).getText().equals("Epic sadface: Username is required");
    }

    //Error message background color and color
    public String getErrorMessageBackgroundColor() {
        Color errorMessageBackgroundColor =
                Color.fromString(driver.findElement(errorMessage).getCssValue("background-color"));
        return errorMessageBackgroundColor.asHex();
    }

    public String getErrorMessageTextColor() {
        Color errorMessageTextColor =
                Color.fromString(driver.findElement(errorMessageText).getCssValue("color"));
        return errorMessageTextColor.asHex();
    }

    public String getErrorMessageFontSize() {
        return driver.findElement(errorMessageText).getCssValue("font-size");
    }

    //Error message X button
    public void clickErrorMessageXButton() {
        driver.findElement(errorMessageXButton).click();
    }

    public Boolean isErrorMessageDisplayed() {
        try {
            driver.findElement(errorMessage).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
