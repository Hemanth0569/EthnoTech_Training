package Collections;

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Spotify {
    public static void main(String[] args) {
        Queue<String> songs = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 10 song names:");
        for (int i = 1; i <= 10; i++) {
            String song = sc.nextLine();
            songs.offer(song);
        }
        System.out.println(songs);
        System.out.println("For remove enter 1");
        int rem=sc.nextInt();
        if(rem==1){
            System.out.println(songs.poll());
        }
        System.out.println(songs);
        System.out.println("Currect Song:");
        System.out.println(songs.peek());

    }
}
