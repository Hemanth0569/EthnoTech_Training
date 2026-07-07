package Oops.Encapsulation;

    class AccessModi{
        public int a = 10;
        private int b = 20;
        protected int c = 30;
        int d = 30;

        public int getB(){
            return b;
        }
        public void setB(int b){
            this.b=b;
        }
    }

    class Access1 extends AccessModi{
        void printData(){
            System.out.println(a);
            System.out.println(getB());
            System.out.println(c);
            System.out.println(d);
        }
    }
public class Encap {
    public static void main(String[] args) {
        Access1 acc = new Access1();
        acc.printData();
    }
}
