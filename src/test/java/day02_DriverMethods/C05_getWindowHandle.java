package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_getWindowHandle {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle());
        // Benzersiz olarak açılan window'a ait hashcode'unu verir.
        // 8321057E9E620D09EEDE4706CDA7CEF3
        // F5C7620A4A2CABCFB4B91EA884FC3CF9

    }
}
