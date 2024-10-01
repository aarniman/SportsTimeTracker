import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsTimeTracker {

    public static class Activity {
        private String sport;
        private int time;
        private String day;

        public Activity(String sport, int time, String day) {
            this.sport = sport;
            this.time = time;
            this.day = day;
        }

        public String getSport() {
            return sport;
        }

        public int getTime() {
            return time;
        }

        public String getDay() {
            return day;
        }

        @Override
        public String toString() {
            return "Sport: " + sport + ", Duration: " + time + "minutes, Day: " + day;
        }
    }

    public static List<Activity> activities;

    public SportsTimeTracker() {
        activities = new ArrayList<>();
    }

    public void addActivity(String sport, int time, String day) {
        activities.add(new Activity(sport, time, day));
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public int calculateTotalTime() {
        int totalTime = 0;
        for (Activity activity : activities) {
            totalTime += activity.getTime();
        }
        return totalTime;
    }

    public static void main(String[] args) {
        SportsTimeTracker sportsTimeTracker = new SportsTimeTracker();
        sportsTimeTracker.addActivity("Football", 60, "Monday");
        sportsTimeTracker.addActivity("Basketball", 30, "Tuesday");
        sportsTimeTracker.addActivity("Football", 30, "Wednesday");

        System.out.println("Logged activities:");
        for (Activity activity : sportsTimeTracker.getActivities()) {
            System.out.println(activity);
        }

        System.out.println("Total time spent on sports: " + sportsTimeTracker.calculateTotalTime() + " minutes");
    }
}
