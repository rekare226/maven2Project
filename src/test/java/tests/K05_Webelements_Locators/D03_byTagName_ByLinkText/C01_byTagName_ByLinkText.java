package tests.K05_Webelements_Locators.D03_byTagName_ByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_byTagName_ByLinkText {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class ı olusturun ilgili ayarlari yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // cikan cookies kabul edin

     //   Thread.sleep(2000);
       // driver.findElement(By.className("fc-button-label")).click();
       // Thread.sleep(2000);
        //3-Sayfada 147 adet link bulundugunu test edin
        List<WebElement> sayfadakiLinkListesi=driver.findElements(By.tagName("a") );
        int expectedLinksayisi=147;
        int actualLinksayisi=sayfadakiLinkListesi.size();

        if (expectedLinksayisi==actualLinksayisi){

            System.out.println("Link sayisi testi PASSED");
        }else {

            System.out.println("Link sayisi testi FAILED");
            System.out.println(" sayfada bulunan link sayisi 147 değil"+actualLinksayisi);
        }


        //4-Products linkine tiklayın

      //  driver.findElement(By.linkText(" Products")).click();

        driver.findElement(By.partialLinkText("Products")).click();

        //5-special offer yazisinin gorundugunu test edin
        WebElement specialOfferYaziElementi=driver.findElement(By.id("sale_image"));
       if ( specialOfferYaziElementi.isDisplayed()){

           System.out.println("specialOfferYaziElementi testi PASSED");
       }else System.out.println("specialOfferYaziElementi testi FAILED");


        Thread.sleep(3000);
        driver.quit();

        //6- sayfayi kapatin













    }
}
