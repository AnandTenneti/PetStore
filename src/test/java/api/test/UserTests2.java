package api.test;

import api.endpoints.UserEndPoint;
import api.endpoints.UserEndPoint2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void setUpData() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.number().randomDigitNotZero());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().phoneNumber());
        userPayload.setUserStatus(faker.number().randomDigitNotZero());
    }

    @Test(priority = 1)
    public void createUser() throws InterruptedException {
        // Code to create user using userPayload
        System.out.println("Creating user with payload: " + userPayload);
        // Add your API call logic here
        Response response = UserEndPoint2.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void readUserByName() throws InterruptedException {

        // Code to read user
        System.out.println("Reading user with username: " + userPayload.getUsername());
        Thread.sleep(5000);
        Response response = UserEndPoint2.readUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUserByName() {
        // Code to update user
        System.out.println("Updating user with username: " + userPayload.getUsername());
        userPayload.setFirstName(faker.name().firstName());
        Response response = UserEndPoint2.updateUser(userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        response = UserEndPoint.readUser(userPayload.getUsername());
        response.then().log().all();
    }

    @Test(priority = 4)
    public void deleteUserByName() throws InterruptedException {
        // Code to delete user
        System.out.println("Deleting user with username: " + userPayload.getUsername());
        Response response = UserEndPoint2.deleteUser(userPayload.getUsername());
        response.then().log().all();
        Thread.sleep(5000);
        //Assert.assertEquals(response.getStatusCode(), 200);

        // Verify deletion
        response = UserEndPoint2.readUser(userPayload.getUsername());
//        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 404, "User should be deleted and not found");
    }
}
