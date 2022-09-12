package vending;

import java.util.Scanner;

public class Machine implements Selling, Maintenance {
    private Tray[] trays;

    private boolean maintenanceMode;

    private double moneyIn;

    private String key;

    public Machine(Tray[] trays, String key) {
        this.trays = trays;
        this.key = key;
    }

    private void listing() {
        for (int i = 0; i < trays.length; i++) {
            System.out.println("Номер " + (i + 1) + ": " + trays[i].getDesc());
        }
    }


    @Override
    public void buy() {
        System.out.println("-=ПОКУПКА ТОВАРА=-");
        if (this.maintenanceMode) {
            System.out.println("АВТОМАТ НА ОБСЛУЖИВАНИИ");
            return;
        }

        System.out.println("У вас на счету " + this.moneyIn + " денег");
        this.listing();
        System.out.print("Выберите продукт (0 - выход): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= trays.length) {
            Tray currentTray = trays[choice - 1];
            if (currentTray.getQty() > 0 && this.moneyIn >= currentTray.getPrice()) {
                System.out.println("Вы купили " + currentTray.getName());
                this.moneyIn -= currentTray.getPrice();
                currentTray.removeItems(1);
                System.out.println("У вас на счету: " + this.moneyIn);
            } else if (currentTray.getQty() > 0) {
                System.out.println("Ваш выбор " + currentTray.getDesc());
                System.out.println("На счету недостаточно денег для покупки - " + this.moneyIn);
            } else {
                System.out.println("К сожалению, этот товар закончился. Попробуйте выбрать другой");
            }
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("Вы ввели неверный номер, попробуйте ещё раз");
        }
    }


    @Override
    public void pay() {
        System.out.println("-=ОПЛАТА=-");
        if (this.maintenanceMode) {
            System.out.println("АВТОМАТ НА ОБСЛУЖИВАНИИ");
            return;
        }

        System.out.print("Сколько денег будет добавлено (0 - не вносить): ");
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        this.moneyIn += money;
        System.out.println("Всего внесено денег: " + this.moneyIn);
    }

    @Override
    public void returnChange() {
        System.out.println("-=ВОЗВРАТ СДАЧИ=-");
        if (this.maintenanceMode) {
            System.out.println("АВТОМАТ НА ОБСЛУЖИВАНИИ");
            return;
        }

        // Считаем что у нас всегда есть деньги любого номинала
        System.out.println("Вам вернули " + this.moneyIn + " денег.");
        this.moneyIn = 0;
    }

    @Override
    public void putOnMaintenance() {
        System.out.println("-=ПЕРЕВОД В РЕЖИМ ОБСЛУЖИВАНИЯ=-");
        if (this.maintenanceMode) {
            System.out.println("Автомат уже в режиме обслуживания");
            return;
        }

        System.out.print("Для перевода в режим обслуживания нужен ключ: ");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();

        if (this.key.equals(key)) {
            System.out.println("Автомат переведён в режим обслуживания");
            this.maintenanceMode = true;
        } else {
            System.out.println("Ключ не подошёл");
        }
    }

    @Override
    public void takeOutOfMaintenance() {
        if (this.maintenanceMode) {
            System.out.println("Автомат переведён в рабочий режим");
            this.maintenanceMode = false;
        }
    }

    @Override
    public void load() {
        System.out.println("-=ЗАГРУЗКА ТОВАРА=-");
        if (!this.maintenanceMode) {
            System.out.println("Автомат не в режиме обслуживания");
            return;
        }

        this.listing();
        System.out.print("В какой лоток грузим? (0 - выход): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= trays.length) {
            Tray currentTray = trays[choice - 1];
            System.out.println("Ваш выбор " + currentTray.getName());
            System.out.print("Сколько товара докладываем: ");
            int count = scanner.nextInt();
            currentTray.addItems(count);
            System.out.println("Новое количество товара : " + currentTray.getQty());


        } else if (choice == 0) {
            return;
        } else {
            System.out.println("Вы ввели неверный номер, попробуйте ещё раз");
        }

    }

    @Override
    public void setPrice() {
        System.out.println("-=УСТАНОВКА ЦЕНЫ=-");
        if (!this.maintenanceMode) {
            System.out.println("Автомат не в режиме обслуживания");
            return;
        }

        this.listing();
        System.out.print("Для какого товара меняем цену? (0 - выход): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= trays.length) {
            Tray currentTray = trays[choice - 1];
            System.out.println("Ваш выбор " + currentTray.getName() + ". Текущая цена " + currentTray.getPrice());
            System.out.print("Введите новую цену: ");
            double price = scanner.nextDouble();
            currentTray.setPrice(price);
            System.out.println("Цена изменена");

        } else if (choice == 0) {
            return;
        } else {
            System.out.println("Вы ввели неверный номер, попробуйте ещё раз");
        }

    }

    @Override
    public void changeProduct() {
        System.out.println("-=СМЕНА ПРОДУКТА=-");
        if (!this.maintenanceMode) {
            System.out.println("Автомат не в режиме обслуживания");
            return;
        }


        this.listing();
        System.out.print("Какой товар меняем? (0 - выход): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= trays.length) {
            this.trays[choice - 1] = this.setNewTray();
            System.out.println("Товар заменён");

        } else if (choice == 0) {
            return;
        } else {
            System.out.println("Вы ввели неверный номер, попробуйте ещё раз");
        }

    }

    @Override
    public void addProduct() {
        System.out.println("-=ДОБАВЛЕНИЕ НОВОГО ПРОДУКТА=-");
        if (!this.maintenanceMode) {
            System.out.println("Автомат не в режиме обслуживания");
            return;
        }

        Tray[] trays = new Tray[this.trays.length + 1];
        System.arraycopy(this.trays, 0, trays, 0, this.trays.length);
        trays[trays.length - 1] = this.setNewTray();
        this.trays = trays;
    }

    private Tray setNewTray() {
        String name;
        double price;
        int qty;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя товара: ");
        name = scanner.nextLine();

        System.out.print("Введите стоимость товара: ");
        price = scanner.nextDouble();

        System.out.print("Введите количество товара: ");
        qty = scanner.nextInt();

        return new Tray(name, price, qty);
    }

}
