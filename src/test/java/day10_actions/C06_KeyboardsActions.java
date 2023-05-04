package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardsActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com/");

        // yeni kayit oluştur butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        // isim kutuSunu Locate edip,
        WebElement txBoxtName = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions action = new Actions(driver);
        action
                .click(txBoxtName)
                .sendKeys("Deneme", Keys.TAB)
                .sendKeys("Soyadı",Keys.TAB)
                .sendKeys("0555 555 555 5", Keys.TAB)
                .sendKeys("P@ssword", Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15",Keys.TAB)
                .sendKeys("Mar",Keys.TAB)
                .sendKeys("1977",Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        // geriye kalan alanlari TAB ile dolaşarak
        // formu doldunun
        WebElement btnKaydet =  driver.findElement(By.xpath("(//*[text()='Kaydol'])[3]"));
        btnKaydet.click();
        Thread.sleep(3000);
    }
}
