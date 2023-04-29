package day03_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class C01_Locaters {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amazon.com'da Arama Yapma.
        driver.get("https://www.amazon.com");
        /*
        <input
        type="text"
        id="twotabsearchtextbox"
        value=""
        name="field-keywords" autocomplete="off" placeholder="Search Amazon"
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */

        //WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));

        /*
        Alttaki locater çalışmadı.
        WebElement aramaKutusu = driver.findElement(By.className("nav-search-field"));
        */
        aramaKutusu.sendKeys("Dell"+ Keys.ENTER);
    }
}
