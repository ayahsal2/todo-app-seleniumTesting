package com.qacart.todo.api;

import com.qacart.todo.models.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }
    public String getUserId() {
        return this.userId;
    }
    public String getAccessToken() {
        return this.accessToken;
    }
    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void register(){
        //Pojo class (trans the json obj into normal java class obj
        User user = new UserUtils().generateRandomUser();
        // Given (request)(prepare the HTTP req)
        Response response  =
                given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type","application/json")
                .body(user)
                        .log().all()
                //When (Type of request + endpoint)(execute the req)
                .when()
                .post("/api/v1/users/register")
                //Then (everything about response)
                .then()
                .log().all()
                 .extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong with the request");
        }
         restAssuredCookies = response.getDetailedCookies().asList();
        accessToken = response.path("access_token");
        userId      = response.path("user._id");
        firstName  = response.path("user.firstName");

    }
}
