package Odevler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_1 {
    /*
    Amazon sayfasina gidelim. https://www.amazon.com/
    Sayfa basligini(title) yazdirin
    Sayfa basliginin “Amazon” icerdigini test edin
    Sayfa adresini(url) yazdirin
    Sayfa url’inin “amazon” icerdigini test edin.
    Sayfa handle degerini yazdirin
    Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
    Sayfayi kapatin
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        // Sayfa basligini(title) yazdirin
        String siteBasligi = driver.getTitle();
        System.out.println("siteBasligi = " + siteBasligi);

        // Sayfa basliginin “Amazon” icerdigini test edin
        if(siteBasligi.contains("Amazon")){
            System.out.println("Site Başlığı Amazon kelimesini içerir. PASSED");
        }
        else {
            System.out.println("Site Başlığı Amazon kelimesini içermez. FAILED");
        }

        // Sayfa adresini(url) yazdirin
        String siteUrl = driver.getCurrentUrl();

        // Sayfa url’inin “amazon” icerdigini test edin.
        if(siteUrl.contains("amazon")){
            System.out.println("Site URL'i amazon kelimesini içerir. PASSED");
        }
        else {
            System.out.println("Site URL'i amazon kelimesini içermez. FAILED");

        }

        // Sayfa handle degerini yazdirin
        String siteHandle = driver.getWindowHandle();
        System.out.println("Site Handle = " + siteHandle);

        // Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        if(driver.getPageSource().contains("Gateway")){
            System.out.println("Site Kaynak Kodlarında GATEWAY kelimesi geçiyor. PASSED");
        }
        else {
            System.out.println("Site Kaynak Kodlarında GATEWAY kelimesi yoktur. FAILED");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Sayfayi kapatin
        driver.close();
    }
}
