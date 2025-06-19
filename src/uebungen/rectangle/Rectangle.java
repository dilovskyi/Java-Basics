package uebungen.rectangle;

public class Rectangle {
    private int a;
    private int b;

    Rectangle() {
        this.a = 10;
        this.b = 20;
    }

    Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int area() {
        return this.a * this.b;
    }

    public int perimeter() {
        return this.a * 2 + this.b * 2;
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    public void scale(int factor) {
        double newA = Math.sqrt(factor * this.a * this.a);
        double newB = Math.sqrt(factor * this.b * this.b);
        double newArea = factor * this.area();
        System.out.println();
        System.out.printf("newArea=  %.2f newA= %.2f newB= %.2f check (newA*newB)= %.2f\n", newArea, newA, newB, newA * newB);
    }

    public String toString() {
        return String.format("Rectangle: ( a=%d, b=%d, area=%d, perimeter=%d, diagonal=%.3f )"
                , this.a, this.b, this.area(), this.perimeter(), this.diagonal());
    }

    public void print() {
        System.out.println(this.toString());
    }

    public boolean sidesAreEqual(Rectangle r) {
        return this.a == r.a || this.a == r.b && this.b == r.a || this.b == r.b;
    }

    public boolean areasAreEqual(Rectangle r) {
        return this.area() == r.area();
    }

    public boolean perimetersAreEqual(Rectangle r) {
        return this.perimeter() == r.perimeter();

    }

    public void printComparison(Rectangle r) {
        String thisR = this.toString();
        String thatR = r.toString();

        String sidesAreEqual = this.sidesAreEqual(r) ? "are equal" : "are not equal";
        String areasAreEqual = this.areasAreEqual(r) ? "are equal" : "are not equal";
        String perimetersAreEqual = this.perimetersAreEqual(r) ? "are equal" : "are not equal";

        System.out.printf("this   %s \n" +
                "the other  %s\n" +
                "sides : %s\n" +
                "areas : %s\n" +
                "perimeters : %s\n", thisR, thatR, sidesAreEqual, areasAreEqual, perimetersAreEqual);
        System.out.println();
    }
}
