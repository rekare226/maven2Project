package tests.K11_IFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase_Each;

import java.util.List;

public class C01_IFrame extends TestBase_Each {
    @Test
    public void test01(){
        //1) https://demoga.com/frames sitesine gidiniz

        driver.get("https://demoqa.com/frames");


        //2) This is a sample page yazisinin gorunur oldugunu test edin

        WebElement hedefYaziIframeElementi =driver.findElement(By.id("frame1"));
        driver.switchTo().frame(hedefYaziIframeElementi);


        /*
        yaziyi unique olarak locate etmemize rağmen kullanamadik, HTML KODLARİNİ inceleyince kullanmak istediğimiz webelementin
        bir iframe (gomulu HTML sayfa) icerisinde oldugunu belirledik bir iframe icerisindeki elementi kullanabilmek icin once o iframe'e gecis
        yapmamiz gerekir...

         */
        WebElement yazliElementi=driver.findElement(By.xpath("(//*[@id='sampleHeading'])[1]"));
        Assertions.assertTrue(yazliElementi.isDisplayed());

        //3) TOOLSQA logosunun gorunur oldugunu test
        driver.switchTo().defaultContent();
        WebElement toolQalogo=driver.findElement(By.xpath("//*[@src='/images/Toolsqa.jpg']"));
        Assertions.assertTrue(toolQalogo.isDisplayed()); //burda ust satırlarda iframe paralel evrenine geçtiğimiz için locate edemez
        //bundan geriye dönmek için ;
        // driver.switchTo.parentFrame();
        //ic ice birden fazla katman olarak iFrame 'ler varsa
        //bir üst katmana cikartir


        //driver.switchTo().defaultContent();
        //ic ice birden fazla katman olarak iFrame ler varsa
        //direk anasayfaya cikartir


//4 sayfadaki iframe sayısını yazdirin
        List<WebElement> iframeListesi=driver.findElements(By.tagName("iframe"));
        System.out.println("sayfadaki iframe sayisi: "+iframeListesi.size());



    }



















}
