package day11_Facker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // 1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 2- video’yu gorecek kadar asagi inin
        Actions action = new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        // 3- videoyu izlemek icin Play tusuna basin
        WebElement iframeWE = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframeWE);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // 4 - videoyu calistirdiginizi test edin
        WebElement weYoutube = driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
        //Thread.sleep(1000);

        Assert.assertTrue(weYoutube.isDisplayed());


    }
}
