package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PathChooseForm {

    private WebDriver driver;

    /** Поле Откуда*/
    @FindBy(id="name0")
    private WebElement departure;

    /** Поле Куда*/
    @FindBy(id="name1")
    private WebElement arrival;

    /** Кнопка Купить билет*/
    @FindBy(id="Submit")
    private WebElement submite;

    /** Кнопка открытия календаря*/
    @FindBy(xpath = "//tr[td/label[text()='Туда']]//div[@class='box-form__datetime__calendar sh_calendar']")
    private WebElement openCalendar;

    /** Выбор второй доступной даты*/
    @FindBy(xpath = "//*[@class='select-time days45 near-time'][1]")
    private WebElement date;

    public PathChooseForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PathChooseForm departureInput(String text) {
        departure.sendKeys(text);
        return this;
    }

    public PathChooseForm arrivalInput(String text) {
        arrival.sendKeys(text);
        return this;
    }

    public PathChooseForm departureAndArrivalInput(String depText, String arrText) {
        departureInput(depText).arrivalInput(arrText);
        return this;
    }

    public PathChooseForm buyTicketClick() {
        submite.click();
        return this;
        //TODO дописать ожидание виден ли, подумать над тем, что должен возвращать
    }

    public PathChooseForm openCalendar() {
        openCalendar.click();
        return this;
    }

    public PathChooseForm dateClickCalendar() {
        date.click();
        return this;
    }

    public PathChooseForm dateTomorrowChoose() {
        openCalendar().dateClickCalendar();
        return this;
    }
 }
