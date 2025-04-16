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
    private final By addToCartButton = By.id("product-addtocart-button");
    private final By successMessage = By.cssSelector(".message-success");
    private final By cartItemCount = By.cssSelector("span.counter-number");

    // Dynamic Locators
    private By colorOption(String color) {
        return By.xpath(String.format("//div[@option-label='%s']", color));
    }

    private By sizeOption(String size) {
        return By.xpath(String.format("//div[@option-label='%s']", size));
    }

    // Utility methods
    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    private WebElement waitForVisibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollIntoView(element);
        return element;
    }

    private void scrollIntoView(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(300); // give scroll time to settle
        } catch (InterruptedException | JavascriptException ignored) {}
    }

    // Actions
    public void openFirstProductFromListing() {
        waitForElement(productLink).click();
    }

    public void selectColor(String color) {
        waitForElement(colorOption(color)).click();
    }

    public void selectSize(String size) {
        waitForElement(sizeOption(size)).click();
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