package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 08.03.2017.
 */
public class TrainChooseForm {

    private WebDriver driver;

    public TrainChooseForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
