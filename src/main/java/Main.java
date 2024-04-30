import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CountDivisionCalculator countDivisionCalculator = new CountDivisionCalculator();
        Scanner scanner = new Scanner(System.in);
        Formatter formatter = new Formatter();

        System.out.println("Hello пипл, на скольких пиплов делим счёт?");
        int howManyPeople;

        while (true) {
            if (scanner.hasNextInt()) {
                howManyPeople = scanner.nextInt();
                if (howManyPeople <= 1) {
                    if (howManyPeople <= 0) {
                        System.out.println("Пипл, делить на " + howManyPeople + " в моей программе нельзя!!!");
                        break;
                    } else {
                        System.out.println("Пипл, дели на себя!");
                        break;
                    }
                } else {
                    countDivisionCalculator.calculate(howManyPeople);
                    break;
                }
            } else {
                System.out.println("Неверный ввод! Введите целое число.");
                scanner.next();
            }
        }

        if (howManyPeople > 1) {
            countDivisionCalculator.itemPrint();
            double totalSum = countDivisionCalculator.calculateTotal();
            double devidedPerson = totalSum / howManyPeople;
            String padej = formatter.getPadej(devidedPerson);
            System.out.printf("Каждый человек должен заплатить %.2f %s", devidedPerson, padej);
        }
    }
}