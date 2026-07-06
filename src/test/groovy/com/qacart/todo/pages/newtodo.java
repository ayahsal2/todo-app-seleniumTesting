package com.qacart.todo.pages;

import com.qacart.todo.base.BaseForPages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class newtodo extends BaseForPages {

    public newtodo(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "[data-testid=\"new-todo\"]")
    private WebElement addTodo;

    @FindBy (css = "[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmit;

    public newtodo load(){
        driver.get("https://qacart-todo.herokuapp.com/" +
                "todo/new");
        return this;
    }
    @Step
    public todo  addTodoItem(String item){
         addTodo.sendKeys(item);
         newTodoSubmit.click();
         return new todo(driver);
    }
}
