package hms.utils;

import java.util.Scanner;

public class Time {
    static int startTime = 800;
    static int endTime = 1800;
    static int breakStart = 1200;
    static int breakEnd = 1330;
    private int hour;
    private int minute;
    private int time;

    public Time(int time) {
        this.time = time;
        this.minute = time/100;
        this.hour = time%100;
        while (!checkTime()) {
            System.out.println("This time is not available.");
            Scanner sc = new Scanner(System.in);
            hour = sc.nextInt();
            minute = sc.nextInt();
            this.minute = minute;
            this.hour = hour;
            time = 100 * this.hour + this.minute;
        }
    }

    public Time(int hour, int minute) {
        time = 100 * hour + minute;
        this.minute = minute;
        this.hour = hour;
        while (!checkTime()) {
            System.out.println("This time is not available.");
            Scanner sc = new Scanner(System.in);
            hour = sc.nextInt();
            minute = sc.nextInt();
            this.minute = minute;
            this.hour = hour;
            time = 100 * this.hour + this.minute;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public Time getTime() {
        return this;
    }
    public int getIntTime(){
        return time;
    }

    public boolean checkTime() {
        if (minute % 100 != 0 || minute % 100 != 30) {
            System.out.println("Only 00/30 is allowed for minute.");
            return false;
        }
        if (hour >= 24 || hour <= 0) {
            System.out.println("Invalid time.");
            return false;
        }
        return true;
    }

    public int compareTo(Time cmpTime) {
        if (hour > cmpTime.getHour()) return 1;
        else if (hour < cmpTime.getHour()) return -1;
        else if (minute > cmpTime.getMinute()) return 1;
        else if (minute < cmpTime.getMinute()) return -1;
        else return 0;
    }

}
