import java.util.Scanner;

public class Queue {
    static int MAX = 5; // Total elements in the queue
    static int front = -1;
    static int rear = -1;

    static void push(int [] queue){
        int element;
        Scanner input = new Scanner(System.in);
        if(rear == (MAX-1)){ // overflow condition
            System.out.println("Queue overflow");
        }
        else{
            if(front == -1){
                front = 0;
            }
            rear = rear +1;
            System.out.println("Enter the element you want to insert: ");
            element = input.nextInt();
            queue[rear] = element;
        }
    }

    static void pop(int [] queue){
        if(front == -1){ // underflow condition
            System.out.println("Queue Underflow");
        }
        else if(front == rear){ // If only one element is present
            System.out.println("Element deleted "+ queue[front]);
            rear = -1;
            front = -1;
        }
        else{
            System.out.println("Element deleted "+queue[front]);
            queue[front] = 0;
            front = front +1;
        }
    }

    static void display(int [] queue){
        if(front == -1){
            System.out.println("Queue Underflow");
        }
        else{
            int i;
            for(i=front;i<=rear;i++){
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] queue = new int[MAX];
        int option;
        do {
            System.out.println("Menu:\n\t1.Push element in queue\n\t2.Pop element in queue\n\t3. Display element\n\t0. Exit");
            System.out.println("\nEnter your option:");
            option = input.nextInt();
            if(option == 1){
                System.out.println("You have selected the push option");
                push(queue);
            }
            else if(option == 2){
                System.out.println("You have selected pop option");
                pop(queue);
            }
            else if(option == 3){
                System.out.println("You have selected display option");
                display(queue);
            }
            else{
                System.out.println("Wrong option selected");
            }
        }while (option != 0);
    }
}
