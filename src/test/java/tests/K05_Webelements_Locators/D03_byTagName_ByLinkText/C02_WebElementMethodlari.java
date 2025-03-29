package tests.K05_Webelements_Locators.D03_byTagName_ByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        //https://www.testotomasyonu.com/form adresine gidin

        driver.get("https://www.testotomasyonu.com/form");


        // Cinsiyet bolumunden size uygun radio button secin


      Thread.sleep(3000);
      WebElement erkekRadioButton=driver.findElement(By.id("inlineRadio2"));
        Thread.sleep(3000);

      erkekRadioButton.click();
        Thread.sleep(3000);


        //istediginiz radio button un secili oldugunu test edin


        //sizin isaretlediginiz disindaki butonların secili olmadigini test edin


        //soyisim kutusunun boyutlarini ve konumunu yazdirin


        //soyisim kutusunun HTML kodundaki class attribute degerinin
        //"form-control" oldugunu test edin


        //sayfayi kapatin

Thread.sleep(2000);
driver.quit();




    }
}
