package Odevler;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev_4 {
    public static void main(String[] args) {
        /*
         Amazon soyfasina gidelim. https://www.amazon.com/
         Sayfanin konumunu ve boyutlarini yazdirin
         Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
         Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
         Sayfayi kapatin
         */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        // Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Konum : " + driver.manage().window().getPosition());
        System.out.println("Boyut : " + driver.manage().window().getSize());

        // Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(10,10));

        // Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("Yeni Konum : " + driver.manage().window().getPosition());
        System.out.println("Yeni Boyut : " + driver.manage().window().getSize());

        // Sayfayi kapatin
        driver.close();
    }
}
