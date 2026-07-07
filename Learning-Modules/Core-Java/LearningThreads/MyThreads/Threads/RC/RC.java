package LearningThreads.MyThreads.Threads.RC;

class MyRace
{
    int count = 0;
    public synchronized void increment()
    {
        /*synchronized (this)
        {
            count++;
        }*/
        count++;
    }
}
public class RC {
    public static void main(String[] args) throws InterruptedException {
        MyRace r = new MyRace();
        Thread t1 = new Thread(()->
        {
            for (int i = 1; i <=1000 ; i++) {
                r.increment();
            }
        });

        Thread t2 = new Thread(()->
        {
            for(int i = 1; i <= 1000; i++) {
                r.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.count);
    }
}
