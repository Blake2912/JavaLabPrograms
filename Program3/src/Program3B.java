import java.util.Random;

public class Program3B {

    static class Third implements Runnable{
        public int x;
        public Third(int x){
            this.x = x;
        }
        public void run(){
            System.out.println("Third Thread: Cube is: "+x*x*x);
        }
    }

    static class Second implements Runnable{
        public int x;
        public Second(int x){
            this.x = x;
        }
        public void run(){
            System.out.println("Second Thread: Cube is: "+x*x);
        }
    }

    static class First extends Thread{
        public void run(){
            int num;
            Random rand_no = new Random();
            try{
                for(int i=0;i<5;i++){
                    num = rand_no.nextInt(100);
                    System.out.println("First Thread generated number is "+ num);
                    Thread t2 = new Thread(new Second(num));
                    t2.start();
                    Thread t3 = new Thread(new Third(num));
                    t3.start();
                    Thread.sleep(1000);
                }
            }catch (Exception e){System.out.println(e.getMessage());}
        }
    }
    public static void main(String[] args) {
        First a = new First();
        a.start();
    }
}
