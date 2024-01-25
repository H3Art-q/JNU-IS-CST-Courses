package lab6.chapter10;
// 10.1

public class Time {
    private int hour;
    private int minute;
    private int second;

    Time() {
        this.hour = (int) ((System.currentTimeMillis() / 1000 / 60 / 60) % 24);
        this.minute = (int) ((System.currentTimeMillis() / 1000 / 60) % 60);
        this.second = (int) ((System.currentTimeMillis() / 1000) % 60);
    }

    Time(long elapseTime){
        this.hour = (int) ((elapseTime / 1000 / 60 / 60) % 24);
        this.minute = (int) ((elapseTime / 1000 / 60) % 60);
        this.second = (int) ((elapseTime / 1000) % 60);
    }

    Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(long elapseTime){
        this.hour = (int) ((elapseTime / 1000 / 60 / 60) % 24);
        this.minute = (int) ((elapseTime / 1000 / 60) % 60);
        this.second = (int) ((elapseTime / 1000) % 60);
    }

    public void displayTime() {
        System.out.printf("Time: %02d:%02d:%02d GMT\n", this.hour, this.minute, this.second);
    }
}
