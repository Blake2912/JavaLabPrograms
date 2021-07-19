import java.util.Scanner;

public class Program3A {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        a = input.nextInt();
        System.out.println("Enter the value of b: ");
        b = input.nextInt();
        int result,addition;
        try{
            result = a/b;
            System.out.println("Result after division: "+result);
        }catch (Exception e){e.printStackTrace();}
        addition = a+b;
        System.out.println("Result after addition: "+addition);
    }
}
