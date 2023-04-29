package day04_XPathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {
    /*
    Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. https://qa-environment.koalaresorthotels.com/ adresine gidiniz.
    b. Login butonuna basin
    c. username textbox,password textbox, and login button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
       username : manager
       password : Manager1!
     */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://qa-environment.koalaresorthotels.com/");

        driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();

        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();

        WebElement strActual = driver.findElement(By.cssSelector("span[class='caption-subject font-green-sharp bold uppercase']"));

        if (strActual.isDisplayed()){
            System.out.println("LISTOFUSERS displayed test PASSED");
        }else{
            System.out.println("LISTOFUSERS displayed test FAILED");
        }

        driver.close();
    }
}
