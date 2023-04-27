package Odevler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev_2 {
    public static void main(String[] args) {
    /*
        Youtube ana sayfasina gidelim . https://www.youtube.com/
        Amazon soyfasina gidelim. https://www.amazon.com/
        Tekrar YouTube’sayfasina donelim
        Yeniden Amazon sayfasina gidelim
        Sayfayi Refresh(yenile) yapalim
        Sayfayi kapatalim / Tum sayfalari kapatali
     */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com");

        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

        // Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

        // Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        // Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        // Sayfayi kapatalim / Tum sayfalari kapatali
        driver.close();
        driver.quit();
    }
}
