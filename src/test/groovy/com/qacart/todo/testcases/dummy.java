package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.List;
import java.util.Properties;

import static java.util.Arrays.asList;

public class dummy {
    public static void main(String[] args) throws IOException {
        //get url or password or email from the properties file instead of pasting the link itself each time
        File file = new File("src/test/groovy/com/qacart/todo/configUtils/production.properties");
        InputStream inputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(inputStream);
        String url = prop.getProperty("baseUrl");
        System.out.println(url);
        //selenium cookies
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        List<io.restassured.http.Cookie> restAssuredCookies = registerApi.getRestAssuredCookies();

//        Cookie accessTokenCookie = new Cookie("access_token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5NTkyYzA3MGVmYTc3MDAxNWQzNmVlOSIsImZpcnN0TmFtZSI6ImhlbG8iLCJsYXN0TmFtZSI6InRlc3QiLCJpYXQiOjE3NzA1NTg1ODB9.Vtpald8vfGXQOxrUKQXIPTtPZyMIcpEHsTTc2D6YUyE");
//        driver.manage().addCookie(accessTokenCookie);
        driver.get(url);

    }
}
