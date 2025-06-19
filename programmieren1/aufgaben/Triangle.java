package programmieren1.aufgaben;

public class Triangle {
    private final int a, b, c;

    public static void main(String[] args) {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(4, 4, 7);
        Triangle t3 = new Triangle(5, 5, 5);
        Triangle t4 = new Triangle(4, 5, 3);
        Triangle t5 = new Triangle(4, 3, 5);
        Triangle t6 = new Triangle(3, 4, 5);

        t1.print();
        t2.print();
        t3.print();
        t4.print();
        t5.print();
        t6.print();
    }


    public Triangle(int pa, int pb, int pc) {
        this.a = pa;
        this.b = pb;
        this.c = pc;
    }

    public boolean isRightAngled() {
//        a^2 + b^2 = c^2
        int aQ = this.a ^ 2;
        int bQ = this.b ^ 2;
        int cQ = this.c ^ 2;

        boolean acQ = aQ + cQ == cQ;
        boolean abQ = aQ + bQ == cQ;
        boolean bcQ = bQ + cQ == aQ;

        return acQ || abQ || bcQ;
    }

    public int circumference() {
        return this.a + this.b + this.c;
    }

    public double area() {
        double s = (double) (this.a + this.b + this.c) / 2;
        return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
    }

    public void print() {
        int umfang = circumference();
        double area = area();
        String isReckwinklig = this.isRightAngled() ? "rechtwinklig" : "nicht rechtwinklig";
        String typ;
        if (this.equilateral()) {
            typ = "gleichseitig";
        } else if (this.isosceles()) {
            typ = "gleichschenklig";
        } else {
            typ = "unregelmaessig";
        }

        String str = String.format("""
                Seiten          :a=%d, b=%d, c=%d,
                Umfang          :%d,
                Flaecheninhalt  :%.4f,
                Der Dreieck ist :%s,
                Das Dreieck ist :%s,
                
                """, this.a, this.b, this.c, umfang, area, typ, isReckwinklig);

        System.out.print(str);
    }

    public boolean equilateral() {
        return this.a == this.b && this.b == this.c;
    }

    public boolean isosceles() {
        return this.a == this.b || this.a == this.c || this.b == this.c;
    }

    public boolean sameCircumference(Triangle t) {
        //TODO
        return true;
    }

    public boolean isSmaller(Triangle t) {
        return this.area() < t.area();
    }

    public boolean isBigger(Triangle t) {
        return this.area() > t.area();
    }

    public boolean sidesAreEqual(Triangle t) {
        return t.circumference() == this.circumference();
    }
}









