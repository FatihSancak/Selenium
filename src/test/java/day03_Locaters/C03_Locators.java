package day03_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    /*
    Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. https://qa-environment.koalaresorthotels.com/ adresine gidiniz.
    b. Login butonuna basin
    c. username textbox,password textbox, and login button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
       username : manager
       password : Manager1!
    e. sayfanın üst sağ köşesinde manager yaısını kontrol edin.(verify).
    f. “LISTOFUSERS” ve “System Management” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    Sayfada kac tane link oldugunu bulun
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. https://qa-environment.koalaresorthotels.com/ adresine gidiniz
        driver.get("https://qa-environment.koalaresorthotels.com/");

        // b. Login butonuna basin
        WebElement loginLinki = driver.findElement(By.linkText("Log in"));
        loginLinki.click();

        //  c. username textbox,password textbox, and login button elementlerini locate ediniz..
        WebElement userTxt = driver.findElement(By.id("UserName"));
        WebElement passTxt = driver.findElement(By.id("Password"));
        WebElement signBtn = driver.findElement(By.id("btnSubmit"));

        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // username : manager
        // password : Manager1!

        userTxt.sendKeys("manager");
        passTxt.sendKeys("Manager1!");
        signBtn.click();

        // e. sayfanın üst sağ köşesinde manager yaısını kontrol edin.(verify).
        WebElement actualKullaniciAdi = driver.findElement(By.className("dropdown-toggle"));
        System.out.println("actualKullaniciAdi.getText() = " + actualKullaniciAdi.getText());

        String expectedUsername = "manager";

        if (expectedUsername.equals(actualKullaniciAdi.getText())) {
            System.out.println("Expected User Test PASSED");
        } else {
            System.out.println("Expected User Test FAILED");
        }

        // f. “LISTOFUSERS” ve “System Management” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement vfSystemManager = driver.findElement(By.linkText("System Management"));
        WebElement vfListOfUser = driver.findElement(By.linkText("ListOfUsers"));

        if (vfSystemManager.isDisplayed()) {
            System.out.println("System Manager Display Test PASSES");
        } else {
            System.out.println("System Manager Display Test FAILED");
        }

        if (vfListOfUser.isDisplayed()) {
            System.out.println("LISTOFUSERS Display Test PASSES");
        } else {
            System.out.println("LISTOFUSERS Display Test FAILED");
        }

        // Sayfada kac tane link oldugunu bulun
        List<WebElement> linklerList = driver.findElements(By.tagName("a"));
        System.out.println("Sayfadaki Linklerin Sayısı : " + linklerList.size());

        // linklerin dökümü
        int i = 0;
        for (WebElement each : linklerList) {
            i++;
            System.out.println(i +"."+ each.getText());
        }
        driver.close();
    }
}
