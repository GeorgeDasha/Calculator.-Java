import java.io.IOException;
import java.util.Scanner;

public class Main {
   public static void main ( String [] args) throws IOException  {
      Scanner scanner = new Scanner(System.in);
    System.out.println("Введите первое, второе число и знак между ними");
    String input = scanner.nextLine();
    System.out.println(calc(input));
    }
public static String calc(String input) throws IOException {
    int number1;
    int number2;
    String oper;
    String result;
    boolean Myroman;
    String[] operation = input.split("[+\\-*/]");
    if (operation.length != 2) throw new IOException("должно быть два числа");
    oper = detectoperation(input);
    if (oper == null) throw new IOException("нет такой операции");
    if (Rim.Myroman(operation[0]) && Rim.Myroman(operation[1])) {
        number1 = Rim.converttoarab(operation[0]);
        number2 = Rim.converttoarab(operation[1]);
        Myroman = true;
    } else if (!Rim.Myroman(operation[0]) && !Rim.Myroman(operation[1])) {
        number1 = Integer.parseInt(operation[0]);
        number2 = Integer.parseInt(operation[1]);
        Myroman = false;
    } else {
        throw new IOException("Введите 2 числа одной системы исчесления");
    }
    if (number1 > 10 || number2 > 10) {
        throw new IOException();
    }
    int arab = calc(number1, number2, oper);
    if (Myroman) {
        if (arab <= 0) {
            throw new IOException("Римское число должно быть больше нуля");
        }
        result = Rim.converttoroman(arab);
    } else {
        result = String.valueOf(arab);
    }
    return result;
}
    static String detectoperation (String output) {
        if (output.contains("+")) return "+";
        if (output.contains("-")) return "-";
        if (output.contains("*")) return "*";
        if (output.contains("/")) return "/";
else return null;
    }
    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        if (oper.equals("-")) return a - b;
        if (oper.equals("*")) return a * b;
        else return a / b;
    }
    class Rim {
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        public static boolean Myroman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        public static int converttoarab(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        public static String converttoroman(int arab) {
            return romanArray[arab];
        }
    }


}