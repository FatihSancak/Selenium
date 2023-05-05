package day12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExpicitlyWait extends TestBase {
    /*
        Iki tane metod olusturun : implicitWait() , explicitWait()
        Iki metod icin de asagidaki adimlari test edin.
     */
    @Test
    public void impicitWaitTesti() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement elementItsGone = driver.findElement(By.xpath("//p[@id='message' and text()=\"It's gone!\"]"));
        Assert.assertTrue(elementItsGone.isDisplayed());

        // Add buttonuna basin Add
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // It’s back mesajinin gorundugunu test edin
        WebElement elementItsBack = driver.findElement(By.xpath("//p[@id='message' and text()=\"It's back!\"]"));
        Assert.assertTrue(elementItsBack.isDisplayed());
    }

    @Test
    public void explicitlyWaitTest() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementItsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(elementItsGone.isDisplayed());

        // Add buttonuna basin Add
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // It’s back mesajinin gorundugunu test edin
        WebElement elementItsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(elementItsBack.isDisplayed());
    }
}
