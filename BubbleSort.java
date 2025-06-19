import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] myArray = new int[]{4, 57, 213, 31, 23, 45, 9, 21, 2, 3};
        int m = 1;

        for (int i = 0; i < myArray.length - m; i++) {

            if (myArray[i] > myArray[i + 1]) {
                int tmp = myArray[i];
                myArray[i] = myArray[i + 1];
                myArray[i + 1] = tmp;

                if (i == myArray.length - m - 1) {
                    i = -1;
                    m++;
                }
            }
        }

        System.out.println(Arrays.toString(myArray));

        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < myArray.length - 1; i++) {
                if (myArray[i] > myArray[i + 1]) {
                    int tmp = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.println(Arrays.toString(myArray));
    }
}
