package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    Actions actions;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
    }

    // ------------------ Locators ---------------------
    private By productsTitle = By.className("title");
    private By dropdownSorting = By.className("product_sort_container");
    private By productsNamesList = By.className("inventory_item_name");
    private By productsPriceList = By.className("inventory_item_price");
    private By backPackProductTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By shoppingCartLink = By.className("shopping_cart_link");
    private By addToCard = By.className("btn_inventory");

    private  By titleProductClick = By.cssSelector(".inventory_item_label a");

    // ------------------- Actions ---------------------
    public String productsTextDisplayed() {
        return driver.findElement(productsTitle).getText();
    }

    public boolean isProductsTextDisplayed() {
        return driver.findElement(productsTitle).getText().equals("Products");
    }

    public void titleProductClick(int index) {
        driver.findElements(titleProductClick).get(index).click();
    }

    // --------------- Sorting -----------------
    public List<WebElement> getAllOptionsFromOrderingDropDown() {
        Select orderingDropDown = new Select(driver.findElement(dropdownSorting));

        return orderingDropDown.getOptions();
    }

    public void selectOrderingDropDownOption(int optionIndex) {
        Select orderingDropDown = new Select(driver.findElement(dropdownSorting));
        orderingDropDown.selectByIndex(optionIndex);
    }

    public String getTextFromOrderingDropDown() {
        Select orderingDropDown = new Select(driver.findElement(dropdownSorting));
        return orderingDropDown.getFirstSelectedOption().getText();
    }

    public void addFirstProductToCart() {
        driver.findElements(addToCard).get(0).click();
    }

    public void addSecondProductToCart() {
        driver.findElements(addToCard).get(1).click();
    }

    public void shoppingCartLinkClick() {
        driver.findElement(shoppingCartLink).click();
    }

    public boolean isShoppingCartLinkDisplayed() {
        return driver.findElement(shoppingCartLink).isDisplayed();
    }

    //    -------------------------------------------------------------------------------
    public boolean areAllProductsPricesDescending() {
        List<Double> productPrice = new ArrayList<>();

        List<WebElement> priceElements = driver.findElements(productsPriceList);

        for (int i = 0; i < priceElements.size(); i++) {
            productPrice.add(Double.parseDouble(priceElements.get(i).getText().substring(1)));
        }

        for (int i = 0; i < productPrice.size() - 1; i++) {
            if (productPrice.get(i) < productPrice.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
//    -----------------------------------------------------------------------------

    //    Validacija za sortiranje po azbucen red
    public List<String> getAllProductsNames() {
        List<String> productNames = new ArrayList<>();

        List<WebElement> nameElements = driver.findElements(productsNamesList);

        for (int i = 0; i < nameElements.size(); i++) {
            productNames.add(nameElements.get(i).getText());
        }
        return productNames;
    }

    // Hover_title_color_product
    public void hoverBackPackTitle() {
        WebElement backPackTitle = driver.findElement(backPackProductTitle);

        actions.moveToElement(backPackTitle).perform();
    }

    public String getColorFromBackPackTitle() {
        Color loginBtnColorHover =
                Color.fromString(driver.findElement(backPackProductTitle).getCssValue("color"));
        return loginBtnColorHover.asHex();
    }


}
