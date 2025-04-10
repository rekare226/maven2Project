package tests.K09_JsAllerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_HTML_Alerts extends TestBase_Each {
   @Test
   public void test01(){

       driver.get("https://www.hurriyet.com");

       //cookies kabul edin
       ReusableMethods.bekle(5);
       driver.findElement(By.id("onetrust-accept-btn-handler"))
               .click();
       ReusableMethods.bekle(1);



   }















}
