import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();

            int choice;
            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid number.");
                scanner.next(); // عشان يتجاهل الادخال الغلط، وما يتخزن فالذاكره
                continue; // هذا الامر يرجعك للبدايه عشان تحاول مره ثانيه تدخل رقم
            }

            switch (choice) {
                case 1: performAddition(scanner); break;
                case 2: performSubtraction(scanner); break;
                case 3: performMultiplication(scanner); break;
                case 4: performDivision(scanner); break;
                case 5: performSquareRoot(scanner); break;
                case 6: performPower(scanner); break;
                case 7: performSine(scanner); break;
                case 8: performCosine(scanner); break;
                case 9: performTangent(scanner); break;
                case 10: performNaturalLog(scanner); break;
                case 11: performLogBase10(scanner); break;
                case 12: performAbsolute(scanner); break;
                case 13: performRound(scanner); break;
                case 14: performCeil(scanner); break;
                case 15: performFloor(scanner); break;
                case 16: performMin(scanner); break;
                case 17: performMax(scanner); break;
                case 0: running = false; break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== Scientific Calculator ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine");
        System.out.println("8. Cosine");
        System.out.println("9. Tangent");
        System.out.println("10. Natural Logarithm (ln)");
        System.out.println("11. Log Base 10");
        System.out.println("12. Absolute Value");
        System.out.println("13. Round");
        System.out.println("14. Ceiling");
        System.out.println("15. Floor");
        System.out.println("16. Minimum of Two Numbers");
        System.out.println("17. Maximum of Two Numbers");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
        return a / b;
    }

    public static double calculateSquareRoot(double a) {
        if (a < 0) throw new ArithmeticException("Cannot take square root of negative number.");
        return Math.sqrt(a);
    }

    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double calculateTangent(double degrees) {
        double radians = Math.toRadians(degrees);
        double cos = Math.cos(radians);
        if (Math.abs(cos) < 1e-10) throw new ArithmeticException("Tangent undefined at " + degrees + "°");
        return Math.tan(radians);
    }

    public static double calculateNaturalLogarithm(double a) {
        if (a <= 0) throw new ArithmeticException("Logarithm undefined for non-positive values.");
        return Math.log(a);
    }

    public static double calculateLogBase10(double a) {
        if (a <= 0) throw new ArithmeticException("Logarithm undefined for non-positive values.");
        return Math.log10(a);
    }

    public static double calculateAbsolute(double a) { return Math.abs(a); }
    public static long roundNumber(double a) { return Math.round(a); }
    public static double ceilingNumber(double a) { return Math.ceil(a); }
    public static double floorNumber(double a) { return Math.floor(a); }
    public static double findMin(double a, double b) { return Math.min(a, b); }
    public static double findMax(double a, double b) { return Math.max(a, b); }

    // Perform methods
    private static void performAddition(Scanner s) {
        System.out.print("Enter two numbers: ");
        System.out.println("Result: " + add(s.nextDouble(), s.nextDouble()));
    }

    private static void performSubtraction(Scanner s) {
        System.out.print("Enter two numbers: ");
        System.out.println("Result: " + subtract(s.nextDouble(), s.nextDouble()));
    }

    private static void performMultiplication(Scanner s) {
        System.out.print("Enter two numbers: ");
        System.out.println("Result: " + multiply(s.nextDouble(), s.nextDouble()));
    }

    private static void performDivision(Scanner s) {
        try {
            System.out.print("Enter numerator and denominator: ");
            System.out.println("Result: " + divide(s.nextDouble(), s.nextDouble()));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performSquareRoot(Scanner s) {
        try {
            System.out.print("Enter number: ");
            System.out.println("Result: " + calculateSquareRoot(s.nextDouble()));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performPower(Scanner s) {
        System.out.print("Enter base and exponent: ");
        System.out.println("Result: " + calculatePower(s.nextDouble(), s.nextDouble()));
    }

    private static void performSine(Scanner s) {
        System.out.print("Enter angle in degrees: ");
        System.out.println("Result: " + calculateSine(s.nextDouble()));
    }

    private static void performCosine(Scanner s) {
        System.out.print("Enter angle in degrees: ");
        System.out.println("Result: " + calculateCosine(s.nextDouble()));
    }

    private static void performTangent(Scanner s) {
        try {
            System.out.print("Enter angle in degrees: ");
            System.out.println("Result: " + calculateTangent(s.nextDouble()));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performNaturalLog(Scanner s) {
        try {
            System.out.print("Enter number: ");
            System.out.println("Result: " + calculateNaturalLogarithm(s.nextDouble()));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performLogBase10(Scanner s) {
        try {
            System.out.print("Enter number: ");
            System.out.println("Result: " + calculateLogBase10(s.nextDouble()));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performAbsolute(Scanner s) {
        System.out.print("Enter number: ");
        System.out.println("Result: " + calculateAbsolute(s.nextDouble()));
    }

    private static void performRound(Scanner s) {
        System.out.print("Enter number: ");
        System.out.println("Result: " + roundNumber(s.nextDouble()));
    }

    private static void performCeil(Scanner s) {
        System.out.print("Enter number: ");
        System.out.println("Result: " + ceilingNumber(s.nextDouble()));
    }

    private static void performFloor(Scanner s) {
        System.out.print("Enter number: ");
        System.out.println("Result: " + floorNumber(s.nextDouble()));
    }

    private static void performMin(Scanner s) {
        System.out.print("Enter two numbers: ");
        System.out.println("Result: " + findMin(s.nextDouble(), s.nextDouble()));
    }

    private static void performMax(Scanner s) {
        System.out.print("Enter two numbers: ");
        System.out.println("Result: " + findMax(s.nextDouble(), s.nextDouble()));
    }
}
