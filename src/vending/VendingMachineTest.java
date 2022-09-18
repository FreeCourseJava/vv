package vending;

public class VendingMachineTest {
    public static void main(String[] args) {

        Tray[] products = new Tray[]{
                new Tray("Big Crayfish", 5, 10),
                new Tray("Small Crayfish", 3, 10),
                new Tray("Chips", 10, 5),
                new Tray("Water", 2, 5),
                new Tray("M&Ms", 2, 0)

        };

        Machine machine = new Machine(products, "secret");
        machine.buy();
        machine.pay();
        machine.pay();
        machine.pay();
        machine.buy();
        machine.buy();
        machine.buy();
        machine.buy();
        machine.buy();
        machine.buy();
        machine.returnChange();

        machine.putOnMaintenance();
        machine.putOnMaintenance();
        machine.load();
        machine.load();
        machine.buy();
        machine.setPrice();
        machine.addProduct();
        machine.changeProduct();
        machine.takeOutOfMaintenance();


        machine.pay();
        machine.buy();
        machine.returnChange();


    }




}
