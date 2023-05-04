package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    @Test
    public void test(){
        //  https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //  “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim


        WebElement weDragHere = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement weDropMe = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actionDragMe = new Actions(driver);
        actionDragMe.dragAndDrop(weDragHere,weDropMe).perform();

        //  “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement weResult = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String txtResult = weResult.getText();
        String txtExpected = "Dropped!";

        Assert.assertEquals(txtExpected,txtResult);

    }
}
