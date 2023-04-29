package day04_XPathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_RelativeXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.driver.chrome","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement bostonWE = driver.findElement(By.id("pid6_thumb"));
        WebElement sailorWE = driver.findElement(By.id("pid11_thumb"));
        WebElement mountieWE= driver.findElement(RelativeLocator.with(By.tagName("img")).below(bostonWE).toLeftOf(sailorWE));
        System.out.println(mountieWE.getAttribute("id"));
    }
}
