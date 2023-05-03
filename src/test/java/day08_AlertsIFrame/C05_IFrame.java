package day08_AlertsIFrame;

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

public class C05_IFrame {
    //  https://the-internet.herokuapp.com/iframe adresine gidin.
    //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //  Text Box’a “Merhaba Dunya!” yazin.
    //  TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //  dogrulayin ve konsolda yazdirin.

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
        //driver.close();
    }

    @Test
    public void test1() {
        //  https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iFrameYazisi = driver.findElement(By.xpath("//h3")); // ilgili yazı locate edildi.
        Assert.assertTrue(iFrameYazisi.isDisplayed()); // görünebilir /olduğunu test
        System.out.println(iFrameYazisi.getText()); // Console'a yazdırıldı.

        //  Text Box’a “Merhaba Dunya!” yazin.
        // Frame geçiş yapmadan once orayı ID ile locate edin
        WebElement txtBox = driver.findElement(By.id("mce_0_ifr"));
        // sonra locate ettiğimiz frame geçmek için aşağıdaki methodu kullanırız.
        driver.switchTo().frame(txtBox);
        // geçilen iframe'de yeniden işlemler için locate yapılır ve locate edilen yer
        // ile clear() içeriğini temizler sonrada içeriğine istediğimiz yazıyı göndeririz.
        WebElement tbFrame = driver.findElement(By.xpath("//p"));
        tbFrame.clear();
        tbFrame.sendKeys("Merhaba Dünya!");


        //  TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //  dogrulayin ve konsolda yazdirin.

        // driver.switchTo().defaultContent();

        // veya birden fazla iç-içe frameler kullanılmışsa bu kullanılabilir.
        // Ana frame'a ulaşmak için ise defaultContent ile çıkılabilir

        driver.switchTo().parentFrame();
        WebElement linkText = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println("linkText.getText() = " + linkText.getText());
    }
}
