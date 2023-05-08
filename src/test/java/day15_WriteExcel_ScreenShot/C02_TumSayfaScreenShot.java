package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v85.indexeddb.model.DataEntry;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
// amazon sayfasına gidip tüm ekranın resimini alma.
        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarih = date.format(dtf);


        File tumSayfaResim = new File("target/ekranGoruntuleri/"+ tarih +"tumSayfa.jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya, tumSayfaResim);
    }
}
