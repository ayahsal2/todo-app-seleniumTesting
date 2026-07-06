package com.qacart.todo.pages;
import com.qacart.todo.base.BaseForPages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class login extends BaseForPages {

    public login(WebDriver driver) {
        super(driver);
    }
    @Step
    public login load(){
        driver.get("https://qacart-todo.herokuapp.com/");
    return this;
    }
@FindBy(css = "[data-testid=\"email\"]")
   private WebElement emailInput;

@FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

@FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;

    @Step
public todo loginAction(String email, String password){
 emailInput.sendKeys(email);
 passwordInput.sendKeys(password);
 submit.click();
 return new todo(driver);
}
}
