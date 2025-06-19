package uebungen.konto;

public class KontoMain {
    public static void main(String[] args) {

        Konto konto = new Konto(1234);
        konto.einzahlen(450);
        konto.auszahlen(1234, 1560);
        konto.kontoauszug(1234);
        konto.zinsenZahlen();
        konto.kontoauszug(1234);
    }
}
