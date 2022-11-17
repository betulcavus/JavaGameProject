package Game;

import java.util.Scanner;

public class Game {

    static int oyuncu=1;
    static int puan1=0;
    static int puan2=0;
    static String kelime="";
    static  String ekleme="";
    static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(oyuncu+".oyuncu bir kelime giriniz");
        kelime=input.next();

        oyuncuDegistir();
        onaySor();

    }

    public static void onaySor() {

        System.out.println("Girilen kelime "+kelime);
        System.out.println(oyuncu+" .oyuncu girilen kelimeyi kabul ediyormusunuz: \n 1: Evet \n 0 Hayir");

        int kabul=input.nextInt();
        if(kabul==1) {
            if(oyuncu==1){
                puan2+=kelime.length();
            }else
                puan1+=kelime.length();
            oyunaDevamEdecekMi();
        }else oyunuBitir();

    }

    private static void oyunaDevamEdecekMi() {

        System.out.println("oyuna devam etmek istiyormusunuz 1: Evet 0: Hayir");
        int tercih=input.nextInt();
        if(tercih==1) {
            kelimeEkle();
        }else {
            System.out.println("Oyun Bitti");
            System.out.println("1.oyuncu puani "+puan1);
            System.out.println("2.oyuncu puani "+puan2);
            if(puan1>puan2){
                System.out.println("Kazanan 1.oyuncu");
            }else if(puan2>puan1){
                System.out.println("Kazana 2.oyuncu");
            }else
                System.out.println("Oyun berabere");
        }
    }

    private static void kelimeEkle() {

        System.out.println("Eski kelimeye eklenecek str giriniz");
        ekleme=input.next();
        System.out.println("Yeni str'i basa mi sona mi ekleyelim ?\n 1: basa ekle 0: sona ekle");

        int tercih=input.nextInt();
        if(tercih==1) {
            kelime = ekleme + kelime;
        }else kelime=kelime+ekleme;
        oyuncuDegistir();
        onaySor();

    }

    private static void oyunuBitir() {
        System.out.println("Oyunu "+oyuncu+" .oyuncu kazandi ");
    }

    public static void oyuncuDegistir() {
        if(oyuncu==1){
            oyuncu=2;
        }else
            oyuncu=1;
    }


}
