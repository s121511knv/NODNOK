import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вычислить НОД и НОК");
            System.out.println("0. Выход");

            try {
                int choice = readIntegerInput(scanner);

                if (choice == 0) {
                    System.out.println("Программа завершена.");
                    return;
                }

                System.out.print("Введите первое число: ");
                int number1 = readIntegerInput(scanner);
                System.out.print("Введите второе число: ");
                int number2 = readIntegerInput(scanner);

                switch (choice) {
                    case 1:
                        int gcd = calculateNOD(number1, number2);
                        int lcm = calculateNOK(number1, number2);
                        System.out.println("Наибольший общий делитель (НОД) чисел " + number1 + " и " + number2 + ": " + gcd);
                        System.out.println("Наименьшее общее кратное (НОК) чисел " + number1 + " и " + number2 + ": " + lcm);
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено некорректное значение. Попробуйте еще раз.");
                scanner.nextLine(); // Очищаем буфер после ошибочного ввода
            }
        }
    }

    // Метод для чтения целочисленного ввода от пользователя
    public static int readIntegerInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено некорректное значение. Попробуйте еще раз.");
                scanner.nextLine(); // Очищаем буфер после ошибочного ввода
            }
        }
    }

    // Метод для вычисления НОД по алгоритму Евклида
    public static int calculateNOD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для вычисления НОК на основе НОДа
    public static int calculateNOK(int a, int b) {
        int nod = calculateNOD(a, b);
        return (a * b) / nod;
    }
}