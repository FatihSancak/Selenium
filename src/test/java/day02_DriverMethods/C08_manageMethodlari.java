package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class C08_manageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // max pencere bilgileri.
        System.out.println("Max Konum :"+driver.manage().window().getPosition());
        System.out.println("Max boyut :"+driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().fullscreen();

        // fullscreen pencere bilgileri.
        System.out.println("FullScreen Konum :"+driver.manage().window().getPosition());
        System.out.println("FullScreen boyut :"+driver.manage().window().getSize());

        driver.close();
    }
}
