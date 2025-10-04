package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {
    static {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    public static Response createUser(String name, String job) {
        String body = String.format("""
            {
                "name": "%s",
                "job": "%s"
            }
        """, name, job);

        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/users")
                .then()
                .extract().response();
    }
}
