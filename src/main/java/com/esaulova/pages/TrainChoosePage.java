package com.esaulova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainChoosePage extends BasicPage{

    private String url = "pass.rzd.ru/tickets/public/ru";

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
        return driver.getCurrentUrl().contains(this.getUrl());
    }

    @Override
    public String getUrl() {
        return url;
    }

    public TrainChoosePage chooseCarType() {
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitWhenElementToBeClickable(carTypeButton);
        carTypeButton.click();
        return this;
    }

    public TrainChoosePage chooseTime(){
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitWhenElementToBeClickable(startTimeButton);
        startTimeButton.click();
        move(startTimeButton, Keys.ARROW_UP, 4);
        waitUtils.waitWhenElementToBeClickable(endTimeButton);
        endTimeButton.click();
        move(endTimeButton, Keys.ARROW_DOWN, 6);
        return this;
    }

    public TrainChoosePage chooseCar() {
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitWhenElementToBeClickable(carRadioButton);
        carRadioButton.click();
        return this;
    }

    public int getNumberOfFreePlaces() {
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitWhenElementVisible(schemeCars);
        return driver.findElements(freePlaces).size();

    }
    private WebElement move(WebElement element, Keys key, int n) {
        for (int i = 0; i < n; i++) {
            element.sendKeys(key);
        }
        return element;
    }

}
