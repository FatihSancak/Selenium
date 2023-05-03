package day09_HandleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
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
        // amazon'a git DELL için arama yaptırın.
        // ilk ürünün resmini farklı bir TAB Olarak açtırın
        // Yeni tabda açılan ürünün fiyatını yazdırın



        // Sayfalar arasında gezinmek için aşağıdaki kod kullanılabilir.
        // Ancak bu değer bir kereye özel olarak üretilir
        // driver.switchTo().window("E23F6D4AA82F5719D218F095F285AD07");
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell", Keys.ENTER);
        String ilkSayfaWHandle = driver.getWindowHandle();

        // ikinci tab'a geçtikten sonra adımları tekrarlamak gerekir.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell", Keys.ENTER);
        WebElement ilkUrunResimi = driver.findElement(By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3'] span[class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        ilkUrunResimi.click();

        // ürünün fiyatı
        WebElement urunFiyati = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
        System.out.println("urunFiyati.getText() = " + urunFiyati.getText());

        // ilk sayfaya geçip URL yazdırın
        driver.switchTo().window(ilkSayfaWHandle);
        System.out.println("Önceki sayfanın URL adresi : "+driver.getCurrentUrl());

    }
}
