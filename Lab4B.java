import java.util.Scanner;

public class Lab4B {

    static boolean isEnd(char c) {
        return c == '.' || c == '!' || c == '?';
    }

    static int countWhile(String text) {
        int count = 0;
        int i = 0;
        boolean hasContent = false;

        while (i < text.length()) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                hasContent = true;
            } else if (isEnd(c)) {
                boolean last = i + 1 == text.length() || !isEnd(text.charAt(i + 1));
                if (last && hasContent) {
                    count++;
                    hasContent = false;
                }
            }
            i++;
        }
        return count;
    }

    static int countDoWhile(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        int count = 0;
        int i = 0;
        boolean hasContent = false;

        do {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                hasContent = true;
            } else if (isEnd(c)) {
                boolean last = i + 1 == text.length() || !isEnd(text.charAt(i + 1));
                if (last && hasContent) {
                    count++;
                    hasContent = false;
                }
            }
            i++;
        } while (i < text.length());
        return count;
    }

    static String readText(Scanner sc) {
        String text;
        do {
            System.out.print("Введіть текст: ");
            text = sc.nextLine();
            if (text.trim().isEmpty()) {
                System.out.println("Помилка: текст не має бути порожнім.");
            }
        } while (text.trim().isEmpty());
        return text;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = readText(sc);

        System.out.println("Кількість речень (цикл while): " + countWhile(text));
        System.out.println("Кількість речень (цикл do-while): " + countDoWhile(text));
    }
}