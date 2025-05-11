public class Rekursion {
    static int counter = 0;

    public static void main(String[] args) {
        recours(counter);
    }

    public static void recours(int i) {
        if (counter < 10) {
            System.out.println(counter);
            recours(counter++);
        } else {
            System.out.println("The end");
        }
    }
}
