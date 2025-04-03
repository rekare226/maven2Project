package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C01_DropDownMenu extends TestBase_Each {
    //https://testotomasyonu.com/form adresine gidin.
    //1.Dogum tarihi gun seceneginden index kullanarak 5 i secin
    //2.Dogum tarihi ay seceneginden value kullanarak Nisan'i secin
    //3.Dogum tarihi yil seceneginden visible text kullanarak 1990 i secin
    //4.Secilen degerleri konsolda yazdirin
    //5.Ay dropdown menudeki tum degerleri (value) yazdırın
    //6.Ay Dropdown menusunun boyutunun 13 oldugunu test edin

    @Test
    public void test01(){

     //  https://testotomasyonu.com/form adresine gidin.

        driver.get("https://testotomasyonu.com/form");

     //1.Dogum tarihi gun seceneginden index kullanarak 5'i secin

              //1.adim:dropdown menuyu locate edip, bir webelement olarak class'da kaydedelim
        WebElement gunDropDownMenu=driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));


              //2.adim: bir select objesi olusturun ve parametre olarak kullanmak istediğiniz
             //         dropdown menuyu girin

        Select selectGun=new Select(gunDropDownMenu);


            //3.adim: olusturdugunuz selectGun objesi sayesinde
            //        Select class'indaki hazir method'lar ile istenen islemleri yapabiliriz

        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seceneğinden value kullanarak Nisan'i secin

        WebElement ayDropDownMenu=driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy=new Select(ayDropDownMenu);
        selectAy.selectByValue("nisan");

        //3.Dogum tarihi yil seceneginden visible text kullanarak 1990 i secin

        WebElement yilDropDownMenu=driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil=new Select(yilDropDownMenu);
        selectYil.selectByVisibleText("1990");

        //4.secilen degerleri consolde yazdirin

        System.out.println("Gun :"+selectGun.getFirstSelectedOption().getText());
        System.out.println("Ay :"+selectAy.getFirstSelectedOption().getText());
        System.out.println("Yil :"+selectYil.getFirstSelectedOption().getText());

        //5. Ay dropdown menudeki tum degerleri (value) yazdırın
        //Ay dropdown menusunde "Ocak" degerinin bulundugunu test edin

        //1.yontem : dropdown uzerinden olusturdugumuz selectAy.getText()
        //           menudeki tum ay isimlerini getirir

        System.out.println("Ay dropdown WebElement kullanarak tum Liste :\n"+ ayDropDownMenu.getText());
        Assertions.assertTrue(ayDropDownMenu.getText().contains("Ocak"));


        //2.yontem : tum opsiyonlarin yazilarini olusturdugumuz
        //           String bir listeye ekleyebiliriz
        //           sonra list.contains() ile testimizi yapabiliriz

        List<WebElement> ayDdmOptionElementleriList=selectAy.getOptions();
        List<String> ayDdmOptionIsimleriList=new ArrayList<>();

        for(WebElement eachElement:ayDdmOptionElementleriList){

           ayDdmOptionIsimleriList.add( eachElement.getText());

        }

        System.out.println("String option Listesi"+ ayDdmOptionIsimleriList);
        Assertions.assertTrue(ayDdmOptionIsimleriList.contains("Ocak"));


        //3. yontem Reusable class'indaki method'u kullanalim

        System.out.println("Hazır method ile ay listesi:"+ReusableMethods.stringListeDondur(ayDdmOptionElementleriList));
        Assertions.assertTrue(ReusableMethods.stringListeDondur(ayDdmOptionElementleriList).contains("Ocak"));

        ReusableMethods.bekle(1);

    }








}
