import java.util.*;

/**
 * This is a JavaDoc class CalcTask comment.
 * Created by COVID-19.
 *
 * @author RyzhkovBS
 */


public class LongWord {

    /**
     * Логика программы "Самое длинное слово"
     */
    public static void startMaxArray() {
        int arrayLength = getArrayLength();
        String[] arrayNumbs = fillingArray(arrayLength);
        checkMaxWord(arrayNumbs);
    }

    private static int getArrayLength() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int arrayLength;
        do {
            System.out.println("Ввести длину массива: ");
            arrayLength = scanner.nextInt();
        } while (arrayLength <= 0);
        System.out.println("Длина массива: " + arrayLength);
        return arrayLength;
    }

    private static String[] fillingArray(int arrayLength) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String[] arrayNumbs = new String[arrayLength];

        for (int increment = 0; increment < arrayLength; increment++) {
            System.out.println("Ввести элемент массива: " + increment);
            arrayNumbs[increment] = scanner.next(); // Заполняем массив элементами с клавиатуры
        }

        System.out.print("Массив arrayNumbs содержит элементы:");
        for (int increment = 0; increment < arrayLength; increment++) {
            System.out.print(" | " + arrayNumbs[increment]); // Печатаем полученный массив
        }
        System.out.println(" |");
        System.out.println("_____________________________________________");
        return arrayNumbs;
    }

    private static void checkMaxWord(String[] arrayNumbs) {

        List<Integer> lengthWord = new ArrayList<>();
        for (String arrayNumb : arrayNumbs) {
            //System.out.print(" | " + arrayNumb.length());
            lengthWord.add(arrayNumb.length());
        }

        System.out.println();
        System.out.println("Максимальное количество символов " + Collections.max(lengthWord));
        System.out.println("Слово: " + arrayNumbs[lengthWord.indexOf(Collections.max(lengthWord))]);

    }

}

