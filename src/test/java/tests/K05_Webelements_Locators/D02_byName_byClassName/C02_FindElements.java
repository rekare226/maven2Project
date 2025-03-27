package tests.K05_Webelements_Locators.D02_byName_byClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_FindElements {
    public static void main(String[] args) throws InterruptedException {

        //1-Bir test class'i olusturun ilgili ayarlari yapın
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //2-https://www.coolstoves.com/ adresine gidin
        driver.get("https://www.coolstoves.com/");
        //3- arama kutusuna stove yazın
        WebElement aramaKutusu=driver.findElement(By.id("input_search-box-input-comp-lygci5a2"));
        aramaKutusu.sendKeys("stove"+ Keys.ENTER);
        //aramaKutusu.submit();

        //4-kategori bolumunda 7 element oldugunu test edin
     List<WebElement>categoriElementleriList = driver.findElements(By.className("semdyD6"));
     int expectedCategarySayisi=7;
     int actualCategariySayisi=categoriElementleriList.size();

     if (expectedCategarySayisi==actualCategariySayisi){

         System.out.println("Categaroriy sayisi testi PASSED"); //Categaroriy sayisi testi PASSED
     }else System.out.println("Categaroriy sayisi testi FAILED");

        //5-kategori isimlerini yazdirin

        System.out.println(categoriElementleriList);
        //normalde List doğrudan yazdırılır ancak bizim listemiz web elementten oluştuğundan doğrudan yazdırılamaz

        for ( WebElement eachElement
                 :categoriElementleriList   ) {
            System.out.println(eachElement.getText());
           }

//        WOOD STOVES (28)
//        Enameled Cast Iron Stove (21)
//        Cast Iron Stove (17)
//        Sheet Stove (12)
//        Camping,Tent & Caravan Stove (6)
//        Pellet Stove (2)
//        Used Stoves (2)

        //6- Sayfayi kapatın



Thread.sleep(2000);
driver.quit();





    }
}
