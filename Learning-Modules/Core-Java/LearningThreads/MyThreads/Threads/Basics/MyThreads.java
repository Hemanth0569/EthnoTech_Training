package LearningThreads.MyThreads.Threads.Basics;

public class MyThreads extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=3;i++){
            try{
                Thread.sleep(2000);
                System.out.println(i + "I am new thread");
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
