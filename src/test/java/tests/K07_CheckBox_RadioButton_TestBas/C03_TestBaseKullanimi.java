package tests.K07_CheckBox_RadioButton_TestBas;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C03_TestBaseKullanimi extends TestBase_All {

    @Test
    public void test01(){
     driver.get("https://www.coolstoves.com");
        ReusableMethods.bekle(1);

    }

}
