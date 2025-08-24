package API;

import data.UserData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthAPI {
    static final String REGISTER_USER_API = "/api/auth/register";
    static final String LOGIN_USER_API = "/api/auth/login";
    static final String TOKEN_USER_API = "/api/auth/token";
    static final String USER_API = "/api/auth/user";

    // метод для шага "Создание пользователя":
    @Step("Send POST request to /api/auth/register")
    public static Response registerUser(UserData userData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(userData)
                .when()
                .post(REGISTER_USER_API);
        return response;
    }

    // метод для шага "Удаление пользователя":
    @Step("Send POST request to /api/auth/user")
    public static Response deleteUser(String accessToken) {
        Response response = given()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_API);
        return response;
    }

    // метод для шага "Авторизация пользователя":
    @Step("Send POST request to /api/auth/token")
    public static Response loginUser(UserData userData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(userData)
                .when()
                .post(LOGIN_USER_API);
        return response;
    }

    // метод для шага "Получение токена":
    @Step("Send POST request to /api/auth/login")
    public static Response tokenUser(UserData userData) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(userData)
                .when()
                .post(TOKEN_USER_API);
        return response;
    }
}