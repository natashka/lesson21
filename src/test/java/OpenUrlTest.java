import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Properties;

public class OpenUrlTest {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(OpenUrlTest.class);

    @BeforeClass
    public static void setup() {
        Properties log4jProp = new Properties();
        log4jProp.setProperty("log4j.rootLogger", "WARN");
        PropertyConfigurator.configure(log4jProp);


        //System.setProperty("webdriver.chrome.logFile", "resources/log4j2-test.xml");
        System.setProperty("log4j.configurationFile","log4j2-testConfig.xml");
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void initWebDriver() {
        //driver = new RemoteWebDriver("http://127.0.0.1:9515", DesiredCapabilities.chrome());
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--whitelist-ip *");
//        chromeOptions.addArguments("--proxy-server='direct://'");
//        chromeOptions.addArguments("--proxy-bypass-list=*");
        driver = new ChromeDriver();
    }

    @Test
    public void demo() {
        driver.get("https://otus.ru/");
        new Timeout(500);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
