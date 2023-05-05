package day12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExpicitlyWait extends TestBase {
    //  1. Bir metod olusturun : enabledTest()
    //  2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //  3. Textbox’in etkin olmadigini(enabled) dogrulayın
    //  4. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //  5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //  6. Textbox’in etkin oldugunu(enabled) dogrulayın.
    @Test
    public void enabledTest() {
        //  2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //  3. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement txtBoxEnable = driver.findElement(By.xpath("//form/input[@type='text']"));
        Assert.assertFalse(txtBoxEnable.isEnabled());

        //  4. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//form/button[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(txtBoxEnable));

        //  5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enableMsg = driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(enableMsg.isDisplayed());

        //  6. Textbox’in etkin oldugunu(enabled) dogrulayın.    @Test
        Assert.assertTrue(txtBoxEnable.isEnabled());
    }
}
