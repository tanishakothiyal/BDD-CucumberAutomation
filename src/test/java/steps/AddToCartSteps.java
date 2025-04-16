package steps;

import factory.DriverFactory;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.AddToCartPage;
import pages.HomePage;

public class AddToCartSteps {

    WebDriver driver;
    AccountPage accountPage;
    HomePage homePage;
    AddToCartPage addToCartPage;

    public AddToCartSteps () {
        this.driver = Hooks.getDriver();
        this.addToCartPage = new AddToCartPage(driver);
        this.accountPage = new AccountPage(driver);
    }

    @Given("User should be on the account page")
    public void user_should_be_on_account_page() {
        Assert.assertTrue(accountPage.isAccountHeaderVisible(), "User is not on the Account page");
    }

    @When("User navigates to the homepage")
    public void user_navigates_to_homepage() {
        accountPage.clickHomeIcon(); // or use driver.get("https://yourstore.com/");
    }

    @When("User selects a product from the listing")
    public void select_product_from_listing() {
        addToCartPage.openFirstProductFromListing();
    }

    @When("User selects size {string}")
    public void user_selects_size(String size) {
        addToCartPage.selectSize(size);
    }

    @When("User selects color {string}")
    public void user_selects_color(String color) {
        addToCartPage.selectColor(color);
    }

    @When("User clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button() {
        addToCartPage.clickAddToCart();
    }

    @Then("Product should be added with color {string} and size {string}")
    public void verify_product_added(String color, String size) {
        Assert.assertTrue(addToCartPage.getSuccessMessage().contains("You added"), "Success message not found");
    }

    @Then("Cart icon should show {int} item")
    public void cart_icon_should_show_item(int count) {
        Assert.assertEquals(addToCartPage.getCartItemCount(), String.valueOf(count), "Incorrect cart count");
    }
}