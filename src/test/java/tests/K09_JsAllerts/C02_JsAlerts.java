package tests.K09_JsAllerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C02_JsAlerts extends TestBase_Each {

    //3 test methodu olusturup asagidaki görevi tamamlayin

    @Test
    public void jsAlertTest(){

        //1. test
        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        //1.alert e tiklayin
      // driver.findElement(By.xpath("(//button[@class='j-button'])[1]")).click();
        WebElement jsAlertButton= driver.findElement(By.xpath("(//button[@class='j-button'])[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",jsAlertButton);

    //Alert deki yazinin "I am a JS Alert" oldugunu test edin
    //OK tusuna basip alert'i kapatin

        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver
                                      .switchTo()
                                      .alert()
                                       .getText();
        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        ReusableMethods.bekle(2);

        //-OK tusuna basip alert i kapatın

        driver
                .switchTo()
                .alert()
                .accept();


    }

 @Test
 public void jsConfirmTest(){

//2. Test
//-https://testotomasyonu.com/javascriptAlert adresine gidin
     driver.get("https://testotomasyonu.com/javascriptAlert");
     //2.alert e tiklayalim
     driver.findElement(By.xpath("(//button[@class='j-button'])[2]")).click();
     ReusableMethods.bekle(2);
     //cansel 'a basip,
     driver.switchTo().alert().dismiss();
     //cikan yazının"You clicked: Cancel" oldugunu test edin
     String expectedSonucYazisi="You clicked: Cancel";
     String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();

     Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

//-Cancel a basip,
// cikan sonuc yazisinin  "You clicked: Cancel"

}

@Test
    public void jsPromtTest(){
        //3. test
    //-https://testotomasyonu.com/javascriptAlert adresine gidin
    driver.get("https://testotomasyonu.com/javascriptAlert");
    //-3.alert'e tiklayalim
    driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
    //cikan prompt ekranina "Cansu" yazdiralim
    driver.switchTo().alert().sendKeys("Cansu");
    ReusableMethods.bekle(12);
    driver.switchTo().alert().accept();
    //cikan sonuc yazisinin cansu içerdiğini test edelim
    String expectedSonucYaziIcerigi=driver.findElement(By.xpath("//*[@id='result']")).getText();
    String actualSonucYazisi=driver.findElement(By.id("result")).getText();
    Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));





}















}
