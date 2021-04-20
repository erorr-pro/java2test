import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
     * This is a JavaDoc public method 'main' comment.
     * Логика программы.
     */
    public static void main(String[] args) {
        printMenu();
        byte numberProgram = getProgram();
        switch (numberProgram) {
            case 1:
                Calculator.startCalc();
                break;
            case 2:
                LongWord.startMaxArray();
                //System.out.println("Програма в разработке!");
                break;
            case 3:
                // Предполагается что программа завершит работу
                break;
            default:
                System.out.println("Ошибка!");
                break;
        }
    }



    /**
     * Метод печатает mainMenu.
     */
    public static void printMenu() {
        System.out.println("1 - Калькулятор;");
        System.out.println("2 - Поиск максимального элемента в массиве;");
        System.out.println("3 - Выход из программы;");
    }

    /**
     * This is a JavaDoc private method 'getProgram' comment. Обрабатывает не корректный ввод.
     *
     * @return Возвращает номер программы. Тип byte.
     */
    public static byte getProgram() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Ввод... ");
        byte numberProgram = scanner.nextByte();
        switch (numberProgram) { // выражение для сравнения
            case 1:
                System.out.println("Вы выбрали: 1 - Калькулятор");
                break;
            case 2:
                System.out.println("Вы выбрали: 2 - Поиск максимального элемента в массиве");
                break;
            case 3:
                System.out.println("Программа завершила работу.");
                break;
            default:
                System.out.println("Ввод пользователя отсутствует в списке!");
        }
        return numberProgram;
    }


}
