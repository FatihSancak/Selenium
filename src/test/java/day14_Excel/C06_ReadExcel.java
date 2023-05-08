package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // Excell dosyasındaki tüm verileri class'a alıp
        // bir Java Obejct'ine store edelim. Böylece her
        // seferinde  Excel'e ulaşıp satır sütun vs ulaşmak
        // için uğraşılmasın.

        // Database yapısında olan excel'i koyabileceğimiz
        // en uygun Java obejct'i MAP'tir

        Map<String, String> ulkeBaskentMap = new HashMap<>();

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonSatirIndex; i++) {
            // key birinci satırdaki 0 index deki data
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            // value ise i.nci satırdaki 1,2,3 index'deki dataların birleşimi olacak
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkeBaskentMap.put(key, value);

        }

        System.out.println(ulkeBaskentMap);

        // Listede Ghana olduğunu test edelim
        // Assert.assertTrue(ulkeBaskentMap.containsKey("Ghana") );
        Assert.assertTrue(ulkeBaskentMap.keySet().contains("Ghana") );

    }
}
