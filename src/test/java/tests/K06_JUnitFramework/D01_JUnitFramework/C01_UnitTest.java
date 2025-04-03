package tests.K06_JUnitFramework.D01_JUnitFramework;

import java.util.Random;

public class C01_UnitTest {
    public static void main(String[] args) {

        //verilen bir sayı 3 basamaklı pozitif bir sayı ise true
        //                 3 basamkli pozitif bir sayi degilse false
        // donduren bir method olusturun

        System.out.println(UcBasamakliSayiDondur(100));
        System.out.println(UcBasamakliSayiDondur(1000));
        System.out.println(UcBasamakliSayiDondur(-100));

        /*
        Bu methodu test etmek icin true veya false dondurmesi
        gereken sayi araliklarindan farkli testler yapmalıyız

        ornegin;
        -verilen sayi pozitif 3 basamakli sayi ise expectedSonuc=true
        -verilen sayi pozitif 100 den kucuk bir sayi ise expectedSonuc=false
        -verilen sayi pozitif 999 dan buyuk bir sayi ise expectedSonuc=false
        -verilen sayi negatif  bir sayi ise expectedSonuc=false





         */
uygunDegerTesti();
uygunOlamayanDegerTesti1();
uygunOlamayanDegerTesti2();
uygunOlamayanDegerTesti3();

    }

    public static boolean UcBasamakliSayiDondur(int sayi) {

        if (sayi >= 100 && sayi <= 999) return true;


        else return false;


    }

    public static void uygunDegerTesti() {

        //verilen sayi pozitif 3 basamaklı sayı ise expectedSonuc=true
        //100 ile 999 arasında

        Random random = new Random();
        int sayi = random.nextInt(899) + 100;
        boolean expectedSonuc = true;
        boolean actualSonuc = UcBasamakliSayiDondur(sayi);

        if (expectedSonuc == actualSonuc) {

            System.out.println("uygun deger testi PASSED");
        } else System.out.println("uygun deger testi FAILED");


    }

    public static void uygunOlamayanDegerTesti1() {

        // -verilen sayi pozitif 100 den kucuk bir sayi ise expectedSonuc=false
        //0-99 arsı

        Random random = new Random();
        int sayi = random.nextInt(98)+1;
        boolean expectedSonuc = false;
        boolean actualSonuc = UcBasamakliSayiDondur(sayi);

        if (expectedSonuc == actualSonuc) {

            System.out.println("uygun olmayan deger testi1 PASSED");
        } else System.out.println("uygun olmayan deger testi1 FAILED");

    }

    public static void uygunOlamayanDegerTesti2() {

        //  -verilen sayi pozitif 999 dan buyuk bir sayi ise expectedSonuc=false
        //999<

        Random random = new Random();
        int sayi = random.nextInt(100000000) + 1000;
        boolean expectedSonuc = false;
        boolean actualSonuc = UcBasamakliSayiDondur(sayi);

        if (expectedSonuc == actualSonuc) {

            System.out.println("uygun olmayan deger testi2 PASSED");
        } else System.out.println("uygun olmayan deger testi2 FAILED");


    }

    public static void uygunOlamayanDegerTesti3() {

        //  -verilen sayi pozitif 999 dan buyuk bir sayi ise expectedSonuc=false
        //999<

        Random random = new Random();
        int sayi = -1*random.nextInt(100000000);
        boolean expectedSonuc = false;
        boolean actualSonuc = UcBasamakliSayiDondur(sayi);

        if (expectedSonuc == actualSonuc) {

            System.out.println("uygun olmayan deger testi3 PASSED");
        } else System.out.println("uygun olmayan deger testi3 FAILED");


    }



    }