package day09_HandleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {
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
       driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String strIlkSiteWH = driver.getWindowHandle();

        //    Sayfadaki textin "Opening a new window” olduğunu doğrulayın.
        WebElement text1 = driver.findElement(By.xpath("//h3"));
        String text1Str = text1.getText();
        Assert.assertEquals("Opening a new window", text1Str);

        //    Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String titleStr  = driver.getTitle();
        Assert.assertEquals("The Internet", titleStr );

        //    Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Thread.sleep(5000);

        // SAYFALARIN TÜMÜNÜN WİNDOW HANDLE LARINI set<> ile  ALALIM
        // İLK SAYFANIN İÇİNDE BULUNMADIĞI SAYFA HANDLE'INI
        // İKİNCİ SAYFA HANDLE DEĞERİ OLARAK ATAYALIM .
        Set<String> windowHandleSet = driver.getWindowHandles();
        String ikinciSayfaWH="";
        for (String each:windowHandleSet) {
            if(!each.equals(strIlkSiteWH)){
                ikinciSayfaWH= each;
            }
        }

        //    Acilan yeni pencerenin sayfa başlığının (title) "New Window” oldugunu dogrulayin.

        driver.switchTo().window(ikinciSayfaWH);

        String newPageTitleActual = driver.getTitle();
        String newPageTitleExpected = "New Window";
        Assert.assertEquals(newPageTitleExpected, newPageTitleActual);

        //    Sayfadaki textin "New Window" olduğunu doğrulayın.
        String newPageTxt = driver.findElement(By.xpath("//h3")).getText();
        String newPageTextExpected = "New Window";
        Assert.assertEquals(newPageTextExpected,newPageTxt);

        //    Bir önceki pencereye geri döndükten sonra
        driver.switchTo().window(strIlkSiteWH);

        //    sayfa başlığının "The internet" olduğunu doğrulayın.
        String actualIkinciSayfaTitle = driver.getTitle() ;
        String expectedIkinciSayfaTitle = "The Internet";
        Assert.assertEquals(expectedIkinciSayfaTitle,actualIkinciSayfaTitle);
    }
}
