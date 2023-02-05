package proje;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OkulMain {
     /*
    1- Değişkenleri ad, soyad, yaş olan bir Ogrenci pojo class'ı oluşturunuz.
     2- Değişkenleri okulAd, maxOgrenciSayisi, ArrayList cinsinden Öğrencileri olan bir Okul pojo class oluşturunuz
     3- Main metodunun olduğu OkulMain isimli bir class oluşturunuz.
     4- Bir okul objesi oluşturup, bu okula max öğrenci miktarına ulaşana kadar öğrenci ekleyiniz.
        Fakat oluşturacağınız öğrencilerin yaşı 15'i geçmemeli, 8'den küçük olmamalı.
        Bu yaşı geçen bir öğrenci eklenmek istenir ise yerine başka öğrenci isteyiniz.
        //Her class bir data tipidir.
     */

    //Playing old java object POJO: depo class'i gibi

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Okul okul = new Okul();

        System.out.println("Okul adini giriniz");
        okul.setOkulAdi(scanner.next());

        System.out.println("Maximum ogrenci sayisini giriniz");
        okul.setMaxOgrenciSayisi(scanner.nextInt());

        List<Ogrenci> ogrenciListesi = new ArrayList<>();

        for (int i = 1; i <= okul.getMaxOgrenciSayisi(); i++) {
            scanner.nextLine(); //dummy sscanner
            Ogrenci ogrenci = new Ogrenci();

            System.out.println(i + ". ogrenci ad: ");
            ogrenci.setAd(scanner.nextLine());

            System.out.println(i + ". ogrenci soyad: ");
            ogrenci.setSoyAd(scanner.nextLine());

            System.out.println(i + ". ogrenci yas: ");
            try {
                ogrenci.setYas(scanner.nextInt());
                if (ogrenci.getYas() < 8 || ogrenci.getYas() > 15) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException exception) {
                System.out.println("Ogrenci yasi 8 ile 15 araliginda olmalidir");
                i--;
                continue;

            } catch (Exception exception) {
                System.out.println("Gecerli bir 'SAYI' giriniz");
                i--;
                continue;
            }


            okul.addOgrenciToList(ogrenci);

            System.out.println(okul.getOgrenciListesi());
        }
        System.out.println(okul);


    }

}

