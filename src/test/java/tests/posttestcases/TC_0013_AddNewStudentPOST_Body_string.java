package tests.posttestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0013_AddNewStudentPOST_Body_string {

    String postEndPoint = "https://thetestingworldapi.com/api/studentsDetails";
    @Test
    public void addNewStudentPostTest(){

        String requestBody = "{\"id\":1,\"first_name\":\"Lena02\",\"middle_name\":\"Vladimirovna\",\"last_name\":\"Usc\",\"date_of_birth\":\"04/11/2001\"}";

        // Pre-requisite
        RequestSpecification postRequest = RestAssured.given();
        postRequest.body(requestBody);
        postRequest.header("content-type", "application/json");

        System.out.println(postRequest.log().all());



        Response postresponse = postRequest.post(postEndPoint);
        System.out.println(postresponse.statusCode());
        Assert.assertEquals(postresponse.statusCode(),201);
        Assert.assertEquals(postresponse.jsonPath().getString("first_name"), "Lena02");
        System.out.println(postresponse.asPrettyString());


    }
}
