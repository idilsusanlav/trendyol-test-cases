import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FavoriteTest extends BaseTest {

    @BeforeMethod
    public void login() {
        driver.findElement(By.cssSelector(".account-user > .icon-container")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("lr-title")).isDisplayed());
        driver.findElement(By.id("login-email")).sendKeys(USERNAME);
        driver.findElement(By.id("login-password-input")).sendKeys(PASSWORD);
        //driver.findElement(By.xpath(("//*[@id=\"login-register\"]/div[3]/div[2]/form/button/span[contains(text(),'Giriş Yap')]"))).click();
        driver.findElement(By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.cssSelector("#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user > p")).isDisplayed());
    }

    /*
    @Test
    public void addItem() {
        driver.findElement(By.cssSelector("#browsing-gw-homepage > div > div > div > article:nth-child(1) > div > div > div.styles-module_slider__o0fqa > a:nth-child(9)")).click();
        driver.findElement(By.cssSelector("#seller-store-header > div > div > div:nth-child(2) > div > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("s-cntnr-V2 > div:nth-child(4) > div:nth-child(1) > div > div:nth-child(3) > div.fvrt-btn-wrppr > i")).click();
        driver.findElement(By.cssSelector("#account-navigation-container > div > a > div > p")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#account-gw-favorites > div > div:nth-child(3) > div > div > div.prdct-campaign-wrapper > a > div.prdct-desc-cntnr-wrppr > div.prdct-desc-cntnr")).isDisplayed());

    }

    @Test
    public void removeItem() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".account-favorites")))
                .click();
        driver.findElement(By.cssSelector("#account-gw-favorites > div > div:nth-child(3) > div > div > div.ufvrt-btn-wrppr")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#account-gw-favorites > div > div.empty-favorites > p.empty-favorites-header")).isDisplayed());

    }
    */

    @Test
    public void favorites() {
        driver.findElement(By.cssSelector("div.banner-listing-items>a:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.fvrt-btn-wrppr")).click();
        driver.findElement(By.cssSelector(":nth-child(2)>div.link")).click();
        driver.findElement(By.cssSelector("div.ufvrt-btn-wrppr")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.empty-favorites")).isDisplayed());
    }

    @Test
    public void emptyFavorites() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account-favorites>.link")));
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".account-favorites>.link")))
                .click();
        Assert.assertTrue(driver.findElement(By.cssSelector("p.empty-favorites-text")).isDisplayed());
    }
}
