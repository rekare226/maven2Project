package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_DropDownMenu extends TestBase_Each {
    //1."http://zero.webappsecurity.com/" adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna "username" yazin
    //4. Password kutusuna "pasword" yazin
    //5.Sign in tusuna basin, back tusuna basarak sayfaya donun
    //6. Online banking menusunden Pay Bills sayfasina gidin


    //9."amount" kutusuna bir sayi girin
    //10."US Dollars" in secilmedigini test edin
    //11."Selected currency" butonu secin
    //12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
    //13."Foreign currency cash was successfully purchased" yazisinin ciktigini kontrol edin

    @Test
    public void test03(){
        //1."http://zero.webappsecurity.com/" adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        WebElement signinRadioButton=driver.findElement(By.xpath("//button[@id='signin_button']"));
        //2. Sign in butonuna basin
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",signinRadioButton);
        //3. Login kutusuna "username" yazin
        WebElement loginKutu=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutu.sendKeys("username");
        ReusableMethods.bekle(1);
        //4. Password kutusuna "password" yazin
        WebElement paswordKutu=driver.findElement(By.xpath("//input[@id='user_password']"));
        paswordKutu.sendKeys("password");
        //5.Sign in tusuna basin, back tusuna basarak sayfaya donun
        WebElement signInButton=driver.findElement(By.xpath("//input[@type='submit']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].click()",signInButton);
        ReusableMethods.bekle(1);
        //back tusuna basarak sayfaya donun
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin
        WebElement bankingMenu=driver.findElement(By.xpath("//strong[.='Online Banking']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",bankingMenu);
        WebElement payBills=driver.findElement(By.id("pay_bills_link"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",payBills);
        //7."Purchase Foreign Currency" tusuna basin
        WebElement purchaseForeignCurrency=driver.findElement(By.xpath("//a[.='Purchase Foreign Currency']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",purchaseForeignCurrency);
        //8."Currency" drop down menusunden Eurozone'u secin
        WebElement dropDownMenuCurrency=driver.findElement(By.id("pc_currency"));
        ReusableMethods.bekle(3);
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click()",dropDownMenuCurrency);
        Select selectCurency=new Select(dropDownMenuCurrency);
        selectCurency.selectByVisibleText("Eurozone (euro)");
        //9."amount" kutusuna bir sayi girin
        WebElement amountKutu=driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountKutu.sendKeys("200");
        //10."US Dollars" in secilmedigini test edin
        WebElement usDolarsRadioButton=driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usDolarsRadioButton.isSelected());
        // 11."Selected currency" butonu secin
        WebElement selectedCurrencyRadioButton=driver.findElement(By.id("pc_inDollars_false"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",selectedCurrencyRadioButton);
        ReusableMethods.bekle(2);
        //12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        ReusableMethods.bekle(1);
        driver.findElement(By.id("purchase_cash")).click();
        //13."Foreign currency cash was successfully purchased" yazisinin ciktigini kontrol edin
        String expectedYazi="Foreign currency cash was successfully purchased.";
        WebElement sonucYaziElementi=driver.findElement(By.id("alert_content"));
        //Assertions.assertTrue(driver.findElement(By.id("alert_content")).isDisplayed());
        String actualYazi=sonucYaziElementi.getText();
        Assertions.assertEquals(expectedYazi,actualYazi);






    }










}
