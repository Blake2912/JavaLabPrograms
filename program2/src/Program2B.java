import java.util.Scanner;
import java.util.StringTokenizer;
public class Program2B {
    static class Customer {
        String DOB;
        String name;
    }
    static void read(Customer details){
        Scanner input = new Scanner(System.in);
        String name1, DOB1;
        System.out.println("Enter the name of the customer: ");
        name1 = input.nextLine();
        System.out.println("Enter the DOB of the customer separated with /: ");
        DOB1 = input.nextLine();
        details.name = name1;
        details.DOB = DOB1;
    }
    static void display(Customer details){
        System.out.print("<"+details.name+" ");
        StringTokenizer st = new StringTokenizer(details.DOB,"/");
        while (st.hasMoreTokens()){
            System.out.print(st.nextToken());
            System.out.print(",");
        }
        System.out.print(">");
    }
    public static void main(String[] args){
        Customer customer_details = new Customer();
        read(customer_details);
        display(customer_details);
    }
}

//        public Customer(String name, String DOB) {
//            this.name = name;
//            this.DOB = DOB;
//        }