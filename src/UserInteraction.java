import java.util.Scanner;

public class UserInteraction {

    private final Scanner scanner = new Scanner(System.in);

    public boolean AskYesNo(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    public int AskInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number , Please try again");
            }
        }
    }
}
