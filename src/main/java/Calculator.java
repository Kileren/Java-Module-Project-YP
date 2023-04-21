import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    ArrayList<Product> products = new ArrayList<>();

    void start(int numberOfPeople, Scanner scanner) {
        do {
            String productName = getProductName(scanner);
            double productPrice = getProductPrice(scanner);
            products.add(new Product(productName, productPrice));
            successfullyAddedMessage();
        } while (shouldContinueAddingProducts(scanner));

        printResults(numberOfPeople);
    }

    String getProductName(Scanner scanner) {
        System.out.println("Введите название товара:");
        String productName = "";
        while (productName.isEmpty()) {
            productName = scanner.next();
            if (productName.isEmpty()) {
                System.out.println("ОШИБКА. Введенное значение не должно быть пустым. Введите еще раз:");
            }
        }
        return productName;
    }

    double getProductPrice(Scanner scanner) {
        double price = -1;
        System.out.println("Введите стоимость товара:");
        while (price < 0) {
            String priceStr = scanner.next();
            try {
                price = Double.parseDouble(priceStr);
                if (price < 0) {
                    System.out.println("ОШИБКА. Стоимость товара не может быть меньше 0, введите снова:");
                }
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА. Введеное значение не является числом, введите снова:");
            }
        }
        return price;
    }

    void successfullyAddedMessage() {
        System.out.println("Товар успешно добавлен.\n");
    }

    boolean shouldContinueAddingProducts(Scanner scanner) {
        System.out.println("Хотите добавить еще один товар?");
        System.out.println("Введите \"Завершить\", чтобы прекратить ввод товаров или любой символ, чтобы продолжить добавления товаров.");

        String userInput = scanner.next();
        return !userInput.equalsIgnoreCase("Завершить");
    }

    void printResults(int numberOfPeople) {
        double totalPrice = 0;

        System.out.println("Добавленные товары:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(product.name);
            totalPrice += product.price;
        }

        String amountPerPerson = PriceFormatter.format(totalPrice / numberOfPeople);
        System.out.printf("\nКаждый человек должен заплатить - %s", amountPerPerson);
    }
}
