package Odevler;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev_5 {
    public static void main(String[] args) {
        /*
        ChromeDriver kullanarak, facebook sayfasina gidin ve
        sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        degilse dogru basligi yazdirin.
        Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        icermiyorsa “actual” URL’i yazdirin.
        https://www.walmart.com/ sayfasina gidin.
        Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        Tekrar “facebook” sayfasina donun
        Sayfayi yenileyin
        Sayfayi tam sayfa (maximize) yapin
        Browser’i kapatin
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver dvr = new ChromeDriver();

        // ChromeDriver kullanarak, facebook sayfasina gidin
        dvr.get("https://www.facebook.com");

        // sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.
        String siteBaslik = dvr.getTitle();
        if(siteBaslik.contains("facebbok")){
            System.out.println("Test: PASSED. Site başlığı 'facebook' içerir.");
        }else{
            System.out.println("Test: FAILED. Sitenin Basliği : " + siteBaslik);
        }

        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.
        String siteURL = dvr.getCurrentUrl();
        if(siteURL.contains("facebook")){
            System.out.println("Test : PASSED. Site URL istenileni karşıladı");
        }else {
            System.out.println("Test : FAILED. Actual URL = " + siteURL);
        }
        // https://www.walmart.com/ sayfasina gidin.
        dvr.navigate().to("https://www.walmart.com");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        siteBaslik = dvr.getTitle();
        if(siteBaslik.contains("Walmart.com")){
            System.out.println("Test: PASSED. Site başlığında Walmart.com yazar.");
        }else{
            System.out.println("Test: FAILED. Site başlığında Walmart.com yok.");
        }
        // Tekrar “facebook” sayfasina donun
        dvr.navigate().back();

        // Sayfayi yenileyin
        dvr.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin
        dvr.manage().window().maximize();

        // Browser’i kapat
        dvr.close();

    }
}
