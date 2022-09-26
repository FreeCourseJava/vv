package vending;

public class Tray {

    private final String productName;
    private double price;
    private int qty;

    public Tray(String name, double price, int qty) {
        this.productName = name;
        this.price = price;
        this.qty = qty;
    }

    public String getDesc(){
        return this.productName + "(" +this.price + " денег) - в наличии " + this.getQty() + " шт.";
    }

    public String getName() {
        return this.productName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQty() {
        return this.qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addItems(int count) {
        this.qty += count;
    }

    public void removeItems(int count) {
        this.qty -= count;
    }
}
