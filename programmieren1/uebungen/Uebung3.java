package programmieren1.uebungen;

public class Uebung3 {

    public static void printTimesTables(int nr1, int nr2) {
        for (int i = 1; i <= nr1; i++) {
            for (int j = 1; j <= nr2; j++) {
                int res = i * j;
                System.out.printf("%d x %d = %d \n", i, j, res);
            }
            System.out.println();
        }
    }

    public static void printTimesMatrix(int nr1, int nr2) {
        for (int i = 1; i <= nr1; i++) {

            for (int j = 1; j <= nr2; j++) {
                System.out.print(i * j + " ");
            }

            System.out.println();
        }
    }

    public static void printTriangleUp(int height) {
        // 7->1
        for (int i = height; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // x <= y <= z und
    // x * y * z = 36
    public static void printCombination(int result) {

        int twoCombCounter = 0;
        int threeCombCounter = 0;
        for (int x = 0; x <= result; x++) {

            for (int y = 0; y < result; y++) {
                int res = x * y;
                if (res == 36) {
                    twoCombCounter += 1;
                    System.out.printf(" %d * %d = %d \n", x, y, res);
                }

                for (int z = 0; z < result; z++) {
                    int r = z * y * x;
                    if (r == 36) {
                        threeCombCounter += 1;
                        System.out.printf(" %d * %d * %d = %d \n", z, y, x, r);
                    }

                }
            }

        }
        System.out.printf("Two int combination - %d \nThree int combination - %d", twoCombCounter, threeCombCounter);
    }

    public static void printSeconds(int i) {
        // hours * min * sec
        int minInSec = 60;
        int hourInSec = 60 * minInSec;
        int dayInSec = 24 * hourInSec;
        int restInSec = i;

        int fullDaysSec = restInSec - restInSec % dayInSec;
        restInSec -= fullDaysSec;

        int fullHoursInSec = restInSec - restInSec % hourInSec;
        restInSec -= fullHoursInSec;

        int fullMinInSec = restInSec - restInSec % minInSec;
        restInSec -= fullMinInSec;

        System.out.println(fullDaysSec / dayInSec);
        System.out.println(fullHoursInSec / hourInSec);
        System.out.println(fullMinInSec / minInSec);
        System.out.println(restInSec);
    }
}
