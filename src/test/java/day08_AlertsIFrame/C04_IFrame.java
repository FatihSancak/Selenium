package day08_AlertsIFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_IFrame {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        // https://html.com/tags/iframe/ adresine gidip
        // youtube videosunu çalıştırınız.

        driver.get("https://html.com/tags/iframe/");

        // I. Yontem:
        // *************************************
         // xpath src olarak gömülü olan URL locate edildi. Ancak ileride bu adresin değişmesi durumunda bu test hata verecektir.
         WebElement youTubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
         driver.switchTo().frame(youTubeFrame);
         //youTubeFrame.click();
         driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        // II. Yontem
        // *************************************
        // Bu yöntemde yukarıdakiden farklı olarak iframe'ler bir listeye yüklenmiş
        // ve istenilen frame URL adresi ne olursa olsun erişimi sağlanmış olacaktır
        // Bu şekilde dinamik bir yapıya sahip olunur.
        List<WebElement> iframeList = driver.findElements(By.xpath("//iframe"));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


    }
}
