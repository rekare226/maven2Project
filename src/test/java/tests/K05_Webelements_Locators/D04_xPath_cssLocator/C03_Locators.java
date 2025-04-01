package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //2- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com/");


      // 3-Browseri max sayfa yapın

        driver.manage().window().maximize();


      // 4-sayfayi refresh yapın

        driver.navigate().refresh();


      //5-sayfa baslıgının "test otomasyonu" ifadesi icerdigini test edin
        String expectedTitle="Test Otomasyonu";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitle)){

            System.out.println("Title içerik testi PASSED");
        }else System.out.println("Title içerik  testi FAILED");


      //6-Furnuture linkine tıklayın
driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

//7- price range filtressinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minFiyatKutusu=driver.findElement(By.xpath("//*[@class='form-control minPrice']"));
        minFiyatKutusu.clear();
        minFiyatKutusu.sendKeys("40");

        WebElement maxFiyatKutusu=driver.findElement(By.xpath("//*[@class='form-control maxPrice']"));
        maxFiyatKutusu.clear();
        maxFiyatKutusu.sendKeys("200");

        //filtrele butonuna basalim

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement filtreleButonu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='price-range-button']")));
        filtreleButonu.click();

        //8-Filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList=driver.findElements(By.className("prod-img"));

        int actualUrunSayisi=bulunanUrunElementleriList.size();

        if (actualUrunSayisi>0){

            System.out.println("urun filtreleme testi PASSED");
        }else System.out.println("urun filtreleme testi FAILED");




        //9-Ilk urunu tiklayin

bulunanUrunElementleriList.get(0).click();

//10- ilk urunun 40 ile 200 arasında oldugunu test edin
        WebElement ilkurunFiyatElementi= driver.findElement(By.id("priceproduct"));
        String ilkUrunFiyatıStr=ilkurunFiyatElementi.getText();

        ilkUrunFiyatıStr=ilkUrunFiyatıStr.replaceAll("\\D","");//"5000"
        double ilkUrunFiyatıDbl=Double.parseDouble(ilkUrunFiyatıStr)/100;//50.00

        if (ilkUrunFiyatıDbl>=40&&ilkUrunFiyatıDbl<=200){

            System.out.println("ilk urun fiyatı testi PASSED");

        }else System.out.println("ilk urun fiyatı testi FAILED");


/*
Bir HTML element acilan sayfada asagıda kaldigi icin ilk acilan bolumde
gorunmuyorsa o webElementi kullanip kullanmayacagimiz TAMAMEN sayfayi
tasarlayanların yazmıs oldukları koda baglidir bazi sayfalarda alt
taratafta kalan HTML elementler kullanılabilirken bazi sayfalarda
kullanilamayabilir

Actions actions=new Actions(driver);
action.sendKeys(Keys.PAGE_DOWN).perform();


 */




        Thread.sleep(2000);
        driver.quit();




    }
}
