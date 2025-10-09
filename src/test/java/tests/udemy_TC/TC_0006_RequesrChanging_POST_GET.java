package tests.udemy_TC;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0006_RequesrChanging_POST_GET {
    String applicationBaseUrl = "https://thetestingworldapi.com/";
    String firstName = "Jelena";
    String lastName = "Uscelemova";
    String middleName = "Jennifer";
    String dob = "12/12/1995";

    @Test
    public void addAndValidateStudent() {

        // Send a Post Request
        RequestSpecification postRequestSpecification = RestAssured.given();
        postRequestSpecification.body("{\"id\":1,\"first_name\":\"Lena02\",\"middle_name\":\"Vladimirovna\",\"last_name\":\"Usc\",\"date_of_birth\":\"04/11/2001\"}");
        postRequestSpecification.header("content-type", "application/json");

        Response postResponse = postRequestSpecification.post(applicationBaseUrl+"api/studentsDetails");
        System.out.println(" Post Request Response ");
        System.out.println("***************");
        System.out.println(postResponse.asPrettyString());

        // Retch id from response using JSON Path
        String studentId = postResponse.jsonPath().getString("id");

        Response getResponse = RestAssured.get(applicationBaseUrl+"api/studentsDetails/"+studentId);
        System.out.println(getResponse.asPrettyString());
        Assert.assertEquals(getResponse.statusCode(),200);




    }
}
