package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

public class SideBarMenuPage {

    private WebDriver driver;
    Actions actions;

    public SideBarMenuPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    /*------ Locators --------*/
    private By burgerMenu = By.id("react-burger-menu-btn");
    private By burgerMenuXBtn = By.id("react-burger-cross-btn");
    private By allItems = By.id("inventory_sidebar_link");
    private By about = By.id("about_sidebar_link");
    private By logOut = By.id("logout_sidebar_link");
    private By resetAppState = By.id("reset_sidebar_link");

    /*------ Actions --------*/
    public void clickBurgerMenu() {
        driver.findElement(burgerMenu).click();
    }

    public void clickBurgerMenuXBtn() {
        driver.findElement(burgerMenuXBtn).click();
    }

    public String allLinksSideBarMenu(int linkNum) {
        WebElement menuContainer =
                driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]"));
        List<WebElement> options = menuContainer.findElements(By.tagName("a"));
        return options.get(linkNum).getText();
    }

    public String getAllItemsSideBar() {
        return driver.findElement(allItems).getText();
    }

    public String getAboutSideBar() {
        return driver.findElement(about).getText();
    }

    public String getLogOutSideBar() {
        return driver.findElement(logOut).getText();
    }

    public String getResetAppStateSideBar() {
        return driver.findElement(resetAppState).getText();
    }

    /* ------ Start hover on sidebar elements ------- */
    public void hoverAllItems() {
        WebElement hoverAllItem = driver.findElement(allItems);
        actions.moveToElement(hoverAllItem).perform();
    }

    public void hoverAbout() {
        WebElement hoverAboutItem = driver.findElement(about);
        actions.moveToElement(hoverAboutItem).perform();
    }

    public void hoverLogOutItem() {
        WebElement hoverLogOut = driver.findElement(logOut);
        actions.moveToElement(hoverLogOut).perform();
    }

    public void hoverResetAppStateItem() {
        WebElement hoverResetApp = driver.findElement(resetAppState);
        actions.moveToElement(hoverResetApp).perform();
    }
    /* ------ End hover on sidebar elements ------ */

    /* ----- Start title_color_font_element ------- */
    public String getColorFromAllItemsTitle() {
        Color textColor = Color.fromString(driver.findElement(allItems).getCssValue("color"));
        return textColor.asHex();
    }

    public String getFontSizeFromAllItemsTitle() {
        return driver.findElement(allItems).getCssValue("font-size");
    }

    public String getColorFromAboutTitle() {
        Color textColor = Color.fromString(driver.findElement(about).getCssValue("color"));
        return textColor.asHex();
    }

    public String getColorFromLogOutTitle() {
        Color textColor = Color.fromString(driver.findElement(logOut).getCssValue("color"));
        return textColor.asHex();
    }

    public String getColorFromResetAppStateTitle() {
        Color textColor = Color.fromString(driver.findElement(resetAppState).getCssValue("color"));
        return textColor.asHex();
    }
    /* ----- End title_color_element ------- */

    public void clickAboutItem() {
        driver.findElement(about).click();
    }

}
