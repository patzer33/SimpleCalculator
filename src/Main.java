import java.util.Scanner;

public class Main {

    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String CYAN = "\u001B[36m";
    static final String BOLD = "\u001B[1m";
    static final String RESET = "\u001B[0m";
    static final int WIDTH = 32;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Header
        System.out.println(CYAN + "╔" + "═".repeat(WIDTH) + "╗");
        System.out.println("║" + center("CALCULATOR", WIDTH) + "║");
        System.out.println("╚" + "═".repeat(WIDTH) + "╝" + RESET);
        System.out.println();

        // Menu
        System.out.println(BOLD + "  [+]  Addition");
        System.out.println("  [-]  Subtraction");
        System.out.println("  [*]  Multiplication");
        System.out.println("  [/]  Division");
        System.out.println(RED + "  [E]  Exit" + RESET);
        System.out.println("─".repeat(WIDTH + 2));

        System.out.print("\n  Enter first number: ");
        double fnum = sc.nextDouble();

        while (true) {
            System.out.print("\n  Operator: ");
            String op = sc.next();

            if (op.equalsIgnoreCase("E")) break;

            System.out.print("  Number: ");
            double num = sc.nextDouble();

            switch (op) {
                case "+":
                    fnum += num;
                    break;
                case "-":
                    fnum -= num;
                    break;
                case "*":
                    fnum *= num;
                    break;
                case "/":
                    if (num == 0) {
                        System.out.println(RED + "  ⚠  Error: division by zero." + RESET);
                        continue;
                    }
                    fnum /= num;
                    break;
                default:
                    System.out.println(YELLOW + "  ⚠  Invalid operator. Use +, -, * or /." + RESET);
                    continue;
            }

            System.out.println("  " + "─".repeat(WIDTH));
            System.out.printf("  Partial result: " + GREEN + "%.2f" + RESET + "%n", fnum);
        }

        System.out.println("\n" + CYAN + "═".repeat(WIDTH + 2));
        System.out.printf("  Final result: " + BOLD + "%.2f" + RESET + CYAN + "%n", fnum);
        System.out.println("═".repeat(WIDTH + 2) + RESET);

        sc.close();
    }

    private static String center(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(padding);

    }
}