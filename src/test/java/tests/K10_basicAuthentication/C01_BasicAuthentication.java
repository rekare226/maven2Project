package tests.K10_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_BasicAuthentication extends TestBase_Each {
    @Test
    public void test01(){
        //1- bir class olusturun:BasicAuthentication
        //2- https://www.testotomasyonu.com/basicauth sayfasina gidin
        //asagidaki yontem ve test datalarinı kullanarak authentication 'i yapin
        //
         //Html komutu: https://username:password@URL
        // Username   : membername
        // password   : sunflower

        /*
        driver.get ("https://www.testotomasyonu.com/basicauth");
        sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
        ancak otomasyon ile gittiğimizde
        kullanıcı adi ve sifresi bolumu locate edemediğimizden kullanamayiz
        bunun yerine kullandığımız url'nin sahibi olan sirketin
        bize vereceği kullanici adi ve sifresini
        yine sirketin bize tarif edeceği yontemle URL' e eklemeliyiz...

         */


        //4- basarili sekilde sayfaya girildiğini doğrulayın


        driver.get("https://membername:sunflower@www.testotomasyonu.com/basicauth");
        ReusableMethods.bekle(10);
        String expectedYazi="Basic Auth";
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String actualYazi=yaziElementi.getText();
        Assertions.assertEquals(expectedYazi,actualYazi);



    }








}
