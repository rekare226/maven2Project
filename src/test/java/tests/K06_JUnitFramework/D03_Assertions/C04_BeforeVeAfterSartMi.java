package tests.K06_JUnitFramework.D03_Assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_BeforeVeAfterSartMi {

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

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));


        //2- phone icin arama yapin



        WebElement aramakutusu=driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone"+ Keys.ENTER);

        // ve  arama sonucunda urun bulunabildiğini test edin
        List<WebElement> bulunanUrunElementlerlist=driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi= bulunanUrunElementlerlist.size();

        Assertions.assertTrue(actualBulunanUrunSayisi>0);


        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();
        WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4'] "));

        String expectedIsimIcereigi="phone";
        String actualIsim=ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcereigi));


    }





















}
