package tests.K04_WebDriverOlusturma.D02_farkliDriverKullanimi_drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManage_TimeOuts {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//bu dinamik bekleme süresidir




        Thread.sleep(10000);//mutlaktır her durumda 10 sn ye bekler
        driver.quit();

        /*
        Test otomasyonu bizim kodlarimizin bizim yerimize internette
        Web sayfalarinda islem yapmasidir

        Bizim yazdigimiz Java kodlarinin hizi ile
        1-bilgisayar
        2-internetimiz
        3-ve ulasmaya calistiğimiz sayfanin hizlari farkli olur

        Bu hizlar arasindaki fark kodlarimizin calismamasina veya testin FAILED olmasina sebep olur
        Dolayisiyla hata olan yerlere manuel olarak da bakarız sonra rapor ederiz


         */

        /*
        Thread.sleep(3000) java dan gelir ve mutlak bir bekleme suresidir
        icine yazilan sure boyunca kodlari bekletir
        ve alt satıra gecmez

        implicityWait(Duration.ofSeconds(10))
        ise Selenium dan gelir ve dinamiktir
        Yani 10 saniyeyi sonuna kadar kullanmaz,
        asil amac sayfanin acilmasi veya
        sayfada kullanacagimiz herhangi bir webelementin kullanilir

        10 saniye icerisinde sayfanin acilmasini
        veya kullanacagi webelementi bulmayı bekler
        10 saniye icerisinde Ne zaman islemi yapabilirse,
        daha fazla beklemez yoluna devam eder


        10 saniye beklemesine ragmen sayfa acilmaz ise aradigi webelementi bulmazsa
        exception fir
        firlatir ve calismayi durdurur...

         */



    }
}
