package tests.K07_CheckBox_RadioButton_TestBas;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_RadioButton {

    //a. Verilen web sayfasina gidin
    // https://testotomasyonu.com/form
    //b.Cinsiyet Radio button elementlerini locate edin
    //c.Iki farkli test method u olusturup yazidan veya direk buton'dan size uygun olani secin
    //d.Sectiginiz radio button un secili, ötekilerin secili olmadiğini test edin

    static WebDriver driver;
   @BeforeAll
   public static void setup(){
      driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();

   }

   @AfterAll
   public static void teardown(){
       driver.quit();
   }



    @Test
    public   void yazidanSecimTesti(){
        //a. Verilen web sayfasina gidin
        // https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");
       //b.Cinsiyet Radio button elementlerini locate edin

        WebElement RaddioButtonKadın=driver.findElement(By.xpath("//*[@id='inlineRadio1']"));
        WebElement RaddioButtonErkek=driver.findElement(By.xpath("//*[@id='inlineRadio2']"));
        WebElement RaddioButtonDiger=driver.findElement(By.xpath("//*[@id='inlineRadio3']"));

        //c. yazidan  size uygun olani secin

        WebElement erkekButtonYaziElementi= driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",erkekButtonYaziElementi);
        ReusableMethods.bekle(1);

        //d.Sectiginiz radio button un secili, ötekilerin secili olmadiğini test edin
        Assertions.assertTrue(RaddioButtonErkek.isSelected());
        Assertions.assertFalse(RaddioButtonKadın.isSelected());
        Assertions.assertFalse(RaddioButtonDiger.isSelected());
        ReusableMethods.bekle(1);

    }

    @Test
    public  void butondanSecimTesti(){
        //a. Verilen web sayfasina gidin
        // https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        //b.Cinsiyet Radio button elementlerini locate edin
        WebElement RaddioButtonKadın=driver.findElement(By.xpath("//*[@id='inlineRadio1']"));
        WebElement RaddioButtonErkek=driver.findElement(By.xpath("//*[@id='inlineRadio2']"));
        WebElement RaddioButtonDiger=driver.findElement(By.xpath("//*[@id='inlineRadio3']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",RaddioButtonErkek);
        ReusableMethods.bekle(1);

        Assertions.assertTrue(RaddioButtonErkek.isSelected());
        Assertions.assertFalse(RaddioButtonDiger.isSelected());
        Assertions.assertFalse(RaddioButtonKadın.isSelected());


    }







}
