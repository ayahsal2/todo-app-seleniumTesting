package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.Factory;
import com.qacart.todo.pages.login;
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
@Feature("Auth Feature")
public class loginTest extends BaseTest {
    @Story("Login")
    @Description("This test will login by filling the email and password")
    @Test(description = "Test the login functionality using email and password")
    public void ShouldBeAbleToLoginInWithPasswordAndEmail(){
        login logpage = new login(driver);
        todo todoactions = logpage.load().loginAction("2237971@std.hu.edu.jo","Ayatesting123");
        Assert.assertTrue(todoactions.isWelcomeMsgDisplayed());
    }
 }
