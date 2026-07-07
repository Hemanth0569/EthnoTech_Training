package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CC {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(22);
        list.add(13);
        list.add(24);
        list.add(15);

//        Comparator<Integer> com = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                if(a%10 > b%10) return 1;
//                else return -1;
//            }
//        };

        Comparator<Integer> com = (a,b) -> a%10 > b%10 ? 1 : -1;

        Collections.sort(list,com);
        System.out.println(list);
    }
}
