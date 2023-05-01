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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    amazon ana sayfaya gidip
    dropdown menüden books'u seçin
    seçtiğimiz optionı yazdırallım

    dropdowndaki opsiyonların toplam sayısının
    28 olduğunu test edelim
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        WebElement ddMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddMenu);
        select.selectByVisibleText("Books");

        /*
        bir dropdown ile calisiyorken, son secilen option'a ulaşmak isterseniz
        select. getFirstseIected0ption() method'unu kullanmalısiniz
        bu method bize WebElement dondurur,
        uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir
         */
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> optionList = select.getOptions();

        int actualOptionCount = optionList.size();
        int expectedOptionCount = 28;

        // Assert.assertTrue(expectedOptionCount==actualOptionCount);
        Assert.assertEquals(expectedOptionCount,actualOptionCount);
    }
}
