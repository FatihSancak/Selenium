package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_FirstTest {
    public static void main(String[] args) {
        /*
        1. https://www.amazon.com url'ine gidin
        2. Başlığın Amazon kelimesi içerdiğini test edin
        3. URL'nin "https://www.amazon.com" a eşit olduğunu test edin.
        4. Sayfayı kapatın
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        1. https://www.amazon.com url'ine gidin
        driver.get("https://wwww.amazon.com");

//        2. Başlığın Amazon kelimesi içerdiğini test edin
        String actualTitle =  driver.getTitle();
        String arananaKelime = "Amazon";
        if(actualTitle.contains(arananaKelime)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title aranana kelimeyi içermiyor. FAILED");
        }

//        3. URL'nin "https://www.amazon.com" a eşit olduğunu test edin.
        String actualURL = driver.getCurrentUrl();
        String arananURL = "https://www.amazon.com";
        if(actualTitle.equals(arananURL)){
            System.out.println("URL testi PASSED");
        }
        else{
            System.out.println("Actual URL : "+ actualURL +" beklenenden farklı. FAILED");
        }

//        4. Sayfayı kapatın
        driver.close();

    }
}
