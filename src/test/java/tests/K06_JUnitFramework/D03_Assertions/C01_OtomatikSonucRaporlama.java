package tests.K06_JUnitFramework.D03_Assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.List;

public class C01_OtomatikSonucRaporlama {

    //3 farkli test method u olusturarak asagidaki testleri gerceklestirin
    //1- Test otomasyonu anasayfaya gidin
    //   Url'nin testotomasyonu icerdigini test edin
    // 2-phone icin arama yapin
    // ve arama sonucunda urun bulunabldiğini test edin
    //3- ilk ürünu tıklayın
       // acilan sayfadaki urun isminde case sensetive olmadan "phone" bulundugunu test edin


    static WebDriver driver;

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

        }else{

            System.out.println("testotomasyonu icerik FAILED");
            throw new AssertionFailedError();
        }

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
        }else{

            System.out.println("urun  bulma testi FAILED");
            throw new AssertionFailedError();
        }


    }
    @Test
    public  void  test03(){


        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();
        WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4'] "));

        String expectedIsimIcereigi="phone";
        String actualIsim=ilkUrunIsimElementi.getText().toLowerCase();

        if (actualIsim.contains(expectedIsimIcereigi)){

            System.out.println("Ilk urun isim testi PASSED");
        }else{

            System.out.println("Ilk urun isim testi FAILED");
            throw new AssertionFailedError();
        }


    }







}
