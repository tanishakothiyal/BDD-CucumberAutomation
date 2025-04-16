package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.login("simplynooffence@gmail.com", "test@123");  // Replace with valid test account
    }

    @Then("User should be logged in and see their dashboard")
    public void user_should_see_dashboard() {
        assertTrue(driver.getPageSource().contains("My Account") || driver.getCurrentUrl().contains("customer/account"));
    }
}