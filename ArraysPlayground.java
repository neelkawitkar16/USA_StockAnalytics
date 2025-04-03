import java.util.Arrays;

public class ArraysPlayground {
    public static void main(String[] args) {
        char[] characterArray = new char[]{'n','e','e','l'};
        System.out.println("First element of char array is " + characterArray[0]);

        int[] intergerArray = new int[]{10,20,30};
        System.out.println("Third element of int array: " + intergerArray[2]);

        long[] longArray = new long[]{1232332,45464564,45645646,44566456,464564646};
        System.out.println("Third element of long array: " + longArray[2]);

        float[] floatArray = new float[]{12.2f,3.5f,45.5f};
        System.out.println("Third element of float array: " + floatArray[2]);

        floatArray[1] = 16.1997f;
        System.out.println("Changed value in float array at position 2 is: " + floatArray[1]);

        String[] stringName = new String[]{"Neel", "Kawitkar"};
        System.out.println("Second element of string is: " + stringName[1]);

        //for loop
        for (int i = 0; i < intergerArray.length; i++) {
            System.out.println(i + "th Element of the integer array is: " + intergerArray[i]);
        }

        System.out.println("The int Array element are: " + Arrays.toString(intergerArray));


        for (int i = 0; i < intergerArray.length - 1; i++) {
            for (int j = 0; j < intergerArray.length ; j++) {
                if(intergerArray[i]>intergerArray[j]) {
                    int temp = intergerArray[i];
                    intergerArray[i] = intergerArray[j];
                    intergerArray[j] = temp;
                }
            }
        }

        System.out.println("The updated Array is: " + Arrays.toString(intergerArray));

        for (int abc: intergerArray) {
            System.out.println("Nxt value is: " +abc);
        }

        int sum = 0;

        for (int temp: intergerArray) {
            sum = sum+temp;
        }
        System.out.println("The sum is: "+sum);
    }
}
