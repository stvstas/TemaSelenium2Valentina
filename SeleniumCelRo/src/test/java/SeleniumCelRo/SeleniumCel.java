package SeleniumCelRo;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by vstancu on 11/2/2016.
 */
public class SeleniumCel {

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vstancu\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.cel.ro ");
    }

    @After
    public void after() {
        //driver.close();
    }

    @Test
    public void test() {
        TakesScreenshot ts = (TakesScreenshot) driver;
            File screen = ts.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screen, new File("SeleniumCel.png"));

            } catch (IOException e) {
                e.printStackTrace();

        }


    }
}
