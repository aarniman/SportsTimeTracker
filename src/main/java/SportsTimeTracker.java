import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to record and track done activities and time spent on sports activities
public class SportsTimeTracker {

    // Inner class to represent an activity
    public static class Activity {
        private String sport;
        private int time;
        private String day;

        // Constructor
        public Activity(String sport, int time, String day) {
            this.sport = sport;
            this.time = time;
            this.day = day;
        }

        // Getters
        public String getSport() {
            return sport;
        }

        public int getTime() {
            return time;
        }

        public String getDay() {
            return day;
        }

        // Override toString method
        @Override
        public String toString() {
            return "Sport: " + sport + ", Duration: " + time + "minutes, Day: " + day;
        }
    }

    public static List<Activity> activities;

    // Constructor
    public SportsTimeTracker() {
        activities = new ArrayList<>();
    }

    // Adds a new activity to the list which includes the sport, time spent on the sport and the day of the week
    public void addActivity(String sport, int time, String day) {
        activities.add(new Activity(sport, time, day));
    }

    // Lists all recorded activities
    public List<Activity> getActivities() {
        return activities;
    }

    // Calculate total time spent on all Sports activities
    public int calculateTotalTime() {
        int totalTime = 0;
        for (Activity activity : activities) {
            totalTime += activity.getTime();
        }
        return totalTime;
    }

    public static void main(String[] args) {

        // Create a new SportsTimeTracker object
        SportsTimeTracker sportsTimeTracker = new SportsTimeTracker();
        sportsTimeTracker.addActivity("Football", 60, "Monday");
        sportsTimeTracker.addActivity("Basketball", 30, "Tuesday");
        sportsTimeTracker.addActivity("Football", 30, "Wednesday");

        // Print all activities and their details
        System.out.println("Logged activities:");
        for (Activity activity : sportsTimeTracker.getActivities()) {
            System.out.println(activity);
        }

        // Print total time spent on sports
        System.out.println("Total time spent on sports: " + sportsTimeTracker.calculateTotalTime() + " minutes");
    }
}
