package day11_Facker_File;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class C03_FileExist {
    @Test

    public void test01() {
        // Çalışılan projenin Path'ini döndürür
        System.out.println(System.getProperty("user.dir"));

        // Aktif bilgisayar kullanıcısının yolunu verir.
        System.out.println(System.getProperty("user.home"));

        // C:\Users\asus\Downloads -> İndirilenler klasörü
        // homePath +"\Downloads"
        // Desktop'daki text.txt dosyasının varlığını test edelim
        // C:\Users\asus\Desktop

        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println("dosyaYolu = " + dosyaYolu);

        Assert.assertTrue(Files.exists(Path.of(dosyaYolu)));



    }
}
