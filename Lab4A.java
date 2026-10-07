import java.util.Scanner;

public class Lab4A {

    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }

    static int daysInMonth(int m, int y) {
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeap(y) ? 29 : 28;
            default:
                return 0;
        }
    }

    static boolean isValid(int d, int m, int y) {
        if (y < 1) return false;
        if (m < 1 || m > 12) return false;
        if (d < 1 || d > daysInMonth(m, y)) return false;
        return true;
    }

    static int[] parseDate(String s) {
        String[] parts = s.trim().split("\\.");
        if (parts.length != 3) return null;
        try {
            return new int[] {
                    Integer.parseInt(parts[0].trim()),
                    Integer.parseInt(parts[1].trim()),
                    Integer.parseInt(parts[2].trim())
            };
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть першу дату (день.місяць.рік): ");
        int[] a = parseDate(sc.nextLine());

        System.out.print("Введіть другу дату (день.місяць.рік): ");
        int[] b = parseDate(sc.nextLine());

        if (a == null || b == null
                || !isValid(a[0], a[1], a[2])
                || !isValid(b[0], b[1], b[2])) {
            System.out.println("Помилка: введено некоректну дату.");
            return;
        }

        int d1 = a[0], m1 = a[1], y1 = a[2];
        int d2 = b[0], m2 = b[1], y2 = b[2];

        if (y1 == y2 && m1 == m2 && d1 == d2) {
            System.out.println("Дати однакові.");
        } else if (y1 < y2
                || (y1 == y2 && m1 < m2)
                || (y1 == y2 && m1 == m2 && d1 < d2)) {
            System.out.println("Перша дата раніша, друга дата пізніша.");
        } else {
            System.out.println("Друга дата раніша, перша дата пізніша.");
        }
    }
}