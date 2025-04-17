package api;

import io.qameta.allure.Attachment;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;

public class BaseAPITest {
    protected static RequestSpecification requestSpec;

    static {
        baseURI = "https://magento.softwaretestingboard.com/rest/V1"; // Replace with your actual API base URL
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType("application/json")
                .build();
    }
    @Attachment(value = "Response Body", type = "application/json")
    public static String attachResponse(String response) {
        return response;
    }
}

