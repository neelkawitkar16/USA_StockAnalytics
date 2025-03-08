public class FirstProgram {
    public static void main(String[] args){
        System.out.println("First Program in Java!");

        //Variable Declaration
        int a;
        //Variable Initialization
        a = 16;
        //Declare and initialize
        int b = 20;

        String name = "Name";

        //Print sum of a and b
        int add = addition(a,b);
        System.out.println("Sum of a and b is: " + add);

        int multi = multiplication(a,b);
        System.out.println("Multiplication of a and b is: " + multi);

        float div = division(a,b);
        System.out.println("Division of a and b is:" + div);
    }

    public static int addition(int first_num, int second_num){
        int sum = first_num + second_num;
        return sum;
    }

    public static int multiplication(int num1, int num2){
        int product = num1 * num2;
        return product;
    }
    public static float division(float a, float b) {
        float division = a/b;
        return division;
    }

}
