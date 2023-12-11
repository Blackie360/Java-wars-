import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char tryAgain = 'y'; // Initialize tryAgain to a default value

        do {
            System.out.println("Enter the First number:");
            int num1 = scanner.nextInt();

            System.out.println("Enter the Second number:");
            int num2 = scanner.nextInt();

            Calc_operator calculator = new Calc_operator();

            System.out.println("Calculator Operators:");
            System.out.println("1. Addition\n2. Subtraction\n3. Division\n4. Multiplication\n5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            int result = 0;

            switch (choice) {
                case 1:
                    result = calculator.addition(num1, num2);
                    break;
                case 2:
                    result = calculator.subtraction(num1, num2);
                    break;
                case 3:
                    result = calculator.div(num1, num2);
                    break;
                case 4:
                    result = calculator.multiplication(num1, num2);
                    break;
                case 5:
                    System.out.println("Thanks for using my program!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    continue;
            }

            System.out.println("The total " + num1 + "+" + num2 + "= " + result);

            System.out.print("Do you want to try again? (y/n): ");
            tryAgain = scanner.next().charAt(0);

        } while (tryAgain == 'y' || tryAgain == 'Y');
    }
}

class Calc_operator {
    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Division by zero.");
            return 0;
        }
    }

    public int multiplication(int a, int b) {
        return a * b;
    }
}
