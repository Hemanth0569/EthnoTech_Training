package Day01;

public class Password {
    public static void main(String[] args) {
        char str[]={'a','A','1','_','6','7'};
        int n=str.length;
        System.out.println(checkpassword(str,n));
    }
    public static int checkpassword(char str[],int n){
        if(n<4 || (str[0]>='0' && str[0]<='9')) return 0;
        boolean num=false,cap=false;
        for(int i=0;i<n;i++){
            char ch=str[i];
            if(ch>='0' && ch<='9') num=true;
            else if(ch>='A' && ch<='Z') cap=true;
            else if(ch==' ' || ch=='/') return 0;
        }
        if(num && cap) return 1;
        return 0;
    }
}
