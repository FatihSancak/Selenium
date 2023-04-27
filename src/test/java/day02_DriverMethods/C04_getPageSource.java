package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_getPageSource {
    // Amazon sitesine gidip Kaynak Kodları'nda "Spend less" yazdığını test edin.
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        String sayfaKankaKodlari = driver.getPageSource();
        String arananKelime = "Spend less";

        if (sayfaKankaKodlari.contains(arananKelime)) {
            System.out.println("Kaynak Kodu test PASSED");
        } else {
            System.out.println("Kaynak Kodda Aranan Kelime Yok FAILED");
        }
        driver.close();
    }
}
