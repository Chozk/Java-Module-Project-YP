import java.util.ArrayList;
import java.util.Scanner;

public class CountDivisionCalculator {
    private Scanner scanner;
    private ArrayList<Item> itemList;
    Formatter formatter = new Formatter();


    public CountDivisionCalculator() {
        scanner = new Scanner(System.in);;
        itemList = new ArrayList<>();
    }

    void calculate(int howManyPeople) {
        createItems();
    }

    private void createItems() {
        while (true) {
            System.out.print("Введите наименование товара: ");

            String name = scanner.nextLine();
            double price = readPrice();

            itemList.add(new Item(name, price));

            System.out.println("Товар " + name + " успешно добавлен.");

            double totalSum = calculateTotal();
            String padej = formatter.getPadej(totalSum);

            System.out.printf("Общая сумма товаров в корзине: %.2f %s%n", totalSum, padej);

            if (!continueAdd()) {
                break;
            }
        }
    }

    private double readPrice() {
        while (true) {
            System.out.print("Введите стоимость товара в формате рубли.копейки: ");
            String input = scanner.nextLine();

            String[] twoFloat = input.split("\\.");

            if (twoFloat.length == 2 && twoFloat[1].length() <= 2) {
                if (isValidDouble(twoFloat[0] + "." + twoFloat[1])) {
                    double price = Double.parseDouble(input);
                    if (price < 0) {
                        System.out.println("Цена не может быть отрицательной.");
                        continue;
                    }
                    return price;
                } else {
                    System.out.println("Неверный формат ввода.");
                }
            } else {
                System.out.println("Неверный формат ввода.");
            }
        }
    }

    private boolean isValidDouble(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean continueAdd() {
        System.out.print("Для завершения, введите \"завершить\". Для продолжения, введите любой текст: ");
        String input = scanner.nextLine().trim().toLowerCase();
        return !input.equals("завершить");
    }

    double calculateTotal() {
        double totalAmount = 0.0;
        for (Item item : itemList) {
            totalAmount += item.price;
        }
        return totalAmount;
    }

    void itemPrint() {
        System.out.println("Добавленные товары:");
        for (Item item : itemList) {
            System.out.printf("%s %.2f%n", item.name, item.price);
        }
    }
}
