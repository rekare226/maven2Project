package tests.K12_SwitchingWindows.D02_MethodlaKontrolsuzAcilanWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_WindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        //1-https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        //2-sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        //3- acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu  test edin
          // ama önce title kullanarak yeni window a gecelim //3 nolu görevde yeni window da dediği için ;
        // ReusableMethods.titleIleGecisYap(driver,"Home | Elemental Selenium"); kodu ile yeni window a gectik
        ReusableMethods.titleIleGecisYap(driver,"Home | Elemental Selenium");
        String expectedBuyukBaslikYazi="Elemental Selenium";
        String actualBuyukBaslikyazi=driver.findElement(By.tagName("h1")).getText();
        Assertions.assertEquals(expectedBuyukBaslikYazi,actualBuyukBaslikyazi);

        //4-ilk window a geri donun
        ReusableMethods.urlIlegecis(driver,"https://the-internet.herokuapp.com/windows");

        //"Opening a new window" yazisinin gorunur oldugunu test edin

        String expectedYazi="Opening a new window";
       //String actualYazi=driver.findElement(By.tagName("//h3")).getText();
       WebElement openingWindowElementi=driver.findElement(By.tagName("h3"));
        Assertions.assertTrue(openingWindowElementi.isDisplayed());
        ReusableMethods.bekle(2);

        //Click here basin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        //acilan yeni window a gecip, oradaki yazinin "New Window" oldugunu test edin
        ReusableMethods.titleIleGecisYap(driver,"New Window");
        expectedYazi="New Window";
        actualBuyukBaslikyazi=driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(expectedYazi,actualBuyukBaslikyazi);

        //Elemental Selenium acik oldugu window a gecin
        ReusableMethods.titleIleGecisYap(driver,"Home | Elemental Selenium");

        //Tips linkinin erişilebilir oldugunu test edin
        WebElement tipsElementi=driver.findElement(By.xpath("//*[.='Tips']"));
        Assertions.assertTrue(tipsElementi.isEnabled());














    }



}
