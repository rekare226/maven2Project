package tests.K04_WebDriverOlusturma.D02_farkliDriverKullanimi_drivermanager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_FarkliWebDriverKullanma {
    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.coolstoves.com");


        Thread.sleep(2000);
        driver.quit();



    }
}
