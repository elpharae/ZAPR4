package pkg;

import java.util.Scanner;

public class Main {

    private Scanner vstup = new Scanner(System.in);

    // přidat počítadlo pokusů, aby se na konci šlo vypsat na kolikátý pokus - hotovo
    // přidat ukončení hry neúspěchem, pokud to nestihne za nějaký počet pokusů - hotovo
    private void guessMyNum(int pocetPokusu) {
        this.vstup = new Scanner(System.in);
        int pocitej = 0;
        int nahodneCislo = (int) (Math.random() * 100) + 1;

        System.out.print("Hádej číslo 1-100: ");
        int hadaneCislo = this.vstup.nextInt();

        System.out.println(nahodneCislo);

        while (hadaneCislo != nahodneCislo && ++pocitej < pocetPokusu) {
            System.out.print(hadaneCislo < nahodneCislo ? "Zkus větší číslo: " : "Zkus menší číslo: "); ;
            hadaneCislo = this.vstup.nextInt();
        }

        System.out.println(pocitej >= pocetPokusu ? "Prohrál jsi" : "Vyhrál jsi");
    }

    // přidat čekání na akci (zmáčknutí spouště) uživatele - hotovo
    // předělat magickou konstantu 6 na pojmenovanou konstantu a zkoušet hru s různými počty otvorů
    // ...v revolveru - hotovo
    // předělat hru na extrémnější variantu, kde se od druhého pokusu už netočí a jde se dál - hotovo
    private void russianRoulette(final int VELIKOST_BUBINKU) {
        int pocitej = 0;
        boolean hrajePocitac = true;
        int poziceKulkyVBubinku = (int) (Math.random() * VELIKOST_BUBINKU);
        int poziceBubinku = (int) (Math.random() * VELIKOST_BUBINKU);

        System.out.println("Roztočení bubínku... Cvak!");


        System.out.println("--- Kolo " + ++pocitej + " ---");
        System.out.println("Hraje PC");

        while (poziceKulkyVBubinku != poziceBubinku) {
            if (!hrajePocitac) {
                System.out.print("Zmáčkni spoušť");
                this.vstup.nextLine();
            }
            System.out.println("Nic!");
            ++poziceBubinku;

            if (poziceBubinku < 0) poziceBubinku = VELIKOST_BUBINKU - 1;
            if (poziceBubinku > VELIKOST_BUBINKU - 1) poziceBubinku = 0;

            System.out.println("--- Kolo " + ++pocitej + " ---");
            System.out.println((hrajePocitac = !hrajePocitac) ? "Hraje PC" : "Hraješ ty");
        }

        System.out.println("Bum!");
        System.out.println(hrajePocitac ? "Vyhrál jsi! :)" : "Prohrál jsi :(");

    }

    private Main() {
        //guessMyNum(15);
        russianRoulette(6);
    }

    public static void main(String[] args) {
        new Main();
    }
}
