package programmieren1.uebungen;

public class Uebung4 {

    public static boolean isPrime(int number) {
        boolean isTrue = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    public static void printPrimeNumbers(int maximum) {
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= maximum; i++) {
            if (isPrime(i)) {
                str.append(String.valueOf(i + " "));
            }
        }
        System.out.printf("In range from 1 to %d \nPrime numbers are: %s", maximum, str.toString());
    }

    public static int getSmallestDivider(int number) {
        if (isPrime(number) || number < 2) {
            return number;
        }
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                return i;
            }
        }
        return 0;
    }

    public static String createStringOfPrimeFactorization(int number) {
        int jetzigerWert = number;
        String result = "";

        while (jetzigerWert > 1) {
            int gsd = getSmallestDivider(jetzigerWert);

            if (jetzigerWert == gsd) {
                result += gsd + " = " + number;
                break;
            }

            result += gsd + " * ";
            jetzigerWert /= gsd;
        }
        return result;
    }

    public static String crossSum(int i) {
        String str = String.valueOf(i);
        int strLength = str.length();
        int qSumme = 0;

        for (int j = 0; j < strLength; j++) {
            char c = str.charAt(j);
            qSumme += Character.getNumericValue(c);
        }

        return String.format(" Die Quersumme von %d ist %d.", i, qSumme);
    }


}
