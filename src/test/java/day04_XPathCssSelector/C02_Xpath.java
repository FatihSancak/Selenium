package day04_XPathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {
        /*
        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4 Delete tusuna basin
        5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//div/button[@onclick='addElement()']")).click();

        // 3- Delete butonu’nun gorunur oldugunu test edin
        // WebElement btnDelete = driver.findElement(By.className("added-manually")); // CLASSNAME LOCATE
         WebElement btnDelete = driver.findElement(By.xpath("//button[@class='added-manually']")); // XPATH LOCATE
        if(btnDelete.isDisplayed()){
            System.out.println("Delete Button Is Displayed Test : PASSED");
        }else {
            System.out.println("Delete Button Is Displayed Test : FAILED");
        }

        // 4- Delete tusuna basin
        btnDelete.click();

        // 5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        //WebElement headerAddRemove = driver.findElement(By.xpath("//div/h3"));
        WebElement headerAddRemove = driver.findElement(By.tagName("h3")); // TAGNAME LOCATE
        if(headerAddRemove.isDisplayed()){
            System.out.println("Add/Remove Elements is Display Test: PASSED");
        }else {
            System.out.println("Add/Remove Elements is Display Test: FAILED");
        }

        driver.close();

    }
}
