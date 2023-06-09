package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");

        // url'nin facebook olduğunu test edin

        /*
        if(driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("URL testi PASSED");
        }else {
            System.out.println("URL Testi FAILED");
        }
        */
        String expectedUrl = "https://www.facebook.com";
        String actualUrl = "https://www.amazon.com";

        Assert.assertEquals("Test Sonucu Hatalı ",expectedUrl,actualUrl);
    }
}
