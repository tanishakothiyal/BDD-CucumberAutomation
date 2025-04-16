package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {

    WebDriver driver;

    // Constructor
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By productLink = By.cssSelector("li.product-item a.product-item-link");

// private By sizeOption(String size) {
// return By.xpath(String.format("//div[contains(@class,'swatch-option text')]/div[@option-label='%s']", size));
// }

    private By sizeOption(String size) {
        return By.xpath(String.format("//div[@option-label='%s']", size));
    }

// private By colorOption(String color) {
// return By.xpath(String.format("//div[contains(@class,'swatch-option color')]/div[@option-label='%s']", color));
// }

    private By colorOption(String color) {
        return By.xpath(String.format("//div[@option-label='%s']", color));
    }

    private final By addToCartButton = By.id("product-addtocart-button");
    private final By successMessage = By.cssSelector(".message-success");
    private final By cartItemCount = By.cssSelector("span.counter-number");

    // Wait helpers
    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        // Scroll with extra padding so it's centered in viewport
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element
        );

        // Wait for clickable AFTER scrolling
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitForVisibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Actions
    public void openFirstProductFromListing() {
        waitForElement(productLink).click();
    }

    public void selectSize(String size) {
        waitForElement(sizeOption(size)).click();
    }

    public void selectColor(String color) {
        waitForElement(colorOption(color)).click();
    }

    public void clickAddToCart() {
        waitForElement(addToCartButton).click();
    }

    public String getSuccessMessage() {
        return waitForVisibleElement(successMessage).getText();
    }

    public String getCartItemCount() {
        return waitForVisibleElement(cartItemCount).getText();
    }
}