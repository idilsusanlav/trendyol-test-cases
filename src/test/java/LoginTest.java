import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @Test
    public void homepageLandingCheck() {
        Assert.assertEquals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da", driver.getTitle());
    }

    @Test
    public void loginErrorCheck() {
        driver.findElement(By.cssSelector(".account-user > .icon-container")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("lr-title")).isDisplayed());
        driver.findElement(By.id("login-email")).sendKeys(USERNAME);
        driver.findElement(By.id("login-password-input")).sendKeys(WRONGPASSWORD);
        driver.findElement(By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.id("error-box-wrapper")).isDisplayed());
    }
}
