package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class CheckoutYourInformationPage {

    private WebDriver driver;
    Actions actions;

    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // ---------------- Locators --------------
    private By titleYourInformation = By.className("title");
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By postalCodeInputField = By.id("postal-code");
    private By errorMessageContainer = By.className("error-message-container");
    private By errorMessageText =
            By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
    private By errorXBtn = By.className("error-button");
    private By cancelBtn = By.id("cancel");
    private By continueBtn = By.id("continue");

    // ------------ Actions -------------------
    public boolean isTitleYourInformationDisplayed() {
        return driver.findElement(titleYourInformation).getText().equals("Checkout: Your Information");
    }

    public void enterFirstNameInputField(String firstName) {
        driver.findElement(firstNameInputField).sendKeys(firstName);
    }

    public void enterLastNameInputField(String lastName) {
        driver.findElement(lastNameInputField).sendKeys(lastName);
    }

    public void enterPostalCodeInputField(String postalCode) {
        driver.findElement(postalCodeInputField).sendKeys(postalCode);
    }

    public String getFirstNameInputFieldFontSize() {
        return driver.findElement(firstNameInputField).getCssValue("font-size");
    }
    public String getFirstNameInputFieldFontType() {
        return driver.findElement(firstNameInputField).getCssValue("font-family");
    }

    public String getLastNameInputFieldFontSize() {
        return driver.findElement(lastNameInputField).getCssValue("font-size");
    }
    public String getPostalCodeInputFieldFontSize() {
        return driver.findElement(postalCodeInputField).getCssValue("font-size");
    }

    public String getErrorMessageContainerBackgroundColor() {
        Color errorMessageContainerBackgroundColor =
                Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));
        return errorMessageContainerBackgroundColor.asHex();
    }

    public String errorMessageText() {
        return driver.findElement(errorMessageText).getText();
    }

    public String getErrorMessageTextColor() {
        Color errorMessageTextColor =
                Color.fromString(driver.findElement(errorMessageText).getCssValue("color"));
        return errorMessageTextColor.asHex();
    }

    public void errorMessageXBtn() {
        driver.findElement(errorXBtn).click();
    }
    public void cancelBtn() {
        driver.findElement(cancelBtn).click();
    }

    public void continueBtn() {
        driver.findElement(continueBtn).click();
    }


}
