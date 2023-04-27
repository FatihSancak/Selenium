package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class C06_navigate {
    public static void main(String[] args) throws InterruptedException {
        /*

         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);


        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        // Amazona geri dön
        driver.navigate().back();
        Thread.sleep(2000);

        // yeniden google'a git
        driver.navigate().forward();
        Thread.sleep(2000);

        // sayfayı refresh et
        driver.navigate().refresh();
        Thread.sleep(1000);

        driver.close();
    }
}
