package tests.udemy_TC;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0004_UpdateStudentDataPUT {

    String putEndPoint = "https://thetestingworldapi.com/api/studentsDetails/10697226";
    @Test
    public void addNewStudentPostTest(){

        // Pre-requisite
        RequestSpecification putRequestSpec = RestAssured.given();
        putRequestSpec.body("{\"id\":10697226,\"first_name\":\"Lena01\",\"middle_name\":\"Vladimirovna\",\"last_name\":\"Usc\",\"date_of_birth\":\"04/11/1998\"}");
        putRequestSpec.header("content-type", "application/json");



        Response putresponse = putRequestSpec.put(putEndPoint);
        System.out.println(putresponse.statusCode());
        System.out.println(putresponse.asPrettyString());

        //Adding validation
        Assert.assertEquals(putresponse.statusCode(),200);



    }
}
