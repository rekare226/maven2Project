package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_AyniWindowdaGezinme extends TestBase_Each {
    @Test
    public void test01(){
      //1-testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");
      // 2-windowhandle degerini ve url'i yazdirin
        System.out.println("testotomasyonu url :"+driver.getCurrentUrl());
        System.out.println("window handle degeri :"+driver.getWindowHandle());
        ReusableMethods.bekle(1);
        //3-Electronics linkini tiklayin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();
        //testotomasyonu url :https://www.testotomasyonu.com/
        //window handle degeri :BD3511E2AF9D25E5EE1B82BCBDA2C0F5
        //windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics url :"+driver.getCurrentUrl());
        System.out.println("window handle degeri :"+driver.getWindowHandle());
        ReusableMethods.bekle(1);
        //Electronics url :https://www.testotomasyonu.com/category/7/products
        //window handle degeri :BD3511E2AF9D25E5EE1B82BCBDA2C0F5

        //4- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //windowhandle degerini ve url'i yazdirin
        System.out.println("ilkurun url :"+driver.getCurrentUrl());
        System.out.println(" ilk urun window handle degeri :"+driver.getWindowHandle());
        ReusableMethods.bekle(1);

        //account linkine tikalayin
        driver.findElement(By.xpath("(//*[@class='menu-icon-text'])[1]")).click();

        // windowhandle degerini ve URL 'i yazdirin
        System.out.println("account url :"+driver.getCurrentUrl());
        System.out.println(" account window handle degeri :"+driver.getWindowHandle());
        ReusableMethods.bekle(1);
        //account url :https://www.testotomasyonu.com/customer-login
        // account window handle degeri :96AFF719DA897D47ED618075379F3840















    }
}
