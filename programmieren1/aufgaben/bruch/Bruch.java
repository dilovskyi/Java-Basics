package programmieren1.aufgaben.bruch;

import java.util.ArrayList;

public class Bruch {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public Bruch() {
        this.zaehler = 1;
        this.nenner = 1;
    }

    public String toString() {
        return this.zaehler + "/" + this.nenner;
    }

    private Bruch plusOrMinus(Bruch b, String operation) {

        int n1 = this.nenner;
        int n2 = b.nenner;
        int gemeinsameNenner = this.kgV(n1, n2);
        int z1 = gemeinsameNenner / n1 * this.zaehler;
        int z2 = gemeinsameNenner / n2 * b.zaehler;
        int neuerZaehler = 1;

//TODO switch - case

        if (operation.contains("+")) {
            neuerZaehler = z1 + z2;
        } else if (operation.contains("-")) {
            neuerZaehler = z1 - z2;
        }

        int ggT = ggT(neuerZaehler, gemeinsameNenner);
        return new Bruch(neuerZaehler / ggT, gemeinsameNenner / ggT).kuerzen();
    }

    private Bruch malOderGeteilt(Bruch b, String operation) {
        int newZaehler = 0;
        int newNenner = 0;

        if (operation.contains("*")) {
            newZaehler = this.zaehler * b.zaehler;
            newNenner = this.nenner * b.nenner;
        } else if (operation.contains("/")) {
            newZaehler = this.zaehler * b.nenner;
            newNenner = this.nenner * b.zaehler;
        }

        return new Bruch(newZaehler, newNenner).kuerzen();
    }

    public Bruch plus(Bruch b) {
        return this.plusOrMinus(b, "+");
    }

    public Bruch minus(Bruch b) {
        return this.plusOrMinus(b, "-");
    }

    public Bruch mal(Bruch b) {
        return this.malOderGeteilt(b, "*");
    }

    public Bruch geteilt(Bruch b) {
        return this.malOderGeteilt(b, "/");
    }

    public Bruch kuerzen() {
        int ggT = this.ggT(this.zaehler, this.nenner);
        return new Bruch(this.zaehler / ggT, this.nenner / ggT);
    }

    public int ggT(int zahl1, int zahl2) {
        ArrayList<Integer> z1 = aufPrimZerlegen(zahl1);
        ArrayList<Integer> z2 = aufPrimZerlegen(zahl2);

        int ggT = 1;
        // Проходим по всем элементам первого списка
        for (int i = 0; i < z1.size(); i++) {
            int prim = z1.get(i);

            // Если число есть и в втором списке - перемножаем
            if (z2.contains(prim)) {
                ggT *= prim;
                z2.remove((Integer) prim); // Удаляем число, чтобы избежать дублирования
            }
        }
        return ggT;
    }

    private int kgV(int zahl1, int zahl2) {
        ArrayList<Integer> z1 = aufPrimZerlegen(zahl1);
        ArrayList<Integer> z2 = aufPrimZerlegen(zahl2);

        int kgV = 1;

        // Добавляем все множители из z1 в kgV
        for (int prim : z1) {
            kgV *= prim;
        }
        // Добавляем оставшиеся множители из z2 (те, которые еще не учтены)
        for (int prim : z2) {
            if (z1.contains(prim)) {
                z1.remove((Integer) prim); // Убираем один раз, чтобы не дублировать
            } else {
                kgV *= prim; // Если числа нет в z1, умножаем его
            }
        }
        return kgV;
    }

    private ArrayList<Integer> aufPrimZerlegen(int zahl) {
        ArrayList<Integer> zArr = new ArrayList<>();
        int z = zahl;

        for (int i = 2; i <= zahl; i++) {
            while (z % i == 0 && isPrim(i)) {
                zArr.add(i);
                z /= i;
            }
            if (z == 1) break;
        }
        return zArr;
    }

    public boolean isPrim(int zahl) {
        if (zahl < 2) return false; // 1 и меньше — не простые
        for (int i = 2; i * i <= zahl; i++) { // Оптимизировано: проверяем до √zahl
            if (zahl % i == 0) return false;
        }
        return true;
    }
}