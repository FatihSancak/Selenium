package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Tables extends TestBase {
    @Test
    public void tableTest() {

        // login( ) metodun oluşturun ve oturum açın.
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        // Username : manager
        // Password : Manager1!
        girisYap();

        // table( ) metodu oluşturun
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//thead//tr[1]/th"));
        System.out.println("Sütun Sayısı : " + sutunBasliklari.size());

        // Table’daki tum body’ı ve başlıkları(headers) konsolda yazdırın.
        // Tüm body'i, bir string olarak yazdırmak isterseniz
        // tumBody WebElement'ine locate ederek getText() method'u ile yazdırabilirsiniz.
        WebElement tumBody = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBody.getText());

        // printRows( ) metodu oluşturun //tr
        // Table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> tumTRow = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satır Sayısı : " + tumTRow.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : tumTRow) {
            System.out.println(each.getText());
        }

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]/td"));

        for (WebElement each : cellList
        ) {
            System.out.println("4. Sıradaki Bilgi : " + each.getText());
        }

        // Email sütunundaki (başlığındaki) tüm elementleri console'da yazdırın
        // arananSutun dinamik yapıda oluşturularak buraya istenilen sütundaki bilgiler getirilecektir.
        String arananSutun = "Name Surname";
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));

        int arananSutunIndexi = 0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals(arananSutun)) {
                arananSutunIndexi = i;
            }

        }
        // List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td[3]"));
        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td[" + (arananSutunIndexi + 1) + "]"));
        System.out.println("Toplam E-Mail Sayısı : " + emailSutunListesi.size());

        for (WebElement each : emailSutunListesi
        ) {
            System.out.println(arananSutun+ " Bilgileri : " + each.getText());
        }
    }

    public  void girisYap() {
        driver.get("https://www.hotelmycamp.com/admin/UserAdmin");
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!", Keys.ENTER);
    }
}
