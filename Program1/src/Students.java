import java.util.Scanner;

public class Students {

    public String name, USN, Department;
    public long phone_number;

    public Students(String name, String USN, String Department, long phone_number){
        this.name = name;
        this.USN = USN;
        this.Department = Department;
        this.phone_number = phone_number;

    }
    public static void main(String[] args) {
        String name_t,usn_t,dept_t; // Here _t means it is a temp variable to store the data
        long ph_no_t;
        Scanner myObj = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of students:");
        n = myObj.nextInt();
        Students [] arr = new Students[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the student detail for student " + (i+1));
            System.out.println("Enter Name:");
            name_t = myObj.next();
            System.out.println("Enter USN:");
            usn_t = myObj.next();
            System.out.println("Enter Department:");
            dept_t = myObj.next();
            System.out.println("Enter Phone number:");
            ph_no_t = myObj.nextLong();
            arr[i] = new Students(name_t,usn_t,dept_t,ph_no_t);
        }
        for(int i=0;i<n;i++){
            System.out.println("\nDetails of student "+ (i+1));
            System.out.println("Name: "+ arr[i].name);
            System.out.println("USN: "+ arr[i].USN);
            System.out.println("Department: "+ arr[i].Department);
            System.out.println("Phone number: "+ arr[i].phone_number);
        }
    }
}
