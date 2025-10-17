package tests.applicationTesting;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TC_005_Get_Json_data {
    @Test
    public void validate_json_response()
    {
        String actualAuthor = when()
                .get("http://localhost:3000/posts/1")
                .then()
                .contentType(ContentType.JSON)
                .extract().path("author");


        Assert.assertEquals(actualAuthor, "John Doe");
    }

    @Test
    public void validate_multiple_json_response()
    {
        ValidatableResponse response = when()
                .get("http://localhost:3000/posts/1")
                .then()
                .contentType(ContentType.JSON);

        String actualAuthor = response.extract().path("author");
        String actualTitle = response.extract().path("title");
        String actualId  = response.extract().path("id");



        Assert.assertEquals(actualAuthor, "John Doe");
        Assert.assertEquals(actualTitle,"title");
        Assert.assertEquals(actualId, "1");

    }
}
