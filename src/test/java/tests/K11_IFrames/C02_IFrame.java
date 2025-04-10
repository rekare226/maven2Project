package tests.K11_IFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C02_IFrame extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur oldugunu test edin
        WebElement electronicsIFrame=driver.findElement(By.xpath("(//iframe)[1]"));
         driver.switchTo().frame(electronicsIFrame);

        WebElement electronicsProducts=driver.findElement(By.xpath("//*[.='Electronics Products']"));
        //NoSuchElementException

        Assertions.assertTrue(electronicsProducts.isDisplayed());

        //3-Dell bilgisayar urun isminin 'DELL Core 13 11th Gen' oldugunu test edin

        String expectedUrunIsmi="DELL Core I3 11th Gen";
        String actualUrunIsmi=driver.findElement(By.id("pictext1")).getText();
        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);


        //4- Sale Up To 50% yazisinin  gorunur oldugunu test edin
        //bu yazı anasayfada oldugu için
        //önce elektroniks iframe'inden anasayfaya geçiş yapmalıyız
        driver.switchTo().parentFrame();
        WebElement baslikElementi=driver.findElement(By.tagName("h2"));
        System.out.println("Baslik yazisi:"+baslikElementi.getText());//
        String expectedBaslikYazisi="Sale Up To 50%";
        String actualBaslikYazisi=baslikElementi.getText();
        Assertions.assertEquals(expectedBaslikYazisi,actualBaslikYazisi);

        //5-Fashion bolumundeki ilk urunu ismini locate edin
        //fashion bolumu ayri bir IFrame icerisinde oldugundan, once iFrame 'e gecis

        WebElement fasionIFrame=driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fasionIFrame);

        //şimdi ilk ürün ismini locate edin
        WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("(//p)[1]"));



        // ve ilk urun isminde  "Men Slim Fit" gectiğini test edin

        String expectedIsimIcerigi="Men Slim Fit";
        actualUrunIsmi=ilkUrunIsimElementi.getText();
        System.out.println(actualUrunIsmi);

Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));






    }













}
