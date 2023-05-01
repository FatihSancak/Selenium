package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_Assertions {
    /*
    1.Bir Class oluşturalim YanlisEmaiITesti
    2.http://automationpractice.pl/index.php sayfasina gidelim
    3.Sign in butonuna basalim
    4.Email kutusuna @isareti olmayan bir mail yazip enter'a
    bastigimizda "Invalid email address" uyarisi ciktigini test edelim
    */

    static WebDriver driver;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("http://automationpractice.pl/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hataligmail.com", Keys.ENTER);

         WebElement hataYazisi = driver.findElement(By.xpath("//li[normalize-space()='Invalid email address.']"));
        // WebElement hataYazisi = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));

        Assert.assertTrue(hataYazisi.isDisplayed());

    }
}
