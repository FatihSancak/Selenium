package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class Odev_9_Assertions {
    /*
    1) https://www.youtube.com adresine gidin
    2) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        ○ titleTest=> Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test2(){
        WebElement ytLogo = driver.findElement(By.xpath("//*[@id='logo-icon']"));
        Assert.assertTrue(ytLogo.isDisplayed());
    }

    @Test
    public void test3(){
        WebElement ytSearcBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(ytSearcBox.isEnabled());
    }
    @Test
    public void test4(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

}
