import java.util.Locale;
import java.util.Scanner;

/**
 * This is a JavaDoc class CalcTask comment.
 * Created by COVID-19.
 *
 * @author RyzhkovBS
 */

public class Calculator {

    /**
     * Логика программы Калькулятор
     */
    public static void startCalc() {
        double numberOne = getDouble(); // вводим первое число
        double numberTwo = getDouble(); // вводим второе число
        char operation = getOperation(); // вводим операцию // баг
        boolean validateZero = isDefZero(numberTwo, operation); // проверяем деление на ноль
        double result = count(numberOne, numberTwo, operation); // вычисляем результат
        printResult(validateZero, result); // выводим результат в консоль
    }


    /**
     * This is a JavaDoc private method 'getDouble' comment. Обрабатывает не корректный ввод.
     * Рекурсия - зло.
     *
     * @return Возвращает числа типа Double.
     */
    private static double getDouble() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Введите число: ");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
            return number;
        } else {
            System.out.println("Ошибка. Введите дробное число.");
            scanner.next();
            return getDouble();
        }
    }


    /**
     * This is a JavaDoc private method 'getOperation' comment. Обрабатывает не корректный ввод.
     * Рекурсия - зло.
     *
     * @return Возвращает числа типа Char.
     */
    private static char getOperation() {

        Scanner operation = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Введите операцию: ");

        return operation.next().charAt(0);
    }

    /**
     * This is a JavaDoc private method 'count' comment.
     * Сравниваем операцию 'operation' полученную из консоли и проводим соответствующие вычисления.
     *
     * @param numberOne Первое число.
     * @param numberTwo Второе число. При делении не должно равняться нулю.
     * @param operation Операция между числами.
     * @return Возвращает результат операции.
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
                System.out.println("Ошибка ввода.");
                result = count(numberOne, numberTwo, getOperation());
                break;
        }
        return result;
    }

    /**
     * This is a JavaDoc private method 'isDefZero' comment.
     * Проверка деления на ноль.
     * Должно выполняться два условия одновременно.
     * 1. Второе число равно нулю
     * 2. Операция - деление
     */
    private static boolean isDefZero(double numberTwo, char operation) {
        final char DEF = '/';
        return numberTwo == 0 & DEF == operation;
    }


    /**
     * This is a JavaDoc private method 'printResult' comment. Печатаем результат.
     * Если деление на ноль  - истина. Выводим сообщение, что деление на ноль невозможно.
     * В противном случае печатаем всё выражение и результат операции.
     */
    private static void printResult(boolean validateZero, double result) {
        if (validateZero) {
            System.out.println("Деление на ноль невозможно!");
        } else {
            System.out.printf("Результат операции " + "%.4f", result);
        }
    }

}