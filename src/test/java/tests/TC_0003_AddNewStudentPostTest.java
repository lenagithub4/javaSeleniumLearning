package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0003_AddNewStudentPostTest {

    String postEndPoint = "https://thetestingworldapi.com/api/studentsDetails";
    @Test
    public void addNewStudentPostTest(){

        // Pre-requisite
        RequestSpecification postRequest = RestAssured.given();
        postRequest.body("{\"id\":1,\"first_name\":\"Lena\",\"middle_name\":\"Vladimirovna\",\"last_name\":\"Usc\",\"date_of_birth\":\"04/11/2001\"}");
        postRequest.header("content-type", "application/json");



        Response postresponse = postRequest.post(postEndPoint);
        System.out.println(postresponse.statusCode());
        Assert.assertEquals(postresponse.statusCode(),201);
        Assert.assertEquals(postresponse.jsonPath().getString("first_name"), "Lena");
        System.out.println(postresponse.asPrettyString());


    }
}
