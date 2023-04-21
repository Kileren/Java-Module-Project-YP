public class PriceFormatter {

    static String format(double amount) {
        int mainPart = (int) Math.floor(amount);
        String rub;
        if (mainPart % 10 == 1 && mainPart % 100 != 11) {
            rub = "рубль";
        } else if (mainPart % 10 >= 2 && mainPart % 10 <= 4 && (mainPart % 100 < 10 || mainPart % 100 >= 20)) {
            rub = "рубля";
        } else {
            rub = "рублей";
        }
        return String.format("%.2f %s", amount, rub);
    }
}
