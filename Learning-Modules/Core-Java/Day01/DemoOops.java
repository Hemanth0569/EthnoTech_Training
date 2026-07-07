package Day01;

class MyAdd{
    public int a;
    public int b;
    public MyAdd(int a,int b){
        this.a=a;
        this.b=b;
    }
    public void add(){
        System.out.println(this.a+this.b);
    }
    public void sub(){
        System.out.println(this.a-this.b);
    }
}
public class DemoOops {
    public static void main(String[] args) {
        MyAdd x=new MyAdd(20,10);
        x.add();
        x.sub();
    }

}
