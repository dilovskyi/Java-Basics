
@FunctionalInterface
interface BegruessungInferface {
    void sagHallo();
}

abstract class BegruesseungClass {
    abstract void sagEtwas();
}

abstract class SuperClass extends BegruesseungClass implements BegruessungInferface {
    abstract void sagBye();
}

public class AnonymeKlassen {

    public static void main(String... args) {

        // Lambda expression;
        BegruessungInferface c = () -> {
            System.out.println("Hallo, Dima!");
        };
        c.sagHallo();

        BegruesseungClass b = new BegruesseungClass() {
            @Override
            public void sagEtwas() {
                System.out.println("Hallo, Dima!");
            }
        };
        b.sagEtwas();

        SuperClass supClass = new SuperClass() {

            @Override
            void sagBye() {
            }

            @Override
            void sagEtwas() {
            }

            @Override
            public void sagHallo() {
            }
        };
    }
}