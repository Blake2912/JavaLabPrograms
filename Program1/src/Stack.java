import java.util.Scanner;
/*
Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and Display() methods to
demonstrate its working
 */
public class Stack {
    static int top = -1;
    static int MAX = 5;
    static void push(int[] stack){
        int element;
        Scanner input = new Scanner(System.in);
        if(top == MAX-1){
            System.out.println("Stack Overflow");
        }
        else{
            top++;
            System.out.println("Enter the element you want to push: ");
            element = input.nextInt();
            stack[top] = element;
        }
    }
    static void pop(int [] stack){
        int temp;
        if(top == -1){
            System.out.println("Stack Underflow");
        }
        else{
            temp = stack[top];
            stack[top] = 0;
            top = top-1;
            System.out.println("The element popped: "+ temp);
        }
    }
    static void display(int [] stack) {
        if (top == -1) {
            System.out.println("The stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] stack = new int[MAX];
        int option;
        do {
            System.out.println("Menu:\n\t1.Push element in stack\n\t2.Pop element in stack\n\t3. Display element\n\t0. Exit");
            System.out.println("\nEnter your option:");
            option = input.nextInt();
            if(option == 1){
//                System.out.println("You have selected the push option");
                push(stack);
            }
            else if(option == 2){
//                System.out.println("You have selected pop option");
                pop(stack);
            }
            else if(option == 3){
//                System.out.println("You have selected display option");
                display(stack);
            }
            else{
                System.out.println("Wrong option selected");
            }
        }while (option != 0);
    }
}
