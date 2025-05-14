import java.util.Scanner;

public class PomodoroApp {

    public static void main(String[] args) {
        UserInteraction ui = new UserInteraction();
        TimerService timerService = new TimerService(ui);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter (mode) and (duration) eg(work 25)");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nGoodBye! Dont forget to take some rest");
                break;
            }
            String[] parts = input.split("\\s+");
            if (
                parts.length == 2 &&
                (parts[0].equalsIgnoreCase("work") ||
                    parts[0].equalsIgnoreCase("break"))
            ) {
                String mode = parts[0];
                int duration = Integer.parseInt(parts[1]);
                PomoSession session = new PomoSession(mode, duration);

                if (mode.equalsIgnoreCase("work")) {
                    timerService.runWorkTimer(session);
                } else {
                    timerService.runBreakTimer(duration);
                }
            } else {
                System.out.println("\nIncorrect input. Example: 'work 25'");
            }
        }
    }
}
