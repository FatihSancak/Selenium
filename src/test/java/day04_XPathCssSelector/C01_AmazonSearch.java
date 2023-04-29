package day04_XPathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_AmazonSearch {
    public static void main(String[] args) {
        /*
        Main method oluşturun ve aşağıdaki görevi tamamlayın.
        a. https://www. amazon.com/
        b. Search(ara) "City bike"
        c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
         */

        System.setProperty("webdriver.chrome.drive","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. https://www. amazon.com/
        driver.get("https://www.amazon.com/");

        // b. Search(ara) "City bike"
        WebElement srcBox = driver.findElement(By.id("twotabsearchtextbox"));
        srcBox.sendKeys("City bike" + Keys.ENTER);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> istenenElementListesi = driver.findElements(By.className("sg-col-inner"));
        WebElement sonucYazisi = istenenElementListesi.get(0);
        System.out.println(sonucYazisi.getText());

        // d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> istenenUrunResimleriistesi = driver.findElements(By.className("s-image"));
        WebElement sonucUrunResimi = istenenUrunResimleriistesi.get(10);
        sonucUrunResimi.click();
    }
}
