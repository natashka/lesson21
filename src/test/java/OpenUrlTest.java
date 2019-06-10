import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class OpenUrlTest {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(OpenUrlTest.class);

    @BeforeClass
    public static void setup() {
        Properties log4jProp = new Properties();
        log4jProp.setProperty("log4j.rootLogger", "WARN");
        PropertyConfigurator.configure(log4jProp);


        System.setProperty("webdriver.chrome.logFile", "resources/log4j2-test.xml");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void initWebDriver() {
    driver = new ChromeDriver();

    }

    @Test
    public void test1() {
        driver.get("https://otus.ru/");
//        new Timeout(500);
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
        logger.info("INFO");
        logger.debug("test debug");
        logger.info("INFO");
        logger.error("ERROR Message", new NullPointerException("I AM NULL"));

    }

//    @Test
//    public void debugLevel() {
//        logger.log(Level.DEBUG, "Logger Name :: " + logger.getName() + " :: Passed Message ::");
//    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
