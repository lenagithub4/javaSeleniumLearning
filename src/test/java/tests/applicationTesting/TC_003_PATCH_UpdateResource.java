package tests.applicationTesting;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.automation.common.CreatePost;

import static io.restassured.RestAssured.given;

public class TC_003_PATCH_UpdateResource {
    @Test
    public void updateData() {

        //Patch Request
        CreatePost cpost = new CreatePost();
        cpost.setAuthor("Update Author Name");

        given()
                .contentType(ContentType.JSON)
                .body(cpost)
                .when()
                .patch("http://localhost:3000/posts/2")
                .then()
                .statusCode(200);
    }
}
