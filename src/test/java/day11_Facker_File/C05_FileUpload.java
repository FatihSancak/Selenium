package day11_Facker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void FileUpload() throws InterruptedException {
        //  1. https://the-internet.herokuapp.com/upload adresine gidelim
        //  2. chooseFile butonuna basalim
        //  3. Yuklemek istediginiz dosyayi secelim.
        //  4. Upload butonuna basalim.
        //  5. “File Uploaded!” textinin goruntulendigini test edelim.

        driver.get("https://the-internet.herokuapp.com/upload");
        String anaDizin = System.getProperty("user.home");
        String dosyaYolu = "\\Downloads\\dummy.pdf";
        String yuklenecekDosya = anaDizin + dosyaYolu;

        WebElement dosyaYukleButonu = driver.findElement(By.id("file-upload"));
        dosyaYukleButonu.sendKeys(yuklenecekDosya);

        //Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement actualWE = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualWE.isDisplayed());


    }
}
