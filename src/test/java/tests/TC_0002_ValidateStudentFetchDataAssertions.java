package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0002_ValidateStudentFetchDataAssertions {
    String getStudentEndpoint="http://thetestingworldapi.com/api/studentsDetails/10697157";

    @Test
    public void validateStudentFetchData(){
        Response response =  RestAssured.get(getStudentEndpoint);
        //Printung Status Code
        System.out.println("Status code is--"+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);

        //Fetch and Display Headers of Response
        System.out.println("All headers value -- " + response.getHeaders());
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");


        // Fetch specific cookies value
        System.out.println("All cookies value -- " + response.getCookies());

        // Fetch specific header value
        System.out.println("Header Date -- " + response.getHeader("Date"));
        Assert.assertEquals(response.getHeader("Server"), "Microsoft-IIS/10.0");

        //Fetch body content
        System.out.println("Body Response body -- " + response.asString());
        System.out.println("Pretty Body Response body--"+response.asPrettyString());
        Assert.assertTrue(response.asString().contains("true"));

        //validate body content with JsonPath
        Assert.assertEquals(response.jsonPath().getString("data.first_name"),"First_Test");
    }
}
