package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Actions_ContextClick extends TestBase_Each {

    @Test
    public void test01(){

   //1-https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

   //2-"DGI Drones" uzerine sag click yapin
        WebElement dgiDronesElementi=driver.findElement(By.id("pic2_thumb"));

        Actions actions=new Actions(driver);
        ReusableMethods.bekle(1); //buradaki bekleme süresi zorunlu aksi takdirde göremiyor
        actions.contextClick(dgiDronesElementi)
                .perform();


   //3-Alert'te cikan yazinin "Tebrikler!... Sağ click yaptınız." oldugunu test edin
        String expectedYazi="Tebrikler!... Sağ click yaptınız.";
        //=====Alertte cikan yazi dediği için önce driver Alerte gecirilir
        String actualYazi=driver.switchTo()
                                 .alert()
                                 .getText();
        Assertions.assertEquals(expectedYazi,actualYazi);

   //4-Tamam diyerek alert'i kapatalım
        //buradaki Tamam diyerekden kasıt Alertte çıkan Tamam yazısının onaylanması bu nedenle driver tekrar Alerte gecirilir
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);









    }













}
