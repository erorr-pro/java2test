import java.util.Locale;
import java.util.Scanner;

/**
 * This is a JavaDoc class CalcTask comment
 * Created by COVID-19
 *
 * @author RyzhkovBS
 */

class CalcTask {
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    /**
     * This is a JavaDoc public method 'main' comment
     * Логика программы и вывод результата
     */
    public static void main(String[] args) {
        double numberOne = getDouble();
        double numberTwo = getDouble();
        char operation = getOperation();
        boolean validateZero = isDefZero(numberTwo, operation);
        double result = count(numberOne, numberTwo, operation); // нужно добавить обработку деления на ноль
        printResult(numberOne,numberTwo, validateZero, result, operation);
    }

    /**
     * This is a JavaDoc private method 'getDouble' comment
     * Метод
     */
    private static double getDouble() {

        System.out.println("Введите число: ");
        double number;

        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Ошибка. Введите дробное число.");
            scanner.next();
            number = getDouble();
        }
        return number;
    }

    /**
     * This is a JavaDoc private method 'getOperation' comment
     */
    private static char getOperation() {

        System.out.println("Введите операцию: ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка. Введите операцию.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    /**
     * This is a JavaDoc private method 'count' comment
     */
    private static double count(double numberOne, double numberTwo, char operation) {
        double result;
        switch (operation) { // выражение для сравнения
            case '-':
                result = numberOne - numberTwo;
                break;
            case '+':
                result = numberOne + numberTwo;
                break;
            case '/':
                result = numberOne / numberTwo;
                break;
            case '*':
                result = numberOne * numberTwo;
                break;
            default:
                System.out.println("Ошибка. Введите операцию.");
                result = count(numberOne, numberTwo, getOperation());
        }
        return result;
    }

    private static boolean isDefZero(double numberTwo, char operation) {
        char def = '/';
        return numberTwo == 0 & def != operation;
    }

    private static void printResult (double numberOne, double numberTwo, boolean validateZero, double result, char operation) {
        if (validateZero){
            System.out.println("Деление на ноль невозможно!");
        } else {
            System.out.println("Результат операции '" + numberOne + operation + numberTwo + " = " + result + "'");
        }
    }

}