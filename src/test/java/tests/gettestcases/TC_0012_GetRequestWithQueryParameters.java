package tests.gettestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_0012_GetRequestWithQueryParameters {

    String baseURL = "https://reqres.in/";
    String path = "api/users/";
    RequestSpecification reqSpec;

    @BeforeMethod
    public void setConfiguration() {
        reqSpec = RestAssured.given();
        reqSpec.baseUri(baseURL);
        reqSpec.basePath(path);
        reqSpec.queryParam("page", "2");
        System.out.println(reqSpec.log().all());

           }


    @Test
        public void tc0012(){

        Response getRespomse =reqSpec.get();
        System.out.println(getRespomse.getStatusCode());
        System.out.println(getRespomse.asPrettyString());

    }
}
