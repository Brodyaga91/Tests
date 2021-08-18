package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.Path.AUTH_PATH;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.UAPI_URL;

public class TestConfig {

    RequestSpecification ReqSpecForLoginInfo=new RequestSpecBuilder()
            .addQueryParam("client_id","mybee")
            .setBaseUri(UAPI_URL)
            .setBasePath(AUTH_PATH)
            .build();

    //пока нет смысла использовать
    // ResponseSpecification RespSpecForSuccess=new ResponseSpecBuilder()
    //        .expectStatusCode(200)
      //      .build();

    @BeforeClass
    public void SetUp(){
        RestAssured.baseURI=server;
        RestAssured.basePath=path;

        RestAssured.requestSpecification=ReqSpecForLoginInfo;

    }
}