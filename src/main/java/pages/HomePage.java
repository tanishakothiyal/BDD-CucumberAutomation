package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstProduct = By.cssSelector("li.product-item a.product-item-link");

    public void openFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}