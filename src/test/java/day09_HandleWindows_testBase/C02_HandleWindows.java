package day09_HandleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
    public void test01() {
    //  1- amazon anasagfaya gidelim
        driver.get("https://www.amazon.com");

    //  2- URL'nin amazon icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));
        String amazonWH = driver.getWindowHandle();

    //  3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWH = driver.getWindowHandle();

    //  4- title'in BestBuy icerdigini test edelim
        String bestBuyTitle = driver.getTitle();
        String arananKelime = "Best Buy";
        Assert.assertTrue(bestBuyTitle.contains(arananKelime));

    //    5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(amazonWH);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

    //    6- arama sonuclarinin Java icerdigini test edelim
        WebElement amazonSearch = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String amazonSearchStr = amazonSearch.getText();
        String arananKelime2 = "Java";
        Assert.assertTrue(amazonSearchStr.contains(arananKelime2));

    //    7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(bestBuyWH);

    //    8- logonun gorundugunu test edelim
        WebElement bestBayLogo = driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(bestBayLogo.isDisplayed());
    }
}
