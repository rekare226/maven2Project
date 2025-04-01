package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


   //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   // 2-Add Element butonuna basin

        WebElement addRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='sub-btn']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addRadioButton);
       // driver.findElement(By.xpath("//[@id='sub-btn']"))
               // .click();


   // 3-Remove butonun'nun gotunur oldugunu test edin

     WebElement removeButton=driver.findElement(By.xpath("//button[@class='remove-btn']"));

     if (removeButton.isDisplayed()){

         System.out.println("remove butonu görünme testi PASSED");
     }else {

         System.out.println("remove butonu gorunme testi FAILED");

     }

   //4- Remove tusuna basin

        removeButton.click();
     Thread.sleep(2000);

   //5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin

        WebElement addRemoveElementsYazielementi= driver.findElement(By.xpath("//h2"));
      //  WebElement addRemoveElementsYazielementi= driver.findElement(By.tagName("h2")); burda ikinci bir yol olarak bu satırda denenebilir


        if (addRemoveElementsYazielementi.isDisplayed()){

            System.out.println("addremove testi passed");
        }else System.out.println("addremove testi failed");

   //6-sayfayi kapatın

        Thread.sleep(2000);
        driver.quit();







    }
}
