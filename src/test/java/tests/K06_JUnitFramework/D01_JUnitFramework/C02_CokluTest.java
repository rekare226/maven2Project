package tests.K06_JUnitFramework.D01_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_CokluTest {


       //3 farkli method olusturun
       //1. method testotomasyonu anasayfaya gidin
       //                 title'nin Test Otomasyonuna icerdigini test edin
       // 2. method wisequarter anasayfaya gidin
                    //url'nin wisequarter icerdigini test edin
        //3. method junit.org adresine gidin
                    //url'nin https://junit.org/junit5/ oldugunu test edin

    public static void main(String[] args) {

      testOtomasyonuTest();
      wisequarterTesti();
      junitTesti();
    }


    public static void testOtomasyonuTest()  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/");
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {

            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();

    }

    public static void wisequarterTesti()  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wisequarter.com/");

        String expectedUrlIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){

            System.out.println("Url icerik testi PASSED");
        }else System.out.println("Url icerik testi FAILED");

       ReusableMethods.bekle(1);
        driver.quit();


    }

    public static void junitTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://junit.org/");

        String expectedUrl="https://junit.org/junit5/";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){

            System.out.println("JUnit url testi PASSED");
        }else System.out.println("JUnit url testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();


    }

}
