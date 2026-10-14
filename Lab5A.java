import java.util.Locale;

public class Lab5A {
    public static void main(String[] args) {
        double a = 0.5;
        double b = 2.7;
        double c = 0.4;

        double x = (a * a * c + Math.exp(-c) * Math.cos(b * c))
                / (b * c - Math.exp(-c) * Math.sin(b * c) + 1);

        double y = Math.exp(2 * c) * Math.log(a + c)
                - Math.pow(b, 3 * c) * Math.log(b - c);

        System.out.println("Завдання №1");
        System.out.println();
        System.out.println("Результат обчислень:");
        System.out.println(String.format(Locale.US, "x = %.5f", x));
        System.out.println(String.format(Locale.US, "y = %.5f", y));
    }
}