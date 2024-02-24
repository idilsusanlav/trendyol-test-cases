import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    static int DEFAULT_WAIT = 30;
    static String USERNAME = "";
    static String PASSWORD = "";

    WebDriver driver;

    @BeforeMethod
    public void startEnvironment() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().timeouts();
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("modal-close")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
