import com.esaulova.pages.PathChoosePage;
import com.esaulova.pages.TrainChoosePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;


public class RJDTest {

    private static WebDriver driver;
    private final static Logger logger = Logger.getLogger(RJDTest.class.getName());

    @BeforeClass
    public static void startDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        driver = new ChromeDriver(optionsChrome);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        PathChoosePage pathChoosePage = new PathChoosePage(driver);
        pathChoosePage.openPage();
        assertTrue("This is not expected page", pathChoosePage.validateURL());

        pathChoosePage.departureAndArrivalInput("Москва", "Тула").dateTomorrowChoose();
        TrainChoosePage trainChoosePage = pathChoosePage.buyTicketClick();
        assertTrue("This is not expected page", trainChoosePage.validateURL());
        trainChoosePage.chooseTime()
                .chooseCarType()
                .chooseCar();
        logger.info("Number of free places " + trainChoosePage.getNumberOfFreePlaces());
    }

    @AfterClass
    public static void closeDriver() throws IOException, InterruptedException {
        driver.close();
    }
}
