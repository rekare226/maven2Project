package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

 //https://the-internet.herokuapp.com/windows adresine gidin
 driver.get("https://the-internet.herokuapp.com/windows");

 //sayfadaki textin "Opening a new window" oldugunu  dogrulayın

 WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualyazi=yaziElementi.getText();
        Assertions.assertEquals(expectedYazi,actualyazi);

 //sayfa baslıgının (title) "The Internet" oldugunu dogrulayın

        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);
        String ilkWindowWhd=driver.getWindowHandle();

 //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();


  /*
  driver.getWindowHandle();
  method'u icerisinde oldugu window'un window handle degerini bize getirir ve biz de kaydedebiliriz
  bir window'un whd'ini kaydettikten sonra nerde olursak olalım
  driver.switchTo().window(hedefWindowWHDi); ile bu window'a gecis yapabilir

  Kontrolsuz window acildiginda driver beklemedigi bir durum
  oldugundan  yeni window'a gecmez, eski window'a kalir
  yeni window'a gecemedigimiz icin yeni window'un whd'ini de alamayız

   */
        /*
        Yeni window un whdini bulmak için mini bir bulmaca çözmeliyiz
        Baslangicta alip kaydettiğimiz ilk window whd 'ini biliyoruz

        Acik olan tum windowlarin whd'lerini getWindowHandles() ile alip bir Set'e kaydedebiliriz
        Set'i bir for each loop ile gozden gecirip ilk window'un whd eşit olmayan elemani ikinci window'un whd 'i olarak alabilriz...




         */

        //whd'ini kaydedin ve yazdirin

        System.out.println("ilk windowhandle degeri"+ilkWindowWhd);
        System.out.println("click e bastiktan sonra driverin oldugu windowhandle degri"+driver.getWindowHandle());

        Set<String> acikTumWindowlarinWindowHandleDegerleriSeti=driver.getWindowHandles();
        System.out.println(acikTumWindowlarinWindowHandleDegerleriSeti);


        String ikinciWindowhandle="";
        for ( String eachWhd
                 : acikTumWindowlarinWindowHandleDegerleriSeti  ) {

            if (!eachWhd.equals(ilkWindowWhd)){
                ikinciWindowhandle=eachWhd;
            }
           }

        /*
        ilk window'un whd'ini en basta kaydetmistik
        simdi ikinci windowun whd'ine de sahibiz
        artik switchTo() ile istediğimiz window a gecis yapabiliriz

         */
        //Acilan yeni pencerenin sayfa baslıgının (title) "New Window" oldugunu test edin
        //yeni window kontrolsuz olarak açıldıgı için driverhala eski windowda yeniwindow ile ilgili islem yapmadan önce
        //driveri yeni window a gecirmeliyiz

        driver.switchTo().window(ikinciWindowhandle);
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

//sayfadaki textin "New Window " oldugunu dogrulayın
        yaziElementi=driver.findElement(By.tagName("h3"));
        expectedYazi="New Window";
        actualyazi=yaziElementi.getText();
        Assertions.assertEquals(expectedYazi,actualyazi);

        //birönceki pencereye geri dönun

        driver.switchTo().window(ilkWindowWhd);

        //sayfa baslıginin "New Window" oldugunu test edin
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);





    }



}
