package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutCompletePage {

    private WebDriver driver;
    Actions actions;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // ---------------- Locators --------------
    private By title = By.className("title");
    private By checkoutCompleteHeader = By.className("complete-header");
    private By completeText = By.className("complete-text");
    private By backToProductsBtn = By.id("back-to-products");
    private By shoppingCart = By.id("shopping_cart_container");

    // ------------ Actions -------------------
    public boolean isTitleDisplayed() {
        return driver.findElement(title).getText().equals("Checkout: Complete!");
    }

    public boolean isCheckoutCompleteHeaderDisplayed() {
        return driver.findElement(checkoutCompleteHeader).getText().equals("Thank you for your order!");
    }

    public String completeText() {
        return driver.findElement(completeText).getText();
    }

    public void backToProductsBtn() {
        driver.findElement(backToProductsBtn).click();
    }

    public void shoppingCart() {
        driver.findElement(shoppingCart).click();
    }

}
