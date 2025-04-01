package tests.K05_Webelements_Locators.D05_RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1- https://testotomasyonu.com/relativeLocators adresine gidin

        driver.get("https://testotomasyonu.com/relativeLocators");

        //2-DSLR Camera'yi etrafindaki elementleri kullanarak

        // 3 farkli relative locator ile locate edip tikalyın

        /*
        1- Relative locator kullanmak icin öncelikle hedef webelement'e
        ait bir özelliği bulmamız gerekir...bunun icin locate edecek gibi webelementi inceleyelim

        <a id="pictext7" class="overlay" href="https://testotomasyonu.com/product/32">
        <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pex
        <Span>DSLR Camera</span></a>

/*

<img class="lazy" data-original="https://www.testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="" title=""
src="https://www.testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png">
         */

        WebElement motorTelefonElementi= driver.findElement(By.id("pic8_thumb"));

        //3-Farkli relative locator ile locate edip tiklayin

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dslrCamera1 = driver.findElement(RelativeLocator.with(By.className("overlay")).toLeftOf(motorTelefonElementi));

        js.executeScript("arguments[0].click();", dslrCamera1);




//3) acilan urunun DSLR Camera oldugunu test edin
        WebElement dslrCameraIsimElementi=driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String expectedUrunIsmi="DSLR Camera";
        String actualUrunIsmi=dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){

            System.out.println("DSLR Camera 1. test PASSED");
        }else System.out.println("DSLR Camera 1. test FAILED");



        //2. olarak Apple kulaklıgin saginda diye relative locater kullanalım

        driver.get("https://testotomasyonu.com/relativeLocators");
        WebElement appleKulaklık =driver.findElement(By.id("pic6_thumb"));

        JavascriptExecutor jsv = (JavascriptExecutor) driver;
        WebElement dslrCamera2=

                driver.findElement(RelativeLocator.with(By.className("overlay")).toRightOf(appleKulaklık));
        jsv.executeScript("arguments[0].click();", dslrCamera2);

        dslrCameraIsimElementi=driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        actualUrunIsmi=dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){

            System.out.println("DSLR camera2 testi PASSED");

        }else System.out.println("DSLR camera2 testi FAILED");

        /*
        StaleElementReferenceException
        Bir web sayfasindaki elementi locate ettikten sonra
        başka sayfalara gidilip yeniden locate ettiğimiz webelementin oldugu sayfaya dönersek
        driver daha önceden locate elementlerin aynı kaldığından emin omak ister ;bu yüzden elementi
        bulamadığı anlamına gelen "NoSuchElementExcepiton (Elementi bulamadım) demiyor

        onun yerine StaleElementReferenceException (bu webelementi locate etmiştik ama ustunden cok zaman gecti  stale yani bayatladı ) diyor
        StaleElementReferenceException karsilasinca daha once locate edip kaydettiğimiz
        webelement'e yeniden deger atamasi yapmamiz gerekir...

         */

        //3.olarak Bat kulaklıgın altında diye relative locator kullanalım

        driver.get("https://testotomasyonu.com/relativeLocators");
        WebElement batKulaklik =driver.findElement(By.id("pic2_thumb"));
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        WebElement dslr3=driver.findElement(RelativeLocator.with(By.id("pictext7")).below(batKulaklik));
        //jsv.executeScript("arguments[0].click();", dslrCamera2);
        js3.executeScript("arguments[0].click();",dslr3);

     Thread.sleep(2000);
        dslrCameraIsimElementi=driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        actualUrunIsmi=dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){

            System.out.println("DSLR camera3 testi PASSED");

        }else System.out.println("DSLR camera3 testi FAILED");

     Thread.sleep(1000);
     driver.quit();


    }
}
