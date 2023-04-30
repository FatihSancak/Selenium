package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_8_Maven2 {
    public static void main(String[] args) {
/*
https://www.google.com/ adresine gidin
cookies uyarisini kabul ederek kapatin
Sayfa basliginin “Google” ifadesi icerdigini test edin
Arama cubuguna “Nutella” yazip aratin
Bulunan sonuc sayisini yazdirin
sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
Sayfayi kapatin
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        // cookies uyarisini kabul ederek kapatin
        // Sayfa basliginin “Google” ifadesi icerdigini test edin
        String googleTitle = driver.getTitle();
        if (googleTitle.equals("Google")) {
            System.out.println("PASSED - > Sayfa Başlığı : Google");
        } else {
            System.out.println("FAILED - > Sayfa Başlığı \"Google\" değildir.");
        }

        // Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
        // Bulunan sonuc sayisini yazdirin
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println(searchResult);
        System.out.println("searchResult = " + searchResult);

        // sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        searchResult = searchResult.replaceAll("[^\\d\\s]", "");
        searchResult = searchResult.substring(0, searchResult.length()-8).replace("son 8 karakter","");
        searchResult = searchResult.replace(" ","");

        int searchCount = Integer.parseInt(searchResult);

        System.out.println("searchCount = " + searchCount);

        if (searchCount < 10000000) {
            System.out.println("Bulunan sonuç 10 milyonun altındadır");
        } else {
            System.out.println("Bulunan sonuç 10 milyonun üstündedir.");
        }
        // Sayfayi kapatin
        driver.close();
    }
}
