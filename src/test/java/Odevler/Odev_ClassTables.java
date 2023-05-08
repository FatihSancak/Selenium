package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Odev_ClassTables extends TestBase {
    /*
    //div[@class='rt-tr-group'][1]/div/div[@class='rt-td'][3]

    1. “https://demoqa.com/webtables” sayfasina gidin
    2. Headers da bulunan department isimlerini yazdirin
    3. sutunun basligini yazdirin
    4. Tablodaki tum datalari yazdirin
    5. Tabloda kac cell (data) oldugunu yazdirin
    6. Tablodaki satir sayisini yazdirin
    7. Tablodaki sutun sayisini yazdirin
    8. Tablodaki 3.kolonu yazdirin
    9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
    sayisini girdigimde bana datayi yazdirsin
    */

    @Test
    public void tableTest() {
        //    1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //    2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmentList = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[@class='rt-td']"));
        for (WebElement each : departmentList
                ) {
                System.out.println(each.getText());
        }

        //    3. sutunun basligini yazdirin
        System.out.println("**********************************");
        System.out.println("Bölümler Başlığı "+driver.findElement(By.xpath("//div[@role='columnheader'][6]")).getText());

        //    4. Tablodaki tum datalari yazdirin
        System.out.println("**********************************");
        List<WebElement> tabloListesi = driver.findElements(By.xpath("//div[@role='grid']"));
        for (WebElement each: tabloListesi
             ) {
            System.out.println(each.getText());
        }
        //    5. Tabloda kac cell (data) oldugunu yazdirin

        //    6. Tablodaki satir sayisini yazdirin

        //    7. Tablodaki sutun sayisini yazdirin

        //    8. Tablodaki 3. kolonu yazdirin

        //    9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        //    10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //    sayisini girdigimde bana datayi yazdirsin


    }
}
