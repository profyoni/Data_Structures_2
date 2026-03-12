import java.util.ArrayList;

public class Multithreading {

    static ArrayList<Integer> al = new ArrayList<Integer>();

    static String key = "";
    static void myAdd(int i){
        synchronized(al) {
            al.add(i);
        }

    }
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(){
            public void run(){
                for (int i = 0;i<10_000; i++)
                {
                    myAdd(i);
                    // busy work 100 sec
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            public void run(){
                for (int i=0;i<10_000; i++)
                    myAdd(i);
            }
        };
        thread2.start();
        Thread.sleep(3_000);
        System.out.println(al.size());

    }

}
