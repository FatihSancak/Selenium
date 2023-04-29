package day03_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElementMethods {
    /*
    1. https://www.amazon.com'a gidip arama kutusunu locate edin.
    2. Arama kutusunun tagName'nin input olduğunu test edin
    3. Arama kutusunun name attribute değerinin field-keywords olduğunu test edin.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. https://www.amazon.com'a gidip arama kutusunu locate edin.
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //2. Arama kutusunun tagName'nin input olduğunu test edin
        String expectedTagName = "input";
        String actualTagName = searchBox.getTagName();

        if(expectedTagName.equals(actualTagName)){
            System.out.println("Tag Name Testi : PASSED");
        }else {
            System.out.println("Tag Name Test : FAILED");
        }

        //3. Arama kutusunun name attribute değerinin field-keywords olduğunu test edin.
        String expectedNameValue = "field-keywords";
        String actualNameValue = searchBox.getAttribute("name");

        if(expectedNameValue.equals(actualNameValue)){
            System.out.println("Attribute Testi : PASSED");
        }else {
            System.out.println("Attribute Test : FAILED");
        }
        driver.close();

    }
}