import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calc(input);

    }

    public static String calc(String input) throws IOException {
        boolean arabicNumbers = true;
        String result;

        if (!input.isEmpty()) {
            String[] parsInput = pars(input);
            String operation = parsInput[1];
            Number values;
            int value1 = 0;
            int value2 = 0;

            try {
                if (11 > Integer.parseInt(parsInput[0]) && Integer.parseInt(parsInput[0]) > 0 && 11 > Integer.parseInt(parsInput[2]) && Integer.parseInt(parsInput[0]) > 0) {
                    value1 = Integer.parseInt(parsInput[0]);
                    value2 = Integer.parseInt(parsInput[2]);
                } else {
                    throw new IOException("При вводе вы вышли за пределы допустимых значений от 1 до 10 включительно");
                }
            } catch (NumberFormatException e) {
                arabicNumbers = false;
                System.out.println("Введены римские числа");
            }

            if (arabicNumbers) {
                values = new Arabic(value1, value2);
            } else {
                values = new Romes(parsInput[0], parsInput[2]);
            }

            if (operation.equals("+")) {
                values.sum();
            } else if (operation.equals("-")) {
                values.sub();
            } else if (operation.equals("/") || operation.equals(":")) {
                values.div();
            } else if (operation.equals("*") || operation.equals("x")) {
                values.mul();
            }

            if (arabicNumbers) {
                result = "Результат: " + values.getResult();
            } else {
                result = "Результат: " + values.getStringResult();
            }

            System.out.println(result);

            return result;
        } else throw new IOException("Вы ничего не ввели");
    }

    public static String[] pars(String scanner) throws IOException {
        String[] pars = scanner.split(" ");
        if (pars.length == 1) {
            throw new IOException("throws Exception //т.к. строка не является математической операцией или ввод ввида: a + b, a - b, a * b, a / b, не верен");
        } else if (pars.length != 3) {
            throw new IOException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else return pars;
    }

}