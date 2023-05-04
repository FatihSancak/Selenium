package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com");
        // once arama kutusuna click yapip
        // sonra harf harf Nutella yazisini yazdiralim
        // sonra da ENTER tuşuna basalım

        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions action = new Actions(driver);

        action
                .click(searchTextBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(3000);


    }
}
