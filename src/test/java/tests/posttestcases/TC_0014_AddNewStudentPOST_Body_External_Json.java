package tests.posttestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TC_0014_AddNewStudentPOST_Body_External_Json {

    String postEndPoint = "https://thetestingworldapi.com";
    String basePath = "/api/studentsDetails";

    RequestSpecification request;

    @BeforeMethod
    public void setConfiguration() {
        //making connection to file
        File f = new File("./RequestPayload/AddStudentRequest.json");

        request = RestAssured.given();
        request.baseUri(postEndPoint);
        request.basePath(basePath);
        request.header("content-type", "application/json");
        request.body(f);
        System.out.println(request.log().all());

    }


    @Test
    public void addNewStudentPostTest() {
        Response response = request.post();
        System.out.println(response.statusCode());
        System.out.println(response.body().asPrettyString());

    }
}
