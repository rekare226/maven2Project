package tests.K04_WebDriverOlusturma.D01_WebDriverOlusturma_GetVeNavyGet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.coolstoves.com");
        Thread.sleep(1000);
        driver.navigate().to("https://www.imamsarıgı.com");
        //driver.get ile ayni işleve sahiptir
        Thread.sleep(1000);

        //geriye tekrar coolstoves e donun

       driver.navigate().back();
        Thread.sleep(1000);

        //yeniden imamsarıgını dönmek istersek

        driver.navigate().forward();
        Thread.sleep(1000);





        driver.quit();







    }
}
