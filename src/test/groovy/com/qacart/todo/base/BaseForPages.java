package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseForPages {
    protected WebDriver driver;
    public BaseForPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);// initialize elements underneath
    }
}
