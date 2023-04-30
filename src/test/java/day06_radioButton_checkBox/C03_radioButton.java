package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C03_radioButton {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        // - “Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[contains(text(),'Yeni hesap oluştur')])[1]")).click();
        // - “radio buttons” elementlerini locate edin
        WebElement weRadioButton1 = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        WebElement weRadioButton2 = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        WebElement weRadioButton3 = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
        // - Secili degilse cinsiyet butonundan size uygun olani secin

        weRadioButton2.click();

        Thread.sleep(3000);
    }


}
