import java.util.Locale;
import java.util.Scanner;

public class Lab5B {
    static double f(double x, double a, double b) {
        double eps = 1e-9;
        if (Math.abs(x - 5) < eps) {
            return 2 * Math.exp(a * x - 1) + 1;
        }
        if (x < 5) {
            return Math.sin(3 * x);
        }
        return Math.pow(b * x - a, -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Завдання №2");
        System.out.println();

        System.out.print("Введіть a: ");
        double a = sc.nextDouble();
        System.out.print("Введіть b: ");
        double b = sc.nextDouble();
        System.out.print("Введіть значення Xmin: ");
        double xMin = sc.nextDouble();
        System.out.print("Введіть значення Xmax: ");
        double xMax = sc.nextDouble();
        System.out.print("Введіть значення dX: ");
        double dx = sc.nextDouble();

        System.out.println();
        System.out.println("Результати обчислень:");

        int n = (int) Math.floor((xMax - xMin) / dx + 1e-9);
        for (int i = 0; i <= n; i++) {
            double x = xMin + i * dx;
            double y = f(x, a, b);
            System.out.println(String.format(Locale.US, "f(%.5f) = %.5f", x, y));
        }
    }
}