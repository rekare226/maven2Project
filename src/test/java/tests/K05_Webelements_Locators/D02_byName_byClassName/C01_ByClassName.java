package tests.K05_Webelements_Locators.D02_byName_byClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByClassName {
    public static void main(String[] args) throws InterruptedException {

    //1- Bir test class'i olusturan ilgili ayarlari yapın
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    //2-https://www.coolstoves.com adresine gidin
        driver.get("https://www.coolstoves.com");
    //3-urun arama kutusunu locate edin
        WebElement aramaKutusu=driver.findElement(By.id("input_search-box-input-comp-lygci5a2"));
    //arama kutusuna "stove" yazdirin
        aramaKutusu.sendKeys("stove");
    //5-arama işlemini yapabilmek için ENTER tusuna basin
        aramaKutusu.submit();
    //6-arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucYazisiElement = driver.findElement(By.className("snA2M55"));
        //WebElement non-primitve data turudur
        //ve Arrays gibi doğrudan yazdırılamaz
        //eger webElelement üzerindeki yazı görülmek istenirse getText() methodu kullanılır

       // System.out.println(aramaSonucYazisiElement.getText());//61 results found
        String aramaSonucYazisi=aramaSonucYazisiElement.getText();
        aramaSonucYazisi=aramaSonucYazisi.replaceAll("\\D","");
        int actualAramaSonucSayisi=Integer.parseInt(aramaSonucYazisi);

        if (actualAramaSonucSayisi>0){

            System.out.println("Urun arama testi PASSED");//Urun arama testi PASSED
        }else System.out.println("urun arama testi FAILED");


        Thread.sleep(4000);
        driver.quit();




    }
}
