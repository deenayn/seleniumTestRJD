package com.esaulova.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

/**
 * Created by user on 08.03.2017.
 */
public class TrainChoosePage extends BasicPage{

    private String URL = "pass.rzd.ru/tickets/public/ru";

    /** Free places in a car */
    private By freePlaces = By.xpath("//div[@class='j-scheme']//*[contains(@class, 's-clickable')]");

    /** Button "Купе" */
    @FindBy(xpath = "//div[contains(text(), '717В')]/ancestor::div[@class='route-item']//div[div[@title='Купе']]/following-sibling::div//button")
    private WebElement carTypeButton;

    /** Button to choose start time */
    @FindBy(xpath = "//form[@name='filter']//div[@data-type='TimeIntervalA']//span[contains(@class, 'ui-slider-handle')][1]")
    private WebElement startTimeButton;

    /** Button to choose end time */
    @FindBy(xpath = "//form[@name='filter']//div[@data-type='TimeIntervalA']//span[contains(@class, 'ui-slider-handle')][2]")
    private WebElement endTimeButton;

    /** Radio button car */
    @FindBy(xpath = "(//div[@class='j-cars-box'][contains(@style, 'display: block')]//input)[1]")
    private WebElement carRadioButton;

    @FindBy(xpath = "//div[@class='j-scheme'][*[@class='s-scheme']]")
    private WebElement schemeCars;

    public TrainChoosePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TrainChoosePage openPage() {
        return this;
    }

    @Override
    public boolean validateURL() {
        return driver.getCurrentUrl().contains(this.getURL());
    }

    public TrainChoosePage chooseCarType() {
        WaitUtilits waitUtilits = new WaitUtilits(driver);
        waitUtilits.waitWhenElementToBeClickable(carTypeButton);
        carTypeButton.click();
        return this;
    }
    public TrainChoosePage chooseTime(){
        WaitUtilits waitUtilits = new WaitUtilits(driver);
        waitUtilits.waitWhenElementToBeClickable(startTimeButton);
        startTimeButton.click();
        move(startTimeButton, Keys.ARROW_UP, 4);
        waitUtilits.waitWhenElementToBeClickable(endTimeButton);
        endTimeButton.click();
        move(endTimeButton, Keys.ARROW_DOWN, 6);
        return this;
    }

    public TrainChoosePage chooseCar() {
        WaitUtilits waitUtilits = new WaitUtilits(driver);
        waitUtilits.waitWhenElementToBeClickable(carRadioButton);
        carRadioButton.click();
        return this;
    }

    public int numberOfFreePlaces() {
        WaitUtilits waitUtilits = new WaitUtilits(driver);
        waitUtilits.waitWhenElementVisible(schemeCars);
        return driver.findElements(freePlaces).size();

    }
    private WebElement move(WebElement element, Keys key, int n) {
        for (int i = 0; i<n; i++) {
            element.sendKeys(key);
        }
        return element;
    }

    public String getURL() {
        return URL;
    }
}
