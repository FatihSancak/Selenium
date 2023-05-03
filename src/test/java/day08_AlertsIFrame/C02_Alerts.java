package day08_AlertsIFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin.

    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        String strExpected = "You successfully clicked an alert";
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        String strActual =driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("Test 1 Bilgisi "+strActual+ " / " + strExpected );
        Assert.assertEquals(strExpected,strActual);
    }
    @Test
    public void test2(){
        // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // “successfuly” icermedigini test edin.

        String strExpected = "successfuly";
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String strActual = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("Test 2 Bilgisi "+strActual+ " / " + strExpected );
        Assert.assertFalse(strActual.contains(strExpected));
    }

    @Test
    public void test3(){
        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        // tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        String strExpected = "Kartal";
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Kartal");
        driver.switchTo().alert().accept();
        String strActual = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("Test 3 Bilgisi "+strActual+ " / " + strExpected );
        Assert.assertTrue(strActual.contains(strExpected));
    }
}
