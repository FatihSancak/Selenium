package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDownOptions {
    /*
     https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown options'ı yazdırın
        5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        False yazdırın
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {


        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);

        // index'e göre seç ve yazdır
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // value'e göre seç ve yazdır
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // visible'e göre seç ve yazdır
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // Tüm dropdown options'ı  yazdırın
        List<WebElement> optionListesi = select.getOptions();

        for (WebElement each: optionListesi) {
            System.out.println("Değerler : " + each.getText());
        }


        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        // False yazdırın

        int dropdownBoyut = optionListesi.size();
        if(dropdownBoyut==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

}
