import java.util.*;

public class PomodoroApp {

    public String mode;
    public String duration;
    public int time;

    public static void main(String[] parts) {
        System.out.println("Enter the mode and duration eg(work 25)");
        PomodoroApp app = new PomodoroApp();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye, Dont forget to rest ✨");
                break;
            } else {
                String[] parts = input.split("\\s+");
                if (
                    parts.length == 2 &&
                    (parts[0].equalsIgnoreCase("work") ||
                        parts[0].equalsIgnoreCase("break"))
                ) {
                    String mode = parts[0];
                    String time = parts[1];
                    int duration = Integer.parseInt(time);
                    PomoSession session = new PomoSession(mode, duration);
                    if (mode.equalsIgnoreCase("work")) {
                        workTimer(session.getDuration());
                    } else if (mode.equalsIgnoreCase("break")) {
                        breakTimer(session.getDuration());
                    }
                } else {
                    System.out.println("Incorrect input");
                }
            }
        }
    }

    public void workTimer(int duration) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "Running work timer for " + duration + " minutes ⏲️ "
        );
        int totalSeconds = duration * 60;
        int calculatedBreak = (int) (totalSeconds * 0.2);
        if (calculatedBreak > 20) {
            calculatedBreak = 20;
        }
        for (int i = totalSeconds; i >= 0; i--) {
            int minutes = i / 60;
            int seconds = i % 60;
            System.out.print(
                "\r⏱ " + String.format("%02d:%02d", minutes, seconds)
            );
            System.out.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("\n Timer Interrupted 🚧");
                break;
            }
            if (i == 0) {
                System.out.println("\nWork is completed 🛫");
                System.out.println("Would you like to take a break ⏳️");
                System.out.println("Y or N");
                char breakpoint = scanner.next().charAt(0);
                if (Character.toLowerCase(breakpoint) == 'y') {
                    System.out.println(
                        "This is auto generated break based on the work you have done 🛌🏻"
                    );
                    breakTimer(calculatedBreak / 60);
                } else if (Character.toLowerCase(breakpoint) == 'n') {
                    System.out.println("Should we get back to work ❓️");
                    System.out.println("Y or N");
                    char breakpointtwo = scanner.next().charAt(0);
                    if (Character.toLowerCase(breakpointtwo) == 'y') {}
                }
            }
        }
    }

    public void breakTimer(int duration) {
        System.out.println("running break timer for " + duration);
    }
}
