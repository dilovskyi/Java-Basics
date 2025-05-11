import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {

    public static void main(String[] args) {

        // Runnable () -> {...} - Runnable – einfach etwas tun
        Runnable run = () -> {
            System.out.println("Hi");
        };
        run.run();

        // Supplier<T> () -> T - etwas liefern (kein Parameter, Rückgabe)
        Supplier<String> lieferName = () -> "Dima";
        System.out.println(lieferName.get()); // Ausgabe: Dima

        // Consumer<T> x -> {...} - etwas nehmen, aber nichts zurückgeben
        Consumer<String> drucke = name -> System.out.println("Hallo, " + name);
        drucke.accept("Dima"); // Ausgabe: Hallo, Dima

        // Function<T,R> x -> return r - etwas umwandeln
        Function<String, Integer> laenge = s -> s.length();
        System.out.println(laenge.apply("Dima")); // Ausgabe: 4

        // Predicate<T> x -> true/false - etwas prüfen (true/false)
        Predicate<String> istLang = s -> s.length() > 5;
        System.out.println(istLang.test("Hallo")); // false
        System.out.println(istLang.test("Programmierer")); // true
    }
}
