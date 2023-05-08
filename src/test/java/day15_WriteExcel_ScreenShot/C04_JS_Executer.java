package day15_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_JS_Executer extends TestBase {

    @Test
    public void jsExecuterTest() throws InterruptedException {
        // amazona gidin
        // aşağıdaki Sign in butonu görününceye kadar scroll yapın
        // gürününce de JS ile click yapalım

        driver.get("https://www.amazon.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //        WebElement signInButonu = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//span[text()='Sign in'])[3]"))));
        WebElement signInButonu = driver.findElement(By.xpath("//a[@aria-label='Baby']"));


        jse.executeScript("arguments[0].scrollIntoView(true)", signInButonu);
        jse.executeScript("arguments[0].click()",signInButonu);
        Thread.sleep(3000);

    }
}
