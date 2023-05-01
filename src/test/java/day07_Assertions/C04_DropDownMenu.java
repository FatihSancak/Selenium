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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazon'a gidip
    dropdown'dan Books seçeneğini seçip
    Java aratın ve
    arama sonuçlarının Java içerdiğini test edelim
     */
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
        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(ddm);

        // options.selectByIndex(5);
        options.selectByVisibleText("Books");
        // options.selectByValue();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        WebElement actualSonuc = driver.findElement(By.xpath("//div/span[@class='a-color-state a-text-bold']"));
        String expectedSonuc = "Java";
        String actualSonucYazisi = actualSonuc.getText();

        // SonucDoğrula (WebSayfasındakiYazı.içerir(AranılanKelime)
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonuc));
    }
}