package Day01;

public class OperationBinary {
    public static void main(String[] args) {
        
        String str="1C0C1C1A0B1";
        int res=str.charAt(0)-'0';
        for(int i=1;i<str.length()-1;i+=2){
            char ch=str.charAt(i);
            int val=str.charAt(i+1)-'0';
            if(ch=='A') res&=val;
            else if(ch=='B') res|=val;
            else res^=val;
        }
        System.out.println(res);
    }
}
