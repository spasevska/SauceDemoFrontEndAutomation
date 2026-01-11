package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class SingleProductPage {

    public WebDriver driver;
    Actions actions;

    public SingleProductPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // ---------------- Locators --------------
    private By titleProduct = By.className("inventory_details_name");
    private By descriptionProduct = By.className("inventory_details_desc");
    private By priceProduct = By.className("inventory_details_price");
    private By backToProductsBtn = By.id("back-to-products");
    private By addToCardBtn = By.id("add-to-cart");
    private By removeBtn = By.id("remove");
    private By shoppingCartIcon = By.id("shopping_cart_container");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    // ------------ Actions -------------------
    public String titleProduct(int index) {
        return driver.findElements(titleProduct).get(index).getText();
    }

    public String titleProductFontSize(int index) {
        return driver.findElements(titleProduct).get(index).getCssValue("font-size");
    }

    public String titleProductFontFamily(int index) {
        return driver.findElements(titleProduct).get(index).getCssValue("font-family");
    }

    public String descriptionProduct(int index) {
        return driver.findElements(descriptionProduct).get(index).getText();
    }

    public String priceProduct(int index) {
        return driver.findElements(priceProduct).get(index).getText();
    }

    public void backToProductsBtn() {
        driver.findElement(backToProductsBtn).click();
    }

    public void addToCardBtn() {
        driver.findElement(addToCardBtn).click();
    }

    public void removeBtn() {
        driver.findElement(removeBtn).click();
    }

    public String removeBtnBorder() {
        return driver.findElement(removeBtn).getCssValue("border");
    }

    public String removeBtnBackgroundColor() {
        Color backgroundColorRemoveBtn = Color.fromString(
                driver.findElement(removeBtn).getCssValue("background-color"));
        return backgroundColorRemoveBtn.asHex();
    }

    public String removeBtnBorderRadius() {
        return driver.findElement(removeBtn).getCssValue("border-radius");
    }

    public String removeBtnFontSize() {
        return driver.findElement(removeBtn).getCssValue("font-size");
    }

    public String removeBtnColor() {
        Color colorRemoveBtn = Color.fromString(
                driver.findElement(removeBtn).getCssValue("color"));
        return colorRemoveBtn.asHex();
    }

    public void shoppingCartClick() {
        driver.findElement(shoppingCartIcon).click();
    }

    public String shoppingCartBadge() {
        return driver.findElement(shoppingCartBadge).getText();

    }

    public boolean isShoppingCartBadgeDisplayed() {
        return driver.findElements(shoppingCartBadge).isEmpty();

    }

}
