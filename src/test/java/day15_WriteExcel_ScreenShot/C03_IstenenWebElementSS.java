package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        // amazona gidin nutella aratın
        // ve sonuc sayısının olduğu web elementinin fotoğrafını çekin
        String tarih = getTarih();

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        WebElement sonuYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        File sonucYaziElementSS = new File("target/ekranGoruntuleri/" + tarih + "sonucYazisi.jpg");
        File temp = sonuYaziElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYaziElementSS);



    }
}
