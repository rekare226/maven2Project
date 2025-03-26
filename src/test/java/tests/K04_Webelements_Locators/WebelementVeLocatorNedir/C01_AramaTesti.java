package tests.K04_Webelements_Locators.WebelementVeLocatorNedir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AramaTesti {

    public static void main(String[] args) throws InterruptedException {

    //1-Bir test class'i olusturan ilgili ayarlari yapın
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    //2- https://www.coolstoves.com adresine gidin
        driver.get("https://www.coolstoves.com");
    //3-urun arama kutusunu locate edin

        WebElement aramaKutusu=driver.findElement(By.id("input_search-box-input-comp-lygci5a2"));

    //4- arama kutusuna "stove" yazdırın

        aramaKutusu.sendKeys("stove");
        Thread.sleep(1000);
    //5- arama islemi yapabilmek icin   ENTER tusuna basın
        aramaKutusu.submit();


        Thread.sleep(3000);
        driver.quit();
    //sayfayı kapatın



    }
}
