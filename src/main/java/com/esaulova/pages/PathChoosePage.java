package com.esaulova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PathChoosePage extends BasicPage {

    private String url = "pass.rzd.ru/";

    /** All Dropdown Lists */
    By dropList = By.className("dropList");

    /** Field 'Откуда' */
    @FindBy(id = "name0")
    private WebElement departure;

    /** Field 'Куда' */
    @FindBy(id = "name1")
    private WebElement arrival;

    /** Button 'Купить билет' */
    @FindBy(id = "Submit")
    private WebElement submitButton;

    /** Button to open calendar */
    @FindBy(xpath = "//tr[td/label[text()='Туда']]//div[@class='box-form__datetime__calendar sh_calendar']")
    private WebElement openCalendarButton;

    /** button to choose tomorrow date */
    @FindBy(xpath = "//*[@class='select-time days45 near-time'][1]")
    private WebElement dateButton;

    public PathChoosePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PathChoosePage openPage() {
        driver.get(PROTOCOL + url);
        return this;
    }

    @Override
    public boolean validateURL() {
        return driver.getCurrentUrl().contains(url);
    }

    @Override
    public String getUrl() {
        return url;
    }

    public PathChoosePage departureInput(String text) {
        departure.sendKeys(text);
        return this;
    }

    public PathChoosePage arrivalInput(String text) {
        arrival.sendKeys(text);
        return this;
    }

    public PathChoosePage departureAndArrivalInput(String depText, String arrText) {
        departureInput(depText).arrivalInput(arrText);
        return this;
    }

    public TrainChoosePage buyTicketClick() {
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitWhenElementToBeClickable(submitButton);
        submitButton.click();
        return new TrainChoosePage(driver);
    }

    public PathChoosePage openCalendar() {
        openCalendarButton.click();
        return this;
    }

    public PathChoosePage dateClickCalendar() {
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitWhenAllElementInvisible(dropList);
        dateButton.click();
        return this;
    }

    public PathChoosePage dateTomorrowChoose() {
        openCalendar().dateClickCalendar();
        return this;
    }

}
