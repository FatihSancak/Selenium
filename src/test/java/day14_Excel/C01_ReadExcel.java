package day14_Excel;

import junit.framework.Assert;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //        7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //        8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //        9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //        10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //        11. Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //        12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);

        //        13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        System.out.println(cell);

        // 3. index'deki atırın 3. index'indeki verinin Wasgington D.C. olduğunu test edin

        String expectedData = "Washington D.C.";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());
    }
}
