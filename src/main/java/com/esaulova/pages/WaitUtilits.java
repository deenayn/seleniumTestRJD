package com.esaulova.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilits {

    WebDriver driver;
    WebDriverWait wait;

    public WaitUtilits(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WaitUtilits(WebDriver driver, int time) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, time);
    }

    public void waitWhenAllElementInvisible(By byElement) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(byElement)));
    }

    public void waitWhenElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitWhenElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
