package tests.K07_CheckBox_RadioButton_TestBas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_CheckBoxTesti {

    WebDriver driver;

    @BeforeEach //burada beforeEach secmemizin nedeni tek sayfaya gideceğimizden kaynaklı BeforeAll da secilebilirdi fakat methodlar static olmak durumunda kalırdı
    //yani tek adrese gidilecekse BeforeEach secilmesi daha mantıklı duruyor
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }



  @Test
  public void checkBoxTesti() throws InterruptedException {

      //a. verilen web sayfasina gidin.
      // https://testotomasyonu.com/form
driver.get("https://testotomasyonu.com/form");


      //b.Sirt Agrisi ve Carpinti checkbox'larini secin

      WebElement sirtAgrisiCheckBox=driver.findElement(By.xpath("//*[@id='gridCheck5']"));
      WebElement carpintiCheckBox=driver.findElement(By.xpath("//*[@id='gridCheck4']"));
      Thread.sleep(2000);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",sirtAgrisiCheckBox );
      Thread.sleep(2000);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",carpintiCheckBox);


//      WebElement element = driver.findElement(By.xpath("//*[@id='gridCheck5']"));
  // ((JavascriptExecutor) driver).executeScript("arguments[0].click();",sirtAgrisiCheckBox );


      //sirtAgrisiCheckBox.click();
     // carpintiCheckBox.click();


      //c.Sirt Agrisi ve Carpinti checkbox'larinin secili oldugunu test edin

      Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
      Assertions.assertTrue(carpintiCheckBox.isSelected());


      //Seker ve Epilepsi checkBox'larinin secili olmadigini test edin

      WebElement sekerCheckbox=driver.findElement(By.xpath("//*[@id='hastalikCheck2']"));
      WebElement epilepsiCheckbox=driver.findElement(By.xpath("//*[@id='hastalikCheck7']"));
      ReusableMethods.bekle(1);

Assertions.assertFalse(sekerCheckbox.isSelected());
Assertions.assertFalse(epilepsiCheckbox.isSelected());


  }






}
