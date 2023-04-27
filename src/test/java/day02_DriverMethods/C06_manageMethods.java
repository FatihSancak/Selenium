package day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Position;

public class C06_manageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        System.out.println("Pencere Ölçüleri :" + driver.manage().window().getSize());
        System.out.println("Pencere Pozisyonu :" + driver.manage().window().getPosition());

        Thread.sleep(2000);

        // Pencerenin konumunu ve büyüklüğünü değiştirme
        driver.manage().window().setPosition(new Point(15, 15));
        driver.manage().window().setSize(new Dimension(900, 600));
        System.out.println("Yeni Pencere Ölçüleri :" + driver.manage().window().getSize());
        System.out.println("Yeni Pencere Pozisyonu :" + driver.manage().window().getPosition());

        driver.close();

    }
}
