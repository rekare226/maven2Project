package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_DropDownMenu extends TestBase_Each {


    @Test
    public void test02(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement optionDropDownMenuElementi= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(optionDropDownMenuElementi);

        //1. Index kullanarak Secenek 1'i (Option 1 ) secin ve yazdirin

        select.selectByIndex(1);
        System.out.println("indeks iel option 1"+select.getFirstSelectedOption().getText());

        //2. Value kullanarak Secenek 2'yi (Option 2 ) secin ve yazdirin
        select.selectByValue("2");

        //3. Visible Text (Gorunen metin) kullanarak Secenek 1'i (Option 1) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println("Visible test ile secenek 1 :"+select.getFirstSelectedOption().getText());

        //4. Tüm dropdown degerleri(value) yazdirin
            //1.yontem : WebElemet uzerinden olusturdugumuz optionDropDownMenuElementi .getText()
            //           menudeki tum ay isimlerini getirir

        System.out.println("WebElement ten tüm liste : "+optionDropDownMenuElementi.getText());

        //2. yöntem Reusable class daki String listeye cevirme method unu kullanarız

        System.out.println("Reusable method ile string liste yazdırma :"+ReusableMethods.stringListeDondur(select.getOptions()));

        //5. Dropdown'un boyutunun 4 oldugunu test edin

        int expectedMenuBoyutu=4;
        int actualMenuBoyutu=select.getOptions().size();
        Assertions.assertEquals(expectedMenuBoyutu,actualMenuBoyutu);

        ReusableMethods.bekle(1);

    }




        //5. Dropdown'un boyutunun 4 oldugunu test edin












}
