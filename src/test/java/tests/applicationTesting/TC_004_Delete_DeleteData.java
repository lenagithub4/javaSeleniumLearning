package tests.applicationTesting;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_004_Delete_DeleteData {
    @Test
    public void deleteData()
    {

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/posts/4")
                .then()
                .statusCode(200);

    }
}
