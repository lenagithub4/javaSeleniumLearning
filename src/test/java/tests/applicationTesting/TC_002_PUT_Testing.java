package tests.applicationTesting;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.automation.common.CreatePost;


import static io.restassured.RestAssured.given;

public class TC_002_PUT_Testing {

    @Test
    public void updateResource(){

        int i=1;
        CreatePost cpost = new CreatePost();
        cpost.setId(i);
        cpost.setTitle("New title");
        cpost.setAuthor("New author");


        given()
                .contentType(ContentType.JSON)
                .body(cpost)
                .when()
                .post("http://localhost:3000/posts"+i)
                .then()
                .statusCode(200);


    }

}
