package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_checkBox {

    WebDriver driver;
    //    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
    //    a. Verilen web sayfasına gidin.
    //    https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    //    b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement weCheckbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement weCheckbox2 = driver.findElement(By.xpath("//input[2]"));

    //    c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if(!weCheckbox1.isSelected()){
            weCheckbox1.click();
        }

    //    d. Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if(!weCheckbox2.isSelected()){
            weCheckbox2.click();
        }
    }





}
