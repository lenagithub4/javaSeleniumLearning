package tests.gettestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_0010_GetRequestWithPath {

    String baseURL = "https://thetestingworldapi.com/";
    String path = "api/studentsDetails";

    @BeforeMethod
    public  void preCondition(){
        RestAssured.baseURI = baseURL;  // base URL
        RestAssured.basePath = path;    // relative URL
    }

    @Test
        public void tc0010(){

        Response getResponse=RestAssured.get();
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.asPrettyString());


    }
}
