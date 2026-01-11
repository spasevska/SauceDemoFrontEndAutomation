package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutOverviewPage {

    private WebDriver driver;
    Actions actions;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // ---------------- Locators --------------
    private By title = By.className("title");
    private By cartQuantityLabel = By.className("cart_quantity_label");
    //      //*[@id="checkout_summary_container"]/div/div[1]/div[1]
    private By cartQuantity = By.className("cart_quantity");
    private By cartDescriptionLabel = By.className("cart_desc_label");
//    private By productsTitle = By.className("inventory_item_name");
    private By inventoryItemName = By.className("inventory_item_name");
    private By inventoryItemDescription = By.className("inventory_item_desc");
    private By inventoryItemDescription2 =
            By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private By inventoryItemPrice = By.className("inventory_item_price");
    private By summaryPaymentLabel = By.className("summary_info_label");
    private By summaryValueLabel = By.className("summary_value_label");
    private By shippingInfoLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]");
    private By shippingValueLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]");
    private By priceTotalLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]");
    private By subtotalInfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
    private By taxInfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By totalInfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
    private By cancelBtn = By.id("cancel");
    private By finishBtn = By.id("finish");

    // ------------ Actions -------------------
    public boolean isTitleOverviewDisplayed() {
        return driver.findElement(title).getText().equals("Checkout: Overview");
    }

    public boolean isCartQuantityLabelDisplayed() {
        return driver.findElement(cartQuantityLabel).getText().equals("QTY");
    }

    public String cartQuantity() {
        return driver.findElement(cartQuantity).getText();
    }

    public boolean isCartDescriptionLabelDisplayed () {
        return driver.findElement(cartDescriptionLabel).getText().equals("Description");
    }

    public String productsTitleTextDisplayed() {
        return driver.findElement(inventoryItemName).getText();
    }

    public String inventoryItemDescription() {
        return driver.findElement(inventoryItemDescription).getText();
    }

    public String inventoryItemDescription2() {
        return driver.findElement(inventoryItemDescription2).getText();
    }

    public String inventoryItemPrice() {
        return driver.findElement(inventoryItemPrice).getText();
    }

    public String summaryPaymentLabel() {
        return driver.findElement(summaryPaymentLabel).getText();
    }

    public String summaryValueLabel() {
        return driver.findElement(summaryValueLabel).getText();
    }

    public String shippingInfoLabel() {
        return driver.findElement(shippingInfoLabel).getText();
    }

    public String shippingValueLabel() {
        return driver.findElement(shippingValueLabel).getText();
    }

    public String priceTotalLabel() {
        return driver.findElement(priceTotalLabel).getText();
    }

    public String subtotalInfo() {
        return driver.findElement(subtotalInfo).getText();
    }

    public String taxInfo() {
        return driver.findElement(taxInfo).getText();
    }

    public String totalInfo() {
        return driver.findElement(totalInfo).getText();
    }

    public void cancelBtn() {
        driver.findElement(cancelBtn).click();
    }

    public void finishBtn() {
        driver.findElement(finishBtn).click();
    }

}
