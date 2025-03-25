package tests.K04_WebDriverOlusturma.D01_WebDriverOlusturma_GetVeNavyGet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTestOtomasyonu {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();


      // 1- coolstoves sayfasına gidelim.https://www.coolstoves.com
        driver.get("https://www.coolstoves.com");


     //  2- Sayfa basligini (title)yazdirin
        System.out.println(driver.getTitle());//coolstoves | cooker stove

        // 3- Sayfa basliginin "coolstoves " icerdigine test edin

        String expectedTitleIcerik="coolstoves";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");//Title testi PASSED

        }else System.out.println("Title testi FAILED");

      // 4- sayfa url sini yazdirin
        System.out.println(driver.getCurrentUrl());

        // 5- sayfa url sinin https://coolstoves.com/ oldugunu test edin

        String expectedURl="https://coolstoves.com/";
        String actualURL=driver.getCurrentUrl();//https://www.coolstoves.com/

        if (actualURL.equals(expectedURl)){

            System.out.println("URL testi PASSED");
        }else  System.out.println("URL testi FAILED"); //URL testi FAILED

        // 6-sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

     //  7-sayfa kodlarında "stoves" kelimesi gectigini test edin

        String expectedSayfakaynakIcerik="stoves";
        String actualSayfaKaynagi=driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedSayfakaynakIcerik)){

            System.out.println("stoves kelimesi kod iceriğinde varlığı testi PASSED"); //stoves kelimesi kod iceriğinde varlığı testi PASSED
        }else System.out.println("stoves kelimesi kod iceriğinde varlığı testi FAILED");

    //   9-sayfayı kapatın

       Thread.sleep(3000);
       driver.quit();




    }
}
