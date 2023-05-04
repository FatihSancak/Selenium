package day11_Facker_File;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class C04_FileDownload extends TestBase {
    @Test
    public void testDownload() throws InterruptedException {
        // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. dummy.dpf dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='dummy.pdf']")).click();
        Thread.sleep(5*1000);

        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String indirilenDosyaYolu = System.getProperty("user.home")+"\\Downloads\\dummy.pdf";

        //Assert.assertTrue(Files.exists(Path.of(indirilenDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(indirilenDosyaYolu)));
    }
}
