package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountHeader = By.cssSelector("h1.page-title span"); // You can refine this if needed
    private final By homeIcon = By.cssSelector("a.logo"); // This typically takes you back to the homepage

    public boolean isAccountHeaderVisible() {
        return driver.findElement(accountHeader).isDisplayed();
    }

    public void clickHomeIcon() {
        driver.findElement(homeIcon).click();
    }
}