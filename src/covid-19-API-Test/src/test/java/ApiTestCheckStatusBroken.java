import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTestCheckStatusBroken {

    @Test
    public void getcheckStatusCodeApiUserBroken() {
        RestAssured.baseURI = "https://gorest.co.in/public-api/users";
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/comments")
                .then()
                .extract().response();

        if(response.statusCode() != 200)
            Assert.fail("O status da API é diferente de 200 " +response.statusCode());
    }
}
