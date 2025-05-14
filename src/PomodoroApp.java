import java.util.Scanner;

public class PomodoroApp {

    public static void main(String[] args) {
        UserInteraction ui = new UserInteraction();
        TimerService timerService = new TimerService(ui);

        Scanner scanner = new Scanner(System.in);
    }
}
