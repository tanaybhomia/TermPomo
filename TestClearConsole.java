public class TestClearConsole {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, this will clear in 2 seconds...");
        Thread.sleep(2000);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Console cleared ✅");
    }
}
