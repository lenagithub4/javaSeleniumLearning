package tests.gettestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_0011_GetRequestWithPathParameters {

    String baseURL = "https://reqres.in/";
    String path = "api/users/";
    RequestSpecification reqSpec;

    @BeforeMethod
    public void setConfiguration() {
        reqSpec = RestAssured.given();
        reqSpec.baseUri(baseURL);
        reqSpec.basePath(path);

        // Path Parameter
        reqSpec.pathParam("userId", 1);

        // Print Request Content
        System.out.println(reqSpec.log().all());
    }



    @Test
        public void tc0011(){
        Response getResponse = reqSpec.get("{userId}");
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.prettyPrint());
    }
}
