package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YourCartPage {

    private WebDriver driver;
    Actions actions;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    /*------ Locators --------*/
    private By productsTitle = By.className("inventory_item_name");
    //    private By cartQuantityLabel = By.className("cart_quantity_label");
    private By cartQuantityLabel = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[1]");
    private By cartQuantity = By.className("cart_quantity");
    private By cartDescriptionLabel = By.className("cart_desc_label");
    private By inventoryItemName = By.className("inventory_item_name");
    private By inventoryItemDescription = By.className("inventory_item_desc");
    private By inventoryItemPrice = By.className("inventory_item_price");
    private By removeBackpackBtn = By.className("cart_button");
    private By continueShoppingBtn = By.id("continue-shopping");
    private By checkoutBtn = By.id("checkout");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    /*------ Actions --------*/
    public String productsTitleTextDisplayed() {
        return driver.findElement(productsTitle).getText();
    }

    public String cartQuantityLabelDisplayed() {
        return driver.findElement(cartQuantityLabel).getText();
    }

    public boolean isCartQuantityLabelDisplayed() {
        return driver.findElement(cartQuantityLabel).getText().equals("QTY");
    }

    public String cartQuantity() {
//        return Integer.parseInt(driver.findElement(cartQuantity).getText());
        return driver.findElement(cartQuantity).getText();
    }

    public String cartDescriptionLabelDisplayed() {
        return driver.findElement(cartDescriptionLabel).getText();
    }

    public boolean isCartDescriptionLabelDisplayed() {
        return driver.findElement(cartDescriptionLabel).getText().equals("Description");
    }

    public boolean isInventoryItemNameDisplayed() {
        return driver.findElement(inventoryItemName).isDisplayed();
//        return driver.findElement(inventoryItemName).getText().equals("Sauce Labs Backpack");
    }

    public String inventoryItemDescription() {
        return driver.findElement(inventoryItemDescription).getText();
    }

    public String inventoryItemPrice() {
        return driver.findElement(inventoryItemPrice).getText();
    }

    public boolean removeBackpackBtn() {
        return driver.findElement(removeBackpackBtn).isDisplayed();
    }

    public void removeFirstProductToCart() {
        driver.findElements(removeBackpackBtn).get(0).click();
    }

    public void removeSecondProductToCart() {
        driver.findElements(removeBackpackBtn).get(1).click();
    }

    public void continueShoppingBtn() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void checkoutBtn() {
        driver.findElement(checkoutBtn).click();
    }

    public String shoppingCartBadge() {
        return driver.findElement(shoppingCartBadge).getText();
    }

    /*------ Hover --------*/
    public void hoverProductsTitle() {
        WebElement hoverTitle = driver.findElement(productsTitle);
        actions.moveToElement(hoverTitle).perform();
    }

}
