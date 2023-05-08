package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // input olarak verilen satır no, sütun no değerlerini
        // parametre olarak alıp o cell'deki datayı string
        // olarak döndüren bir method oluşturun
        // donen stringin Washington D.C. olduğunu test edin

        int satirNo =4;
        int sutunNO=4;
        String expectedData ="Washington D.C.";

        String actualData = getirExcelData("Sayfa1",satirNo-1, sutunNO-1); // Çünkü Excel index ile çalışır.

        Assert.assertEquals(expectedData,actualData);
    }

    public static String getirExcelData(String sayfaAdi, int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook.getSheet(sayfaAdi).getRow(satirIndex).getCell(sutunIndex).toString();

        return istenenData;
    }
}
