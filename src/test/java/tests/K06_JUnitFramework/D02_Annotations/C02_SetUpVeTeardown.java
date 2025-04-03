package tests.K06_JUnitFramework.D02_Annotations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_SetUpVeTeardown {

    WebDriver driver;


    public void setup (){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown(){
        driver.quit();

    }

    @Test
    public  void testOtomasyonuTest()  {
         setup();

        driver.get("https://www.testotomasyonu.com/");
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {

            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        ReusableMethods.bekle(1);
         teardown();

    }
    @Test
    public  void wisequarterTesti()  {

       setup();
        driver.get("https://www.wisequarter.com/");

        String expectedUrlIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){

            System.out.println("Url icerik testi PASSED");
        }else System.out.println("Url icerik testi FAILED");

        ReusableMethods.bekle(1);

       teardown();

    }
    @Test
    public  void junitTesti(){
        setup();

        driver.get("https://junit.org/");

        String expectedUrl="https://junit.org/junit5/";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){

            System.out.println("JUnit url testi PASSED");
        }else System.out.println("JUnit url testi FAILED");

        ReusableMethods.bekle(1);
        teardown();

    }
}
