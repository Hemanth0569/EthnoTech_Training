package Day01;

public class LongestWord {
    public static void main(String[] args) {
        String str="I love to code in java programming";
        int maxlen=0;
        String words[]=str.split(" ");
        String s="";
        for(int i=0;i<words.length;i++){
            int len=words[i].length();
            if(maxlen<len){
                maxlen=len;
                s=words[i];
            }
        }
        System.out.println(s);
    }
}
