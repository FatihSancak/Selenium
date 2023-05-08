package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // Sayfa2 ye gidip satır sayısının 24, kullanılan satır sayının 12 olduğunu test edin

        int sonrSatirIndex = workbook
                .getSheet("Sayfa2")
                .getLastRowNum();

        int expectedSatirSayisi = 23;
        Assert.assertEquals(expectedSatirSayisi,sonrSatirIndex);

        int kullanilanSatirSayisi = workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();
        int expectdKullanilanSatirSayisi = 12;
        Assert.assertEquals(expectedSatirSayisi,kullanilanSatirSayisi);

    }
}
