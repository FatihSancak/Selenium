package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.zip.CheckedInputStream;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin 3 farkli  test method'u oluşturarak asagidaki gorevleri yapin
    1- URL'in amazon icermedigini test edin
    2- title 'in facebook icermedigini test edin
    3- sol üstte köşede amazon logosunun göründüğünü test edin.
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){

        String aranaKelime = "amazon";
        String webUrl = driver.getCurrentUrl();
        Assert.assertTrue(webUrl.contains(aranaKelime));
    }
    @Test
    public  void test02(){
        String arananTitle = "facebook";
        String webTitle = driver.getTitle();
        Assert.assertFalse(webTitle.contains(arananTitle));
    }
    @Test
    public void test03(){
        WebElement arananLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(arananLogo.isDisplayed());
    }
}
