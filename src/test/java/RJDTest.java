
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import pages.PathChooseForm;

import java.io.IOException;
import java.io.InterruptedIOException;

public class RJDTest {

    private static WebDriver driver;

    @BeforeClass
    public static void startDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\DEE\\testRJD\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void Test() {
        driver.get("https://pass.rzd.ru/");
        PathChooseForm pathChooseForm = new PathChooseForm(driver);
        pathChooseForm.departureAndArrivalInput("Москва", "Тула")
                .dateTomorrowChoose();

        }

    @AfterClass
    public static void closeDriver() throws IOException, InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }

}
