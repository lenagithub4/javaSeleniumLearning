package tests.applicationTesting;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_001_GetMethod {
    @Test
    public  void tc_001_getMethod_validation()
    {
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\":1,\"title\":\"json-server\", \"author\": \"typicode\"}")
                .when()
                .post("http://localhost:3000/posts")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON);
    }
}
