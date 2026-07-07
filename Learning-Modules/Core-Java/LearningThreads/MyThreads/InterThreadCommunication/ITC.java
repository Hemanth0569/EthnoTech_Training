package LearningThreads.MyThreads.InterThreadCommunication;

class Message
{
    boolean isMessage = false;
    public synchronized void receiver() throws InterruptedException {
        while (!isMessage){
            System.out.println("Waiting for message");
            wait();
        }
        System.out.println("Message received");
    }

    public synchronized void sender()
    {
        isMessage = true;
        System.out.println("Message sent");
        notify();
    }
}
public class ITC {
    public static void main(String[] args) throws InterruptedException {
        Message m = new Message();
        Thread t1 = new Thread(()->
        {
            try{
                m.receiver();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->
        {
            try {
                Thread.sleep(2000);
                m.sender();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
