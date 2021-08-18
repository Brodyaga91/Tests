import com.sun.org.apache.xpath.internal.operations.String;
import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.GET_LOGIN_INFO;
import static constants.Constants.Path.AUTH_PATH;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Tests extends TestConfig {
    @Test
    public void Case1(){
        given().log().uri().
                when().get(GET_LOGIN_INFO)
                .then()
                .body("meta.code",equalTo("BADPARAMS"))
                .body("meta.message",equalTo("Не переданы параметры (BADPARAMS)") )
                .log().body().statusCode(400);
    }

    @Test
    public void Case9(){
        given().log().uri().queryParam("login","0830000015").
                when().get(GET_LOGIN_INFO)
                .then()
                .body("meta.code",equalTo("NEED_REG2"))
                //.body("meta.message", )
                .log().body().statusCode(500);
    }

    @Test
    public void Case18(){
        given().log().uri().queryParam( "login","9645865743").
                when().get(GET_LOGIN_INFO).
                then()
                .body("type",equalTo("mobile"))
                .log().body().statusCode(200);
    }

    @Test
    public void Case20(){
        given().log().uri().queryParam("login","0894887359").
                when().get(GET_LOGIN_INFO).
                then()
                .body("type",equalTo("fttb"))
                .body("isConfirm",equalTo(true))
                .log().body().statusCode(200);
    }
}
