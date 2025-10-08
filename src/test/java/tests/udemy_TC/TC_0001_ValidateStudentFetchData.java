package tests.udemy_TC;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TC_0001_ValidateStudentFetchData {
    String getStudentEndpoint="http://thetestingworldapi.com/api/studentsDetails/10697157";

    @Test
    public void validateStudentFetchData(){
        Response response =  RestAssured.get(getStudentEndpoint);
        //Printung Status Code
        System.out.println("Status code is--"+response.getStatusCode());

        //Fetch and Display Headers of Response
        System.out.println("All headers value -- " + response.getHeaders());

        // Fetch specific cookies value
        System.out.println("All cookies value -- " + response.getCookies());

        // Fetch specific header value
        System.out.println("Header Date -- " + response.getHeader("Date"));

        //Fetch body content
        System.out.println("Body Response body -- " + response.asString());
        System.out.println("Pretty Body Response body--"+response.asPrettyString());
    }
}
