package tests.K06_JUnitFramework.D03_Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C02_AssertionsMethodlari {

    /* */

    int a = 10;
    int b = 20;
    int c = 30;

    String url1="https://testotomasyonu.com";
    String url2="https://testotomasyonu.com/";

    @Test
    public void test01() {

        // c'nin a ile b'nin toplamına esit oldugunu test edin

        Assertions.assertEquals(c, a + b);
    }

    @Test
    public void test02() {

        // c'nin a ile b'nin toplamına esit oldugunu test edin

        Assertions.assertTrue(c==a+b);
        //assertTrue()' can be simplified to 'assertEquals()
    }

    @Test
    public void test03() {

        // b'nin a ile c'nin toplamına esit oldugunu test edin

        Assertions.assertEquals(b, a + c);

    }

    @Test
    public void test04() {

        // b'nin a ile c'nin toplamına esit olmadığını test edin

        Assertions.assertNotEquals(b,a+c);

    }


    @Test
    public void test05() {

        // url1 ile url2 nin aynı oldugunu test edin

        Assertions.assertEquals(url1,url2);

    }

    @Test
    public void test06() {

        // url1 ile url2 nin aynı olmadıgını test edin

        Assertions.assertNotEquals(url1,url2);

    }


    @Test
    public void test07() {

        // url1'in "test" kelimesi icerdiğini test edin

        Assertions.assertTrue(url1.contains("test"));

    }

    @Test
    public void test08() {

        // url1'in "best" kelimesi icermediğini test edin

        Assertions.assertFalse(url1.contains("best"));

    }





    }


















