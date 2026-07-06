package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.Factory;
import com.qacart.todo.pages.login;
import com.qacart.todo.pages.newtodo;
import com.qacart.todo.pages.todo;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {

@Story("Add Todo")
@Description("This test will add a task in the list")
@Test
    public void ShouldBeAbleToCreateTodo(){
    RegisterApi registerApi = new RegisterApi();
    registerApi.register();
    newtodo newtodopage = new newtodo(driver);
    newtodopage.load();
injectCookiesToBrowser(registerApi.getRestAssuredCookies());
    driver.navigate().refresh();
    String actualres = newtodopage.load().addTodoItem("learn new things").toDoText();
Assert.assertEquals(actualres,"learn new things");
    }

    @Story("Delete Todo")
    @Description("This test will delete a task after its added")
    @Test
    public  void ShouldBeAbleToDeleteTodo(){

    RegisterApi registerApi = new RegisterApi();
    registerApi.register();
    TasksApi tasksApi = new TasksApi();
    tasksApi.addTask(registerApi.getAccessToken());
        todo todopage = new todo(driver);
        todopage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        driver.navigate().refresh();
                todopage.clickOnDeleteButton();

    }

    @Story("Complete Todo")
    @Description("This test will complete a task added in the list")
    @Test
    public  void ShouldBeAbleToCompleteTodo(){
    RegisterApi registerApi = new RegisterApi();
    registerApi.register();

    TasksApi tasksApi = new TasksApi();
    tasksApi.addTask(registerApi.getAccessToken());

        todo todopage = new todo(driver);
        todopage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        driver.navigate().refresh();
                todopage.clickOnCompleteButton();
}
}
