package day01_SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class C01_ilkClass {
    public static void main(String[] args) throws InterruptedException {
        /*

        En ilkel haliyle otomasyon yapmak için
        Class'ımıza otomasyon için gerekli olan webdriver'ın
        yerini göstermemiz gerekir. Bunun için Java Kütüphanesinden
        System.setProperty() method'unu kullanırız.
        Method iki parametre ister
        İlki kullanacağımız driver : webdriver.chrome.driver
        ikincisi ise bu driver'ın fiziki yolu : src/resources/drivers/chromedriver.exe

        */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        driver.close();

    }
}
