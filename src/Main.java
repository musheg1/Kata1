import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");
        String input = sc.nextLine();
        String result = calc(input);
        System.out.println("Output: \n" + result);
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
        }

        String first = parts[0];
        String operator = parts[1];
        String second = parts[2];

        boolean isRoman1 = isRomanNumber(first);
        boolean isRoman2 = isRomanNumber(second);

        if ((isRoman1 && !isRoman2) || (!isRoman1 && isRoman2)) {
            throw new Exception("Используются разные системы исчисления");
        }

        int num1;
        int num2;

        if (isRoman1 && isRoman2) {
            num1 = Converter.romanToArabic(first);
            num2 = Converter.romanToArabic(second);
        } else {
            num1 = Integer.parseInt(first);
            if (num1>10) throw new Exception("Вы ввели число больше 10 (Х)");
            num2 = Integer.parseInt(second);
            if (num2>10) throw new Exception("Вы ввели число больше 10 (Х)");
        }


        int result = performOperation(operator, num1, num2);

        if (isRoman1 && isRoman2) {
            if (result < 1) {
                throw new Exception("Результат не может быть представлен в римской системе исчисления");
            } else {
                return Converter.arabicToRoman(result);
            }
        } else {
            return String.valueOf(result);
        }
    }

    private static boolean isRomanNumber(String input) {
        return input.matches("^[IVXLC]+$");
    }

    private static int performOperation(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция");
        }
    }
}
