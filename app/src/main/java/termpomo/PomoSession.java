package termpomo;

public class PomoSession {

    private String mode;
    private int duration;

    public PomoSession(String mode, int duration) {
        this.mode = mode.toLowerCase();
        this.duration = duration;
    }

    public String getMode() {
        return mode;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
