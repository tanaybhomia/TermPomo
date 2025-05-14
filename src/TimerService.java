import java.time.Duration;

public class TimerService {

    private UserInteraction interaction;

    public TimerService(UserInteraction interaction) {
        this.interaction = interaction;
    }

    public void runWorkTimer(PomoSession session) {
        int totalSeconds = session.getDuration() * 60;
        int calculatedBreak = Math.min((int) (totalSeconds * 0.2), 20);
        countDown("🏗️", totalSeconds);

        System.out.println("Work Completed ✅");

        if (interaction.AskYesNo("Would you like to take a break 💆🏻 (Y/n)")) {
            System.out.println("Running Break ⏳️ -> this is an autogen break");
            countDown("🫁", calculatedBreak);
        } else if (
            interaction.AskYesNo(
                "Would you like to work another session 👩🏻‍🏭 (Y/n)"
            )
        ) {
            int newDuration = interaction.AskInt("Enter work duration ");
            session.setDuration(newDuration);
            runWorkTimer(session);
        }
    }

    public void runBreakTimer() {}

    public void countDown(String emoji, int totalSeconds) {
        for (int i = totalSeconds; i >= 0; i--) {
            int minutes = i / 60;
            int seconds = i % 60;
            System.out.println(
                "\r" +
                emoji +
                " " +
                String.format("%02d:%02d", minutes, seconds)
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
}
