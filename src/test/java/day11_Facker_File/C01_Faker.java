package day11_Facker_File;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // Facebook Kullanıcı Giriş Bilgilerini Fake Bilgilerle Doldurulması
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com/");

        // yeni kayit oluştur butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        // isim kutuSunu Locate edip,
        WebElement txBoxtName = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions action = new Actions(driver);

        Faker faker = new Faker();

        String fakeMail = faker.internet().emailAddress();
        action
                .click(txBoxtName)
                .sendKeys(faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(),Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber(), Keys.TAB)
                .sendKeys(fakeMail, Keys.TAB)
                .sendKeys(faker.internet().password(), Keys.TAB)
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
