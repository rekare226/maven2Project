package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_KontrolluWindowDegistirme extends TestBase_Each {

    //yeni bir class olusturun:Windowhandle

    //testotomasyonu anasayfa adresine gidin
    //Sayfanin window handle degerini String bir degiskene atayin
    //Sayfa title'nin "Otomasyon" icerdigini test edin
    //Yeni bir tab olusturup,acilan tab'da wisequarter.com adresine gidin
    //Sayfa title'nin "Wise Quarter" icerdigini test edin
    //yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //Sayfa title'nin "Walmart" icerdigini test edin
    //ilk acilan window'a donun ve testotomasyonu sayfasina dondugunuzu test edin

    @Test
    public void test01(){
    //testotomasyonu sayfasina gidin
    driver.get("https://www.testotomasyonu.com");
    //whd'ini kaydedin ve yazdirin
        String testotomasyonuWindowhd=driver.getWindowHandle();
        System.out.println("window handle degeri :"+testotomasyonuWindowhd);
        ReusableMethods.bekle(1);

    //yeni bir tab acip, yeni tab'da  wisequarter sayfasina gidin
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://wisequarter.com");

    //whd degerini kaydedin ve yazdırın
        String wiseQarterWindowhd=driver.getWindowHandle();
        System.out.println("wisequarter window handle degeri :"+wiseQarterWindowhd);
        ReusableMethods.bekle(1);

        System.out.println("Acik olan tum windowlarin whd'leri"+driver.getWindowHandles());

    //yeni bir window acarak,arabam.com sayfasina gidin
    driver.switchTo().newWindow(WindowType.WINDOW) ;
    driver.get("https://www.arabam.com");

    //whd'ini kaydedin ve yazdirin
        String arabamWhd=driver.getWindowHandle();
        System.out.println("arabam.com window handle degeri :"+arabamWhd);
        ReusableMethods.bekle(1);

        System.out.println("Acik olan tum windowlarin whd'leri"+driver.getWindowHandles());

    //wisequarter'in acik oldugu window'a donun
    //ve url'in wisequarter icerdigini test edin

    driver.switchTo().window(arabamWhd);
    String expectedUrlIcerik="wisequarter";
    String actualUrl=driver.getCurrentUrl();
    Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    ReusableMethods.bekle(1);

    //testotomasyonu'nun acik oldugu window'a donun
     driver.switchTo().window(testotomasyonuWindowhd);


    //ve url'in testotomasyonu icerdigini test edin
    expectedUrlIcerik="testotomasyonu";
    actualUrl=driver.getCurrentUrl();
    Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    ReusableMethods.bekle(1);

 /*
    Eger bize verilen gorevde yeni bir Tab veya yeni bir Window isteniyorsa
    driver.switchTo().newWindow(WindowType.TAB);
    driver.switchTo().newWindow(WindowType.WINDOW);
    ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak
    Eger testimiz sirasında birden fazla window aciliyorsa driveri istediğimiz
    window'un WindHandle degerini girmeliyiz driver.switchTo.window(wisequarterWhd);

    Eger birden fazla window aciyorsak ve geridönmemiz gerekecekse acilan
    her window'un window handle degerini kaydetmek faydali olacaktir.

     */











    }













}
