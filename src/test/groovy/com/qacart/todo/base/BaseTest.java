package com.qacart.todo.base;

import com.qacart.todo.factory.Factory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.qacart.todo.utils.CookieUtils.convertRACookiesToSeleniumCookies;
@Listeners({AllureTestNg.class})
public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = new Factory().initializeDriver();
    }

    @AfterMethod
    public void teardown(ITestResult result)  {
        String testCaseName = result.getMethod().getMethodName();
        File destfIle = new File("target"+File.separator+"screenshots"+File.separator+testCaseName+".png");
        takesScreenshot(destfIle);
        driver.quit();
    }

    public void takesScreenshot(File destFile){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destFile);
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
     List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRACookiesToSeleniumCookies(restAssuredCookies);
    for (org.openqa.selenium.Cookie cookie : seleniumCookies){
        driver.manage().addCookie(cookie);
    }
    }
}
