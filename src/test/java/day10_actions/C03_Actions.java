package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test(){
        //  https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //  Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(cizgiliAlanElementi).perform();

        //  Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualStr = driver.switchTo().alert().getText();
        String expectedStr = "You selected a context menu";
        Assert.assertEquals(expectedStr,actualStr);

        //  Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim
        String ilkSayfaWH = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowsHandles = driver.getWindowHandles();

        String ikinciSayfaWh="";

        for (String wh:windowsHandles) {
            if(ilkSayfaWH!=wh){
                ikinciSayfaWh = wh;
            }
        }
        driver.switchTo().window(ikinciSayfaWh);
        String actualElementalSelenium = driver.findElement(By.xpath("//h1")).getText();
        String expectedElementalSelenium ="Elemental Selenium";
        Assert.assertEquals(expectedElementalSelenium,actualElementalSelenium);
    }
}
