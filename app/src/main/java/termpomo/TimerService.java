package termpomo;

public class TimerService {

    private UserInteraction interaction;

    public TimerService(UserInteraction interaction) {
        this.interaction = interaction;
    }

    public void runWorkTimer(PomoSession session) {
        clearConsole();
        int totalSeconds = session.getDuration() * 60;
        int calculatedBreak = Math.min((int) (totalSeconds * 0.2), 20);
        System.out.println("Work");
        countDown("🏗️", totalSeconds);

        System.out.println("\nWork Completed ✅");

        if (interaction.AskYesNo("Would you like to take a break 💆🏻 (Y/n) :")) {
            System.out.println("Running Break ⏳️ -> this is an autogen break");
            runBreakTimer(calculatedBreak / 60);
        } else if (
            interaction.AskYesNo(
                "\nWould you like to work another session 👩🏻‍🏭 (Y/n)"
            )
        ) {
            int newDuration = interaction.AskInt("Enter work duration ");
            session.setDuration(newDuration);
            runWorkTimer(session);
        }
    }

    public void runBreakTimer(int durationMinutes) {
        countDown("😴", durationMinutes * 60);
        System.out.println("\nBreak Finished 💪🏻");
        System.out.println("");
    }

    public void countDown(String emoji, int totalSeconds) {
        for (int i = totalSeconds; i >= 0; i--) {
            int minutes = i / 60;
            int seconds = i % 60;
            System.out.print(
                "\r" +
                emoji +
                " " +
                String.format(" %02d:%02d", minutes, seconds)
            );
            System.out.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("\n Timer Interupted 🚧");
                break;
            }
        }
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J\033[3J"); // Added \033[3J to clear scrollback buffer
        System.out.flush();
    }
}
