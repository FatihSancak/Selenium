package Odevler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev_6 {
    public static void main(String[] args) {
        /*
        1. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        2. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        doğru URL'yi yazdırın.
        3. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        4. Youtube sayfasina geri donun
        5. Sayfayi yenileyin
        6. Amazon sayfasina donun
        7. Sayfayi tamsayfa yapin
        8. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        Yoksa doğru başlığı(Actual Title) yazdırın.
        9.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        URL'yi yazdırın
        10.Sayfayi kapati
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver dvr = new ChromeDriver();

        // 1. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        // doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        dvr.get("https://www.youtube.com");
        String sayfaBasligi = dvr.getTitle();
        if(sayfaBasligi.contains("youtube")){
            System.out.println("Test: Passed. Sayfa başlığında youtube var.");
        }else{
            System.out.println("Test: Failed. Sayfa başlığı "+ sayfaBasligi);
        }

        // 2. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        // doğru URL'yi yazdırın.
        String sayfaURL = dvr.getCurrentUrl();
        if(sayfaURL.equals("youtube")){
            System.out.println("Test: Passed. URL'de youtube var.");
        }else{
            System.out.println("Test: Failed. Actual URL "+ sayfaURL);
        }

        // 3. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        dvr.navigate().to("https://www.amazon.com");

        // 4. Youtube sayfasina geri donun
        dvr.navigate().back();

        // 5. Sayfayi yenileyin
        dvr.navigate().refresh();

        // 6. Amazon sayfasina donun
        dvr.navigate().forward();

        // 7. Sayfayi tamsayfa yapin
        dvr.manage().window().maximize();

        // 8. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        sayfaBasligi = dvr.getTitle();
        if(sayfaBasligi.contains("youtube")){
            System.out.println("Test: Passed. Sayfa başlığında Amazon var.");
        }else{
            System.out.println("Test: Failed. Sayfa başlığı "+ sayfaBasligi);
        }
        // 9.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        // URL'yi yazdırın
        sayfaURL = dvr.getCurrentUrl();
        if(sayfaURL.equals("https://www.amazon.com/")){
            System.out.println("Test: Passed. URL'de var.");
        }else{
            System.out.println("Test: Failed. Actual URL "+ sayfaURL);
        }
        // 10.Sayfayi kapatin

        dvr.close();

    }
}
