package tests.posttestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;

public class TC_0015_AddNewStudentPOST_Body_ExternalJsonRead {

    String postEndPoint = "https://thetestingworldapi.com";
    String basePath = "/api/studentsDetails";

    RequestSpecification request;

    @BeforeMethod
    public void setConfiguration() throws IOException {

        String inputData = "";

        //making connection to file
        File jsonBody = new File("./RequestPayload/AddStudentRequest.json");
        FileReader fileReader = new FileReader(jsonBody);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String jsonContent = bufferedReader.readLine();

        while (jsonContent != null) {
            inputData = inputData + jsonContent;
            jsonContent = bufferedReader.readLine();

        }

        request = RestAssured.given();
        request.baseUri(postEndPoint);
        request.basePath(basePath);
        request.header("content-type", "application/json");
        request.body(jsonBody);
        System.out.println(request.log().all());

    }


    @Test
    public void addNewStudentPostTest() {
        Response response = request.post();
        System.out.println(response.statusCode());
        System.out.println(response.body().asPrettyString());

    }
}
