import java.util.Scanner;

public class Lab4C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть N: ");
        while (!sc.hasNextInt()) {
            System.out.println("Помилка: введіть ціле число.");
            sc.next();
            System.out.print("Введіть N: ");
        }
        int n = sc.nextInt();

        int count = 0;

        System.out.println("Прості числа від 1 до " + n + ":");

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("У цьому діапазоні простих чисел немає.");
        } else {
            System.out.println();
            System.out.println("Кількість простих чисел: " + count);
        }
    }
}