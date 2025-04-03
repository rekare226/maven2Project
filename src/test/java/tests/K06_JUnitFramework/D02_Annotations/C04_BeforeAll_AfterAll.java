package tests.K06_JUnitFramework.D02_Annotations;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class C04_BeforeAll_AfterAll {

    // 3 farkli test method u olusturarak asagidaki testleri gerceklestirin
    //1- Test otomasyonu anasayfaya gidin
    //Url'in test otomasyonu icerdigini test edin
    //2- phone icin arama yapin
         // ve  arama sonucunda urun bulunabildiğini test edin
    //3- ilk urunu tiklayin
          // ve acilan sayfadaki urun isminde case sensetive olmadan "phone" bulunduğu test edin

   static  WebDriver  driver;

    @BeforeAll
    public static void setup(){

            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }


    @AfterAll
    public static void teardown(){



    driver.quit();



    }

    @Test
    public void test01(){
        //1- Test otomasyonu anasayfaya gidin
        //Url'in testotomasyonu icerdigini test edin

       driver.get("https://www.testotomasyonu.com/");
       String expectedUrlIcerik="testotomasyonu";
       String actualUrlIcerik=driver.getCurrentUrl();

       if (actualUrlIcerik.contains(expectedUrlIcerik)){
           System.out.println("testotomasyonu icerik PASSED");

       }else System.out.println("testotomasyonu icerik FAILED");

    }
    @Test
    public void test02(){
        //2- phone icin arama yapin
        // ve  arama sonucunda urun bulunabildiğini test edin

        WebElement aramakutusu=driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone"+ Keys.ENTER);

        List<WebElement> bulunanUrunElementlerlist=driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi= bulunanUrunElementlerlist.size();

        if (actualBulunanUrunSayisi>0){

            System.out.println("urun  bulma testi PASSED");
        }else System.out.println("urun  bulma testi FAILED");


    }
    @Test
    public  void  test03(){


   driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();
WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4'] "));

String expectedIsimIcereigi="phone";
String actualIsim=ilkUrunIsimElementi.getText().toLowerCase();

if (actualIsim.contains(expectedIsimIcereigi)){

    System.out.println("Ilk urun isim testi PASSED");
}else System.out.println("Ilk urun isim testi FAILED");


}

    //3- ilk urunu tiklayin
    // ve acilan sayfadaki urun isminde case sensetive olmadan "phone" bulunduğu test edin

/*
Bu görev için her test method'undan sonra driver'i kapatmak (@AfterEach) mantikli olmaz bunun yerine;
class calismaya basladıgında hicbir method calismadan once driver'i ve tum @Test method'u kalmadiginda
driver'i kapatmak daha mantıklı olur

Bu tur birbirinin sonucuna bagli test method'lari oldugunda JUnit ile methodlari tek tek run edebiliriz
ancak method'un yapmasi gereken islevi yapmasi mumkun olmayabilir

@BeforeAll ve @AfterAll notasyonu kullanan methodlarin mutlaka static olması gerekir




 */




}
