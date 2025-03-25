package tests.K04_WebDriverOlusturma.D01_WebDriverOlusturma_GetVeNavyGet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

        //bir test class ı olusturulduğunda ilk yapılması gereken şey bir WEBDRIVER edinmektir.....

        WebDriver driver= new ChromeDriver();

        driver.get("https://coolstoves.com");


        Thread.sleep(3000);
        driver.close();



    }
}
