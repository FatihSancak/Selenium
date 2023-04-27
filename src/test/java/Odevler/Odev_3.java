package Odevler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev_3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Amazon soyfasina gidelim. https://www.amazon.com/
        Sayfanin konumunu ve boyutlarini yazdirin
        Sayfayi simge durumuna getirin
        simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        Sayfayi fullscreen yapin
        Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        Sayfayi kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Amazon soyfasina gidelim.
        driver.navigate().to("https://www.amazon.com/");

        // Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Konum : " + driver.manage().window().getPosition());
        System.out.println("Boyut : " + driver.manage().window().getSize());

        // Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        // simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(5000);
        driver.manage().window().maximize();

        // Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("MAX Konum : " + driver.manage().window().getPosition());
        System.out.println("MAX Boyut : " + driver.manage().window().getSize());

        // Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        // Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("FScr Konum : " + driver.manage().window().getPosition());
        System.out.println("FScr Boyut : " + driver.manage().window().getSize());

        // Sayfayi kapatin
        driver.close();

    }
}
