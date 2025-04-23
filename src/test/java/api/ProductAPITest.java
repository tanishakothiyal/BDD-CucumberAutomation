package api;

import io.qameta.allure.testng.AllureTestNg;
import io.qameta.allure.testng.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.qameta.allure.*;

@Epic("API Automation")
@Feature("Product APIs")
@Tag("API")

@Listeners({AllureTestNg.class})
public class ProductAPITest extends BaseAPITest {
}
    /*
    @Test
    @Description("Verify the products list API returns a valid response")
    public void testGetProducts() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/products?searchCriteria[pageSize]=5");

        response.then().statusCode(200);
        Assert.assertFalse(response.getBody().asString().isEmpty());
    }
}
*/