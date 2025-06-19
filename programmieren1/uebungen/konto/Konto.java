package programmieren1.uebungen.konto;

import java.util.Scanner;

public class Konto {
    private double kontostand; // guthaben
    final private int pin;
    private final double dispogrenze;
    Scanner sc = new Scanner(System.in);

    public Konto(int pin) {
        this.pin = pin;
        this.kontostand = 0.0;
        this.dispogrenze = -1000.0;
    }

    public void einzahlen(double betrag) {
        String kontoTyp;

        if (this.kontostand < 0) {
            kontoTyp = "auf Dispo";
        } else {
            kontoTyp = "auf Guthabekonto";
        }
        this.kontostand += betrag;
        System.out.printf("Es wurden %.2f Euro %s einbezahlt \n", betrag, kontoTyp);

    }

    public void kontoauszug(int pin) {
        if (pin != this.pin) {
            System.out.println("Zugang ist verboten! \nFalche PIN!");
        } else {
            System.out.printf("Ihr auktuelles Kontostand ist %.2f Euro\n", this.kontostand);
        }

    }

    private boolean nachfrage(String massage, double zahl) {
        System.out.printf(massage, zahl);
        String antwort = sc.nextLine().toLowerCase();
        sc.close();
        return antwort.contains("y");
    }

    public void auszahlen(int pin, double betrag) {
        if (pin != this.pin) {
            System.err.println("Falsche PIN");
        } else if (betrag <= this.kontostand) {
            this.kontostand -= betrag;
            System.out.printf("Es wird %.2f Euro von Guthaben ausbezahlt\n", betrag);
        } else if (betrag > this.kontostand) {
            double rest = this.kontostand - betrag;
            double zuVerfugung = rest < this.dispogrenze ? (-1 * this.dispogrenze) + this.kontostand : betrag;

            if (zuVerfugung > betrag) {
                String frage = "Ihr Guthaben reicht nicht. Wollen Sie Dispokonto verwenden, um %.2f abzuheben? Y/n\n";
                if (nachfrage(frage, betrag)) {
                    this.kontostand -= betrag;
                    System.out.printf("Nehmen Sie ihre %.2f Euro\n", betrag);
                } else {
                    System.out.println("Operation wurde beendet");
                }
            } else if (zuVerfugung < betrag) {
                String frage = "Ihr Beitrag ist zu hoch. Maximal ist %.2f Euro zu verfügung. Wollen Sie alle abheben? Y/n\n";
                if (nachfrage(frage, zuVerfugung)) {
                    this.kontostand -= zuVerfugung;
                    System.out.printf("Nehmen Sie ihre %.2f Euro\n", zuVerfugung);
                } else {
                    System.out.println("Operation wurde beendet");
                }
            }
        }
    }

    public void zinsenZahlen() {
        final double DISPOZINSEN = 12.0;
        final double GUTHABENZINSEN = 0.5;
        double zinsenSum;
        double zinsenProcent;
        String tad;

        if (this.kontostand > 0) {
            zinsenProcent = GUTHABENZINSEN;
            tad = "gutgeschrieben";
        } else {
            zinsenProcent = DISPOZINSEN;
            tad = "abgebucht";
        }

        zinsenSum = this.kontostand / 100 * zinsenProcent;
        this.kontostand += zinsenSum;
        System.out.printf("Ihnen wurden %.2f Euro Zinsen %s. ", zinsenSum, tad);
    }
}
