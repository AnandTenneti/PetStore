package api.endpoints;

/**
 * `
 * Swagger UI - > https://petstore.swagger.io/
 * Create User (Post) - https://petstore.swagger.io/v2/user/
 * Get User (Get) - https://petstore.swagger.io/v2/user/{username}
 * Update User (Put) - https://petstore.swagger.io/v2/user/{username}
 * Delete User (Delete) - https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
    public static String baseURL = "https://petstore.swagger.io/v2";
    // User module
    public static String postURL = baseURL + "/user";
    public static String getURL = baseURL + "/user/{username}";
    public static String putURL = baseURL + "/user/{username}";
    public static String deleteURL = baseURL + "/user/{username}";


}
