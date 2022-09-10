package vending;

public interface Selling {

    boolean chooseProduct(int itemNum);

    boolean takeMoney(double itemNum);

    boolean returnChange(double itemNum);

    boolean buy(int itemNum);

}
