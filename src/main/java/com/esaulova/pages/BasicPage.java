package com.esaulova.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasicPage {

    protected WebDriver driver;
    protected String URL;
    protected String protocol = "https://";

    public BasicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public abstract BasicPage openPage();

    public abstract boolean validateURL();

    public String getURL() {
        return URL;
    }

}
