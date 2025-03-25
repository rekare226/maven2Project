package tests.K04_WebDriverOlusturma.D01_WebDriverOlusturma_GetVeNavyGet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigateMethodlariTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

   // 1.Youtube ana sayfasina gidin.https://www.youtube.com
        driver.get("https://www.youtube.com");
   // 2.url'in "youtube" icerdigini test edin
        String expectedUrlIcerik="youtube";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){

            System.out.println("Url testi PASSED");

        }else System.out.println("Url testi FAILED");


   // 3.coolstoves sayfasina gidin. https://www.coolstoves.com
        //driver.get("https://www.coolstoves.com");
        driver.navigate().to("https://www.coolstoves.com");

   //4. Title'in "coolstoves" icerdiğini test edin.
        String expectedTitleIcerik="coolstoves";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("coolstoves title içerik testi PASSED");
        }else System.out.println("coolstoves title icerik testi FAILED");

   //5. Tekrar Youtube sayfasina donun
        driver.navigate().back();
   //6. Title'in "YouTube" oldugunu test edin
        String expectedTitle="YouTube";
        actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitle)){

            System.out.println("Youtube title testi PASSED");
        }else System.out.println("Youtube title testi FAILED");

   //7. Sayfayi Refresh (yenile) yapin
        driver.navigate().refresh();
   //8. Sayfayi kapatalim /Tum sayfalari kapatin...

        Thread.sleep(2000);
        driver.quit();

    }
}
