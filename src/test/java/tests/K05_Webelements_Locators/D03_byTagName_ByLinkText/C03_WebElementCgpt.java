package tests.K05_Webelements_Locators.D03_byTagName_ByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_WebElementCgpt {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Test otomasyonu form sayfasına git
        driver.get("https://www.testotomasyonu.com/form");

        // "Erkek" radio butonunu locate et ve tıkla
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement erkekRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("inlineRadio2")));
        //test ettiğimiz için kaydettik sadece click olsa idi kaydetmeye gerek olmayacaktı
        erkekRadio.click();
        Thread.sleep(3000);
        // Doğrulama: Seçili olup olmadığını kontrol et
        if (erkekRadio.isSelected()) {
            System.out.println("Erkek seçeneği başarıyla seçildi!");
        } else {
            System.out.println("Erkek seçeneği seçilemedi!");
        }

        WebElement kadinRadio = driver.findElement(By.id("inlineRadio1"));
        WebElement digerRadio = driver.findElement(By.id("inlineRadio1"));

        if (!kadinRadio.isSelected()) {
            System.out.println("kadin seçim testi PASSED");
        } else {
            System.out.println("kadin seçim testi FAILED");
        }

        if (!digerRadio.isSelected()) {
            System.out.println("diger seçim testi PASSED");
        } else {
            System.out.println("kadin seçim testi FAILED");
        }


        // Tarayıcıyı kapat (Opsiyonel)
        driver.close();
        driver.quit();











    }
}
