package com.qacart.todo.api;

import com.qacart.todo.models.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
public void addTask(String getToken){
Task task = new Task("Learn Selenium ",false);
Response resp = given()
        .baseUri("https://qacart-todo.herokuapp.com/")
        .header("Content-Type","application/json")
        .body(task)
        .auth().oauth2(getToken)
.when()
        .post("/api/v1/tasks")
.then()
        .log().all().extract().response();
if (resp.statusCode() != 201){
    throw new RuntimeException("Something Went Wrong in Adding a Todo");
}
}
}