package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev_12_KeyBoradActions extends TestBase {
    @Test
    public void Test() throws InterruptedException {
        //    1-"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //    2-Hover over Me First" kutusunun ustune gelin
        Actions action = new Actions(driver);
        WebElement weHoverOverMe = driver.findElement(By.xpath("(//div [@class='dropdown hover']/button[@class='dropbtn'])[1]"));

        action.moveToElement(weHoverOverMe).perform();

        Thread.sleep(2000);
        //    3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//div/a[@class='list-alert'])[1]")).click();

        //    4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //    5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //    6- "Click and hold" kutusuna basili tutun
        action
                .clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']")))
                .perform();

        //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        // Well done! keep holding that click now.....
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());

        //    8- “Double click me" butonunu cift tiklayin
        action
                .doubleClick(driver.findElement(By.xpath("//div[@id='double-click']")))
                .perform();
    }
}
