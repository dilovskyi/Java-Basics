package programmieren1.aufgaben.bruch;

public class BruchMain {
    public static void main(String[] args) {
        Bruch b1 = new Bruch(3, 7);
        Bruch b2 = new Bruch(4, 8);
        Bruch b3 = new Bruch(2, 5);
        Bruch b4 = new Bruch(50, 5);
        Bruch b5 = new Bruch();

        System.out.printf("%n%n------------------------- Rechnen -----------------------------------%n%n");
        System.out.printf("%5s + %5s = %5s %n", b1.toString(), b2.toString(), b1.plus(b2).toString());
        System.out.printf("%5s - %5s = %5s %n", b3.toString(), b4.toString(), b3.minus(b4).toString());
        System.out.printf("%5s * %5s = %5s %n", b1.toString(), b3.toString(), b1.mal(b3).toString());
        System.out.printf("%5s / %5s = %5s %n", b2.toString(), b1.toString(), b2.geteilt(b1).toString());
        System.out.printf("%5s + %5s = %5s %n", b5.toString(), b4.toString(), b5.plus(b4).toString());
        System.out.printf("%5s - %5s = %5s %n", b1.toString(), b1.toString(), b1.minus(b1).toString());     // nenner sollte ungleich 0 bleiben!
    }
}
