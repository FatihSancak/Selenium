package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // ingilizce başkentler sütununu yazdıralım

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String satirdakiData ="";

        for (int i = 0; i < sonSatir; i++) {
            satirdakiData = C03_ReadExcel.getirExcelData("Sayfa1",i,1);
            System.out.println(satirdakiData);
        }
    }
}
