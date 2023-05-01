package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https//www.bestbuy.com/ adresine gidin farkli test method'lari oluşturarak asagidaki
    testleri yapin
        Sayfa URL'inin https://www.bestbuy.com/'a eşit oldugunu test edin
        titleTest -> Sayfa başlığının "Rest" içermediğini(contains) test edin
        logoTest -> BestBuy logosunun görüntülendigini test edin
        FrancaisLinkTest -> Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        String expectedUrl = "https://www.bestbuy.com/";
        //driver.findElement(By.xpath("//a[@class='us-link']")).click();
        String actualUrl = driver.getCurrentUrl();
        //Assert.assertTrue(actualUrl.contains(arananUrl));
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test02() {
        String istenmeyenKelime = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void test03(){
//        WebElement logo = driver.findElement(By.xpath("//a[@data-lid='hdr_lgo']"));
        WebElement logo = driver.findElement(By.className("logo"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test04(){
        WebElement langFr = driver.findElement(By.xpath("//li/button[@lang='fr']"));
        // diğer bir xPath ->  //*[text()='Français']
        Assert.assertTrue(langFr.isDisplayed());
    }
}
