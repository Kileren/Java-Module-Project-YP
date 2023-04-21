import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int numberOfPeople = getNumberOfPeople(scanner);

        Calculator calculator = new Calculator();
        calculator.start(numberOfPeople, scanner);

        scanner.close();
    }

    static int getNumberOfPeople(Scanner scanner) {
        int numberOfPeople = 0;
        System.out.println("На скольких человек необходимо разделить счет?");
        while (numberOfPeople <= 1) {
            String userInput = scanner.next();
            try {
                numberOfPeople = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА. Ожидается целочисленное значение. Введите корректное число:");
                continue;
            }

            if (numberOfPeople == 1) {
                System.out.println("ОШИБКА. Некорректное число. На одного человека нет смысла ничего считать и делить. Введите корректное число.");
            } else if (numberOfPeople < 1) {
                System.out.println("ОШИБКА. Некорректное число. Количество людей должно быть больше 1. Введите корректное число");
            }
        }
        return numberOfPeople;
    }
}