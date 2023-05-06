package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici() {
        // C2_tables class'ındaki adrese gidip
        // girisYap method'unu kullanarak sayfaya giriş yapın
        // input olarak verilen satır sayısı ve sütun sayısına sahip
        // cell'deki text'i yadirin.

        int satir = 3;
        int sutun = 3;

        girisYap();

        // Aşağıdaki web sitesinin verileri getirmesindeki hızın yavaş olmasından dolayı
        // locater hatası verdiğinden kullanılmamış onun yerine beklemeli locate kullanılmıştır.
        // WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[\"+ satir +\"]//td[\"+ sutun +\"]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement arananCell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//tr["+ satir +"]//td["+ sutun +"]")));
        System.out.println("Aranan Kayıt "+arananCell.getText());

    }
    public  void girisYap() {
        driver.get("https://www.hotelmycamp.com/");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!", Keys.ENTER);
    }
}
