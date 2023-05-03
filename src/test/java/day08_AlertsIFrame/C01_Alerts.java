package day08_AlertsIFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts  {
    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Click for Js Alert butonuna tıklayın
    Tıkladıktan sonra çıkan uyarı mesajında (alert) tamamı tıkla.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        // dissmiss
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        // accept
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Deneme");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    @Test
    public void test4() throws InterruptedException{
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Deneme");
        driver.switchTo().alert().dismiss();
    }
}
