package day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        System.out.println("actual title : " + driver.getTitle());
        System.out.println("actual URL " + driver.getCurrentUrl());

        driver.close();

    }
}
