package programmieren1.uebungen.rectangle;

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(12, 18);
        Rectangle r3 = new Rectangle(40, 5);
        Rectangle r4 = new Rectangle(20, 10);
        Rectangle r5 = new Rectangle(11, 21);

        // System.out.printf("%n%n--------------- print()-Methode
        // -----------------%n%n");
        // r1.print();
        // r2.print();
        // r3.print();
        // r4.print();
        // r5.print();

        // System.out.printf("%n%n---------- printComparison()-Methode
        // ------------%n%n");
        // r1.printComparison(r2);
        // r1.printComparison(r3);
        // r1.printComparison(r4);
        // r1.printComparison(r5);

        r1.scale(2);
        r2.scale(2);
        r3.scale(2);
        r4.scale(2);
        r5.scale(2);
        r1.scale(10);
        r2.scale(10);
        r3.scale(10);
        r4.scale(10);
        r5.scale(10);
    }
}
