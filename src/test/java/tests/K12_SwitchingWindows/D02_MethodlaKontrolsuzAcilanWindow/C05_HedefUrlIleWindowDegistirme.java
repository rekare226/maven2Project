package tests.K12_SwitchingWindows.D02_MethodlaKontrolsuzAcilanWindow;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

import java.util.Set;

public class C05_HedefUrlIleWindowDegistirme extends TestBase_Each {

    @Test

    public void test01(){

        //1-https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        //2-sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        //3-acilan yeni window'a gecin;
        //url ile gecis yapın
        Set<String> acikTumWindowlarinhandleri=driver.getWindowHandles();
        String hedefWindowUrl="https://elementalselenium.com/";
        for ( String eachWhd
                 :acikTumWindowlarinhandleri  ) {

              driver.switchTo().window(eachWhd);

        if (driver.getCurrentUrl().equals(hedefWindowUrl)){

            break;
        }
           }

        //buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedBaslik="Elemental Selenium";
        String actualBaslik=driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
        Assertions.assertEquals(expectedBaslik,actualBaslik);






    }



}
