package tests.udemy_TC;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TC_0009_AddNewStudentPOST_BDD {

    String postEndPoint = "https://thetestingworldapi.com/api/studentsDetails";
    @Test
    public void addNewStudentPostTest(){

        String bodyData = "{\"id\":1,\"first_name\":\"Lena02\",\"middle_name\":\"Vladimirovna\",\"last_name\":\"Usc\",\"date_of_birth\":\"04/11/2001\"}";

        // Pre-requisite
        given()
                .contentType(ContentType.JSON)
                .body(bodyData)
        .when()
                .post(postEndPoint)

        .then()
                .statusCode(201);




    }
}
