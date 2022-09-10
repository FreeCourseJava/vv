package vending;

public interface Maintenance {
    boolean putOnMaintenance();

    boolean takeOutOfMaintenance();

    boolean chooseProduct(int itemNum);

    boolean load(int qty);

    void setPrice(double price);


}
