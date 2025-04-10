package utilities;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle (int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep komutu calismadi");
        }
    }

    public static List<String> stringListeDondur(List<WebElement> WebElementListesi){


        List<String> stringList=new ArrayList<>();

        for(WebElement eachElement:WebElementListesi){

            stringList.add( eachElement.getText());

        }
        return stringList;
    }

    public static void titleIleGecisYap(WebDriver driver,String hedefWindowUnTitlesi){

        //1-acik olan tum window'larin WHD lerini alip kaydedelim
        Set<String> acikTumWindowlarinWhgleri= driver.getWindowHandles();
        //su an açilan tüm windowhandler elimizde mevcut

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



    }

    public static void urlIlegecis(WebDriver driver,String hedefWindowUrl ){

        Set<String> acikTumWindowlarinhandleri=driver.getWindowHandles();

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


