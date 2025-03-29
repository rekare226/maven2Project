package tests.K05_Webelements_Locators.D02_byName_byClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_WebAppTesti {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class ı olusturun ilgili ayarlari yapın
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //2- http://zero.webappsecurity.com/ gidin
        driver.get("http://zero.webappsecurity.com/");
        //3-"ONLINE BANKING " linkine tiklayin
        //siteye gittik onlıne banking menusunun ustünde incele dedik ve
        //ıd onlıne banking menusu den onlıne banking menuyu arattık
        //iki tane çıktı ancak diğeri ıd olmadığından locate olarak
        //"onlıneBankingMenuyu" kullancağız.....
        driver.findElement(By.id("onlineBankingMenu")).click();

        //4- Resim altında 6 islem basligi oldugunu test edin
        List<WebElement> baslikElementleriList=driver.findElements(By.className("headers"));
        int expectedbaslikSayisi=6;
        int actualBaslikSayisi=baslikElementleriList.size();

        if (expectedbaslikSayisi==actualBaslikSayisi){

            System.out.println("baslik sayisi testi PASSED");
        }else System.out.println("baslik sayısı testi FAILED");

        //5- islem baslıklari içinde "Pay Bills" oldugunu test edin..
        //burada baslikElementlerilist te contains ile "Pay Bills" i aratabiliriz ancak ListWebElement içinde
        // string deger için sonuç false donecektir
        System.out.println(baslikElementleriList.contains("Pay Bills"));//false
        //===============1. Yöntem===================
        //herbir web elementi for loop ile gözden geçirilip bir flag ile istenen metne esit baslik varsa sonucu true olarak kaydederiz
        //==================2. Yöntem==========================
        //Bos bir string list olusturup for loop ile webElementler üzerindeki yazıları alıp String <Liste ekleriz ve
        // sonra aranab baslığın varlıgını test ederiz

    List<String> baslikMetinleri=new ArrayList<>();
    for ( WebElement eachElement
             :baslikElementleriList   ) {

        baslikMetinleri.add(eachElement.getText());
       }

        System.out.println("Baslik metin Listesi :"+baslikMetinleri);
    //Baslik metin Listesi :[Account Summary, Account Activity, Transfer Funds, Pay Bills, My Money Map, Online Statements]

String expectedBaslik="Pay Bills";

if (baslikMetinleri.contains(expectedBaslik)){

    System.out.println("Pay Bills testi PASSED");

}else System.out.println("Pay Bills testi FAILED");//Pay Bills testi PASSED





        Thread.sleep(2000);
        driver.quit();


    }
}
