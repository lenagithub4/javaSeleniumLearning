package tests.udemy_TC;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0005_deleteStudentDataDELETE {

    String deleteEndPoint = "https://thetestingworldapi.com/api/studentsDetails/1069726";
    @Test
    public void deleteStudentPostTest(){

        // Pre-requisite

        Response deleteStudent = RestAssured.delete(deleteEndPoint);
        System.out.println(deleteStudent.statusCode());
        System.out.println(deleteStudent.asPrettyString());


        Assert.assertEquals(deleteStudent.statusCode(),200);




    }
}
