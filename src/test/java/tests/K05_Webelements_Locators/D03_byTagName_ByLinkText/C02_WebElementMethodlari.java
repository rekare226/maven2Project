package tests.K05_Webelements_Locators.D03_byTagName_ByLinkText;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class C02_WebElementMethodlari {


        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //https://www.testotomasyonu.com/form adresine gidin
            driver.get("https://www.testotomasyonu.com/form");

            // Cinsiyet bölümünden size uygun radio button seçin
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
            WebElement erkekRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inlineRadio2")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", erkekRadioButton);
                 //erkekRadioButton.click();
            // İstediğiniz radio button'ın seçili olduğunu test edin

            if (erkekRadioButton.isSelected()) {
                System.out.println("Secim testi PASSED");
            } else {
                System.out.println("Secim testi FAILED");
            }

            // Sizin işaretlediğiniz dışındaki butonların seçili olmadığını test edin
            WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
            WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));
            if (!kadinRadioButton.isSelected()) {
                System.out.println("Kadın secim testi PASSED");
            }else System.out.println("Kadın secim testi FAILED");

            if (!digerRadioButton.isSelected())
            {System.out.println("diger secim testi PASSED");
            }else System.out.println("diger secim testi FAILED");

//            Secim testi PASSED
//            Kadın secim testi PASSED
//            diger secim testi PASSED

            // Soyisim kutusunun boyutlarını ve konumunu yazdırın

            WebElement soyIsimKutusu=driver.findElement(By.id("surname"));
            System.out.println("soyisim kutusu boyut"+ soyIsimKutusu.getSize());
            System.out.println("soyisim kutusu konum"+ soyIsimKutusu.getLocation());

            //soyisim kutusunun HTML kodundaki class attribute degerinin
            //form-control oldugunu test edin

            String expectedClassValue="form-control";
            String actualClassValue=soyIsimKutusu.getAttribute("class");

            if (expectedClassValue.equals(actualClassValue)) {

                System.out.println("attribute testi PASSED");

            }else System.out.println("attribute testi FAILED");
            // Sayfayı kapatın
            Thread.sleep(3000);
            driver.quit();
        }
    }


