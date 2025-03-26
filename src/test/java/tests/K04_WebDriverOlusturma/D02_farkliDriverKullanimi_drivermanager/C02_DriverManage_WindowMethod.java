package tests.K04_WebDriverOlusturma.D02_farkliDriverKullanimi_drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverManage_WindowMethod {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //1.https://www.coolstoves.com/sayfasina gidin
        driver.get("https://www.coolstoves.com/");
        //2.Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Acilista konum "+driver.manage().window().getPosition());//Acilista konum (10, 10)
        System.out.println("Acilista boyut "+driver.manage().window().getSize());//Acilista boyut (1050, 718)
        Thread.sleep(2000);
        //3.Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //4.Simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //5.Sayfanin komumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maksimize konum "+driver.manage().window().getPosition());//Acilista konum (10, 10)
        System.out.println("Maximize boyut "+driver.manage().window().getSize());
        Thread.sleep(2000);
        //6.Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        //7.Sayfanin konumu ve boyutlarini fullscreen durumunda yazdırın
        System.out.println("Fullscreende konum "+driver.manage().window().getPosition());//Acilista konum (10, 10)
        System.out.println("Fullscreende boyut "+driver.manage().window().getSize());//Fullscreende boyut (1366, 768) çalışılan ekranın çözünürlüğünü verir
        Thread.sleep(2000);
        //8.Sayfanin konumunu pixel olarak (150,150) getirin
        driver.manage().window().setPosition(new Point(150,150));//Ozel boyutta konum (150, 150)

        //9.Sayfa boyutunu pixel olarak (1000,500) ye ayarlayin
        driver.manage().window().setSize(new Dimension(1000,500));//Ozel  boyut (1000, 500)
        System.out.println("Ozel boyutta konum "+driver.manage().window().getPosition());
        System.out.println("Ozel  boyut "+driver.manage().window().getSize());

        Thread.sleep(2000);
        driver.quit();
        //10.Sayfayi kapatin
    }
}
