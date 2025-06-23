package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoint2 {

    static ResourceBundle getURl() {
        ResourceBundle routes = ResourceBundle.getBundle("routes");// Load properties file
        return routes;
    }

    public static Response createUser(User payload) {
        String postURL = getURl().getString("postURL");
        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().
                post(postURL);
        return response;
    }

    public static Response readUser(String userName) {
        String getURL = getURl().getString("getURL");
        Response response = given().
                pathParam("username", userName).
                when().
                get(getURL);
        return response;
    }

    public static Response updateUser(String userName, User payload) {
        String putURL = getURl().getString("putURL");
        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                pathParam("username", userName)
                .body(payload).
                when().
                put(putURL);
        return response;
    }

    public static Response deleteUser(String userName) {
        String deleteURL = getURl().getString("deleteURL");
        Response response = given().
                pathParam("username", userName).
                when().
                delete(deleteURL);
        return response;
    }
}
