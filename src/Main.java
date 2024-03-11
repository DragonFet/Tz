import java.util.Scanner;

class Main {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static boolean isRomanNumeral(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c == 'I' || c == 'X' || c == 'V')) {
                return false;
            }
        }
        return true;
    }

    public static int findArithmeticOperatorIndex(String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '*' || c == '+' || c == '-' || c == '/') {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int convertToArabic(String num) {
        int result = 0;
        int prevValue = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int value;
            switch (c) {
                case 'I':
                    value = 1;
                    break;
                case 'V':
                    value = 5;
                    break;
                case 'X':
                    value = 10;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Roman numeral");
            }
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    public static String convertToRoman(int result) {
        if (result < 2 || result > 20) {
            throw new IllegalArgumentException("Result is out of range");
        }

        switch (result) {
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 11:
                return "XI";
            case 12:
                return "XII";
            case 13:
                return "XIII";
            case 14:
                return "XIV";
            case 15:
                return "XV";
            case 16:
                return "XVI";
            case 17:
                return "XVII";
            case 18:
                return "XVIII";
            case 19:
                return "XIX";
            case 20:
                return "XX";
            default:
                return null;
        }
    }

    public static void calc(String input) {
        int index = findArithmeticOperatorIndex(input);
        String firstNum = input.substring(0, index).trim();
        String secondNum = input.substring(index + 1).trim();
        boolean isRoman = isRomanNumeral(firstNum) && isRomanNumeral(secondNum);
        int result = 0;

        if (!isRoman && (Integer.parseInt(firstNum) < 1 || Integer.parseInt(firstNum) > 10 || Integer.parseInt(secondNum) < 1 || Integer.parseInt(secondNum) > 10)) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10 inclusive");
        }

        if (isRoman) {
            int first = convertToArabic(firstNum);
            int second = convertToArabic(secondNum);

            switch (input.charAt(index)) {
                case '+':
                    result = add(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(convertToRoman(result));
                    break;
                case '-':
                    result = subtract(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(convertToRoman(result));
                    break;
                case '*':
                    result = multiply(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(convertToRoman(result));
                    break;
                case '/':
                    result = divide(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(convertToRoman(result));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid arithmetic operator");
            }
        } else {
            int first = Integer.parseInt(firstNum);
            int second = Integer.parseInt(secondNum);

            switch (input.charAt(index)) {
                case '+':
                    result = add(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(result);
                    break;
                case '-':
                    result = subtract(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(result);
                    break;
                case '*':
                    result = multiply(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(result);
                    break;
                case '/':
                    result = divide(first, second);
                    if (result < 2 || result > 20) {
                        throw new IllegalArgumentException("Result is out of range");
                    }
                    System.out.println(result);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid arithmetic operator");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        calc(expression);
    }
}
