package LearningThreads.MyThreads.Threads.Basics;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());
        /*System.out.println("The Creation of Thread");
        MyThreads t = new MyThreads();
        System.out.println(t.getName());
        t.start();
        System.out.println(t.getName());*/
        System.out.println("The Creation of Thread");
        MyThreads t = new MyThreads();
        t.start();
        for (int i = 1; i <=3 ; i++) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
