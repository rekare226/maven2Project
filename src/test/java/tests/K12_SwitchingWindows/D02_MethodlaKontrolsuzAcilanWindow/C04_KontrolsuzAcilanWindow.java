package tests.K12_SwitchingWindows.D02_MethodlaKontrolsuzAcilanWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C04_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){
     //https://the-internet.herokuapp.com/windows adresine gidin.
     driver.get("https://the-internet.herokuapp.com/windows");

     //sayfadaki elemental selenium linkini tiklayin
        WebElement elementalSeleniumLink = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementalSeleniumLink);

             //acilan yeni window a gecip
            //gecisi yeni window'un title'ini kullanarak yapin
           //1-acik olan tum window'larin WHD lerini alip kaydedelim
        Set<String> acikTumWindowlarinWhgleri= driver.getWindowHandles();
          //su an açilan tüm windowhandler elimizde mevcut

        String hedefWindowUnTitlesi="Home | Elemental Selenium";

        for ( String eachWindowhandleDegeri
                 :acikTumWindowlarinWhgleri   ) {

            driver.switchTo().window(eachWindowhandleDegeri);
            //burada geçtiğimiz window un title sini alip geçmek
            // istediğimiz window un title na eşit mi diye kontrol edelim

            if (driver.getTitle().equals(hedefWindowUnTitlesi)) {
                //for each ile bakılan yada gecilen windowdaki title hedeftitle ile eşit ise dogru yerdeyiz
                // demektir ve burada kalabilirz

                break;
            }
        }


            //buyuk basligin"Elemental Selenium" oldugunu test edin
            String expextedBuyukbaslikYazisi="Elemental Selenium";
            String elementalSeleniumYazisi = driver.findElement(By.tagName("h1")).getText();
            Assertions.assertEquals(expextedBuyukbaslikYazisi,elementalSeleniumYazisi);











    }



}
