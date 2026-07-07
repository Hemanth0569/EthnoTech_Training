package Projects.HungerBox;

import java.awt.*;
import java.util.ArrayList;

interface Orderable
    {
        double getPrice();
        String getDescription();
        void prepare();
    }

    interface Discounts
    {
        double applyDiscounts(double discount);
    }

    abstract class MenuItems implements Orderable, Discounts
    {
        private final String name;
        private double price;
        static int totalNumberOfOrders = 0;
        private String categories;

        public MenuItems(String name, double price, String categories)
        {
            this.name=name;
            this.price=price;
            this.categories=categories;
        }

        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }

        public void setPrice(double price){
            if(price>0){
                this.price=price;
            }
        }

        public static int getTotalNumberOfOrders() {
            return totalNumberOfOrders;
        }

        public static void setTotalNumberOfOrders(int totalNumberOfOrders) {
            MenuItems.totalNumberOfOrders = totalNumberOfOrders;
        }

        public String getCategories() {
            return categories;
        }

        public void setCategories(String categories) {
            this.categories = categories;
        }

        @Override
        public String getDescription(){
            return "Item Name : " + getName() + " Price : $" + getPrice();
        }
        @Override
        abstract public void prepare();

        @Override
        public double applyDiscounts(double discount){
            return price - (price * discount / 100);
        }
    }

    class VegItems extends MenuItems
    {
        private boolean isJain;

        public VegItems(String name, double price)
        {
            super(name, price, "Veg");
            isJain = false;
        }
        public VegItems(String name, double price, boolean isjain)
        {
            super(name, price, "veg");
            isjain = isJain;
        }

        @Override
        public void prepare(){
            System.out.println("Your order of " + getName() + " of price " + getPrice() + " is been prepared.");
            totalNumberOfOrders++;
        }
    }

    class NonVegItems extends MenuItems
    {
        private String meatType;

        public NonVegItems(String name, double price, String categories, String meatType) {
            super(name, price, categories);
            this.meatType = meatType;
        }

        @Override
        public void prepare(){
            System.out.println("Your order of " + getName() + " of price " + getPrice() + " is been prepared");
            totalNumberOfOrders++;
        }

        @Override
        public String getDescription(){
            return super.getDescription() + this.meatType;
        }
    }

    class Orders
    {
        private final int orderId;
        private static int orderCount = 0;
        private final String customerName;
        ArrayList<MenuItems> list;
        private String status;

        Orders(String customerName)
        {
            this.customerName = customerName;
            this.list = new ArrayList<>();
            this.status = "Order Placed";
            this.orderId = ++orderCount;
        }

        public void addItems(MenuItems items) {
            list.add(items);
            //System.out.println(items.getDescription());
            System.out.println("The Items Ordered is " + items.getName() + " The Price is " + items.getPrice());
        }

        public void prepareOrder()
        {
            this.status = "Preparing Order";

            for(MenuItems items : list) items.prepare();
            this.status = "Ready";
        }
        double calculatePrice()
        {
            double price=0;
            for(MenuItems items:list)
            {
                price+=items.getPrice();
            }
            return price;
        }
        void generateBill(double discountPercent)
        {
            double subtotal = calculatePrice();
            double discounted = subtotal - (subtotal * discountPercent / 100);
            double tax  = discounted * 0.05;
            double total = discounted + tax;

            System.out.println("  ┌────────────────────────────────────┐");
            System.out.println("  │         HungerBox — Bill           │");
            System.out.println("  ├────────────────────────────────────┤");
            System.out.println("  │  Order ID  : #" + orderId);
            System.out.println("  │  Customer  : " + customerName);
            System.out.println("  │  Status    : " + status);
            System.out.println("  ├────────────────────────────────────┤");
            for (MenuItems item : list) {
                System.out.printf("  │  %-22s ₹%6.2f%n", item.getName(), item.getPrice());
            }
            System.out.println("  ├────────────────────────────────────┤");
            System.out.printf("  │  Subtotal              ₹%8.2f%n", subtotal);
            if (discountPercent > 0)
                System.out.printf("  │  Discount (%d%%)         -₹%7.2f%n", (int)discountPercent, subtotal - discounted);
            System.out.printf("  │  GST (5%%)              ₹%8.2f%n", tax);
            System.out.println("  ├────────────────────────────────────┤");
            System.out.printf("  │  TOTAL                 ₹%8.2f%n", total);
            System.out.println("  └────────────────────────────────────┘");
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    class Res
    {
        String name;
        ArrayList<MenuItems> menu;
        ArrayList<Orders> orders;

        Res(String name)
        {
            this.name=name;
            this.menu=new ArrayList<>();
            this.orders=new ArrayList<>();
        }
        void addMenu(MenuItems items)
        {
            menu.add(items);
        }
        void showMenu()
        {
            for (int i = 0; i < menu.size(); i++) {
                System.out.println( (i+1) + " : " + menu.get(i).getDescription());
            }
        }
        Orders placeOrder(String name)
        {
            Orders order1=new Orders(name);
            orders.add(order1);
            return order1;
        }
        MenuItems getItem(int index)
        {
            return menu.get(index);
        }
        void showOrder()
        {
            for(Orders order : orders)
            {
                System.out.println("The Order of " + order.getCustomerName()+ " " + order.getStatus() + menu.get(order.getOrderId()).getDescription());
            }
        }
    }

public class HungerBox {
    public static void main(String[] args) {
        Res res = new Res("Spicy Garden");
        res.addMenu(new VegItems("Panner Butter Masala", 300));
        res.addMenu(new VegItems("Soya Butter Masala", 200));
        res.addMenu(new VegItems("Tofu Butter Masala", 250));
        res.addMenu(new VegItems("Peanuts Butter Masala", 150));
        res.addMenu(new VegItems("Panner Butter Masala", 350,true));
        res.addMenu(new NonVegItems("Chicken Butter Masala",300, "Non Veg", "Chicken"));

        res.showMenu();

        Orders ord = res.placeOrder("Alexa");
        ord.addItems(res.getItem(0));
        ord.addItems(res.getItem(1));
        ord.addItems(res.getItem(2));
        ord.addItems(res.getItem(5));

        res.showOrder();
        ord.prepareOrder();
        ord.generateBill(10);
    }
}
