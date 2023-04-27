package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_manageMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://www.hepsiburada.com");
        driver.get("https://www.amazon.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        // bir sayfa açılırken sayfanın içinde kullanılan
        // elementlere göre bir yüklenme süresine ihtiyaç vardır.
        // veya bir web elementinin kullanılabilmesi için zamana
        // ihtiyaç olabilir. implicityWait bize sayfanın yüklenmesi
        // ve sayfadaki elementlere ulaşım için beklenecek
        // MAXIMUM süreyi belirleme olanığı tanır.

        //driver.close(); // Tarayıcıdaki aktif sekmeyi kapatır.
        driver.quit(); // Tarayıcıdaki tüm sekmeleri kapatır.

    }
}
