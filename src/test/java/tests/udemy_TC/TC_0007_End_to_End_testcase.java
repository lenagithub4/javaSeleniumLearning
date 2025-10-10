package tests.udemy_TC;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0007_End_to_End_testcase {
    String applicationBaseUrl = "https://thetestingworldapi.com/";
    String firstName = "Jelena";
    String lastName = "Uscelemova";
    String middleName = "Jennifer";
    String dob = "12/12/1995";

    String myPostRequestBody = "{\"id\":1,\"first_name\":\"FNAME\",\"middle_name\":\"MNAME\",\"last_name\":\"LNAME\",\"date_of_birth\":\"DOB\"}";

    @Test
    public void addAndValidateStudent() {

        // Send a Post Request/ Adding a New Student to app
        RequestSpecification postRequestSpecification = RestAssured.given();
        postRequestSpecification.body(myPostRequestBody.replace("FNAME", firstName).replace("LNAME", lastName).replace("DOB", dob).replace("MNAME", middleName));
        postRequestSpecification.header("content-type", "application/json");

        Response postResponse = postRequestSpecification.post(applicationBaseUrl+"api/studentsDetails");
        System.out.println(" Post Request Response ");
        System.out.println("***************");
        System.out.println(postResponse.asPrettyString());

        // Fetch id from response using JSON Path
        String studentId = postResponse.jsonPath().getString("id");

        // Get Request / Fetching Same student data and validate response content

        Response getResponse = RestAssured.get(applicationBaseUrl+"api/studentsDetails/"+studentId);

        Assert.assertEquals(getResponse.statusCode(),200);
        Assert.assertEquals(getResponse.jsonPath().getString("data.first_name"),firstName);
        Assert.assertEquals(getResponse.jsonPath().getString("data.middle_name"),middleName);
        Assert.assertEquals(getResponse.jsonPath().getString("data.last_name"),lastName);
        Assert.assertEquals(getResponse.jsonPath().getString("data.date_of_birth"),dob);




    }
}
