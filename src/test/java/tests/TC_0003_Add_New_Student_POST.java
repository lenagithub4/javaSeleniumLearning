package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0003_Add_New_Student_POST {

    String postEndPoint = "http://thetestingworldapi.com/api/studentsDetails";
    @Test
    public void addNewStudentPostTest(){

        // Pre-requisite
        RequestSpecification postRequest = RestAssured.given();
        postRequest.body("{\"id\":1,\"first_name\":\"Lena\",\"middle_name\":\"sample string 3\",\"last_name\":\"sample string 4\",\"date_of_birth\":\"sample string 5\"}");
        postRequest.header("content-type", "application/json, text/json");


        Response postresponse = postRequest.post(postEndPoint);
        System.out.println(postresponse.statusCode());
        Assert.assertEquals(postresponse.statusCode(),201);
        Assert.assertEquals(postresponse.jsonPath().getString("data.first_name"), "Jelena_01");
        System.out.println(postresponse.asPrettyString());


    }
}
