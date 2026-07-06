package com.qacart.todo.pages;

import com.qacart.todo.base.BaseForPages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class todo extends BaseForPages {
    public todo(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welocmePage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css ="[data-testid=\"delete\"]")
    private WebElement deleteItem;

    @FindBy(css ="[data-testid=\"delete\"]")
    private WebElement deleteText;

    @FindBy(css ="[data-testid=\"complete-task\"]")
    private WebElement completeItem;

    public todo load(){
        driver.get("https://qacart-todo.herokuapp.com/"+"todo");
    return this;
    }
    @Step
    public boolean isWelcomeMsgDisplayed(){
        return welocmePage.isDisplayed();
    }
    @Step
    public newtodo clickOnPlusButton(){
        addButton.click();
        return new newtodo(driver);
    }
    public String toDoText(){
       return todoItem.getText();
    }
    @Step
    public void clickOnDeleteButton(){
        deleteItem.click();
    }
    @Step
    public void clickOnCompleteButton(){
        completeItem.click();
    }

}

