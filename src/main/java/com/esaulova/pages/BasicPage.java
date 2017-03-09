package com.esaulova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasicPage {
    protected final static String PROTOCOL = "https://";

    protected WebDriver driver;

    public BasicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public abstract BasicPage openPage();

    public abstract boolean validateURL();

    public abstract String getUrl();

}
