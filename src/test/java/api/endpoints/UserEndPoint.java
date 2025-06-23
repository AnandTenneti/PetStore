package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import api.payload.User;

public class UserEndPoint {

    public static Response createUser(User payload) {
        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().
                post(Routes.postURL);
        return response;
    }
    public static Response readUser(String userName) {
        Response response = given().
                pathParam("username",userName).
                when().
                get(Routes.getURL);
        return response;
    }
    public static Response updateUser(String userName, User payload) {
        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                pathParam("username",userName)
                .body(payload).
                when().
                put(Routes.putURL);
        return response;
    }
    public static Response deleteUser(String userName) {
        Response response = given().
                pathParam("username",userName).
                when().
                delete(Routes.deleteURL);
        return response;
    }
}
