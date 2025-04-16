package steps;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddToCartPage;

public class AddToCartSteps {

    WebDriver driver;
    AddToCartPage addToCartPage;

    public AddToCartSteps() {
        this.driver = Hooks.getDriver(); // or however you are passing the WebDriver
        this.addToCartPage = new AddToCartPage(driver);
    }

    @Given("the user is on the Product Detail Page")
    public void the_user_is_on_the_product_detail_page() {
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        addToCartPage.openFirstProductFromListing(); // Clicks the first product
    }

    @When("the user selects the colour {string}")
    public void user_selects_colour(String colour) {
        addToCartPage.selectColor(colour);
    }

    @When("the user selects the size {string}")
    public void user_selects_size(String size) {
        addToCartPage.selectSize(size);
    }

    @When("the user clicks on the {string} button")
    public void user_clicks_on_button(String buttonName) {
        addToCartPage.clickAddToCart();  // `buttonName` is for Gherkin readability
    }

    @Then("the product with colour {string} and size {string} should be added to the cart")
    public void verify_product_added(String colour, String size) {
        String successMsg = addToCartPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("You added"));
    }

    @Then("the cart icon should show {int} item")
    public void cart_icon_should_show_item(int itemCount) {
        Assert.assertEquals(String.valueOf(itemCount), addToCartPage.getCartItemCount());
    }

    @Then("the user should see a success message confirming the product was added")
    public void user_should_see_success_message() {
        Assert.assertTrue(addToCartPage.getSuccessMessage().contains("You added"));
    }
}