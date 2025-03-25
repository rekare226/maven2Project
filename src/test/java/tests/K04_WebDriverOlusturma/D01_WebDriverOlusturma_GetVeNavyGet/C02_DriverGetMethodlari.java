package tests.K04_WebDriverOlusturma.D01_WebDriverOlusturma_GetVeNavyGet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        driver.get("https://coolstoves.com");
        System.out.println(driver.getTitle());//coolstoves | cooker stove
        //sayfanın baslıgını/etiketini getirir

        System.out.println(driver.getCurrentUrl());//https://www.coolstoves.com/
        //gidilen sayfadaki actual url yi getirir

        System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandle());//B51AA7550575C474EC519E3654406660
        System.out.println(driver.getWindowHandles());//[B51AA7550575C474EC519E3654406660] //bu bir settir driver her çalıştığında unique değer atar


        Thread.sleep(3000);
       // driver.close();//çalışan tek sayfayı kapatır

        driver.quit();//tüm pencereleri kapatır


    }
}
