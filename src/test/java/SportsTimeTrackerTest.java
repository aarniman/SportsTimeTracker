import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

// Test class for SportsTimeTracker
public class SportsTimeTrackerTest {
    private SportsTimeTracker tracker;

    // Create a new instance of SportsTimeTracker before each test to ensure that the tests are independent
    @Before
    public void setUp() {
        tracker = new SportsTimeTracker();
    }

    // Test the addActivity method by adding a single activity and checking if it was added correctly
    @Test
    public void testAddActivity() {
        tracker.addActivity("Football", 60, "Monday");
        List<SportsTimeTracker.Activity> activities = tracker.getActivities();
        assertEquals(1, activities.size());
        assertEquals("Football", activities.get(0).getSport());
        assertEquals(60, activities.get(0).getTime());
        assertEquals("Monday", activities.get(0).getDay());
    }

    // Test the calculateTotalTime method by adding a single activity and checking if the total time is calculated correctly
    @Test
    public void testCalculateTotalTime_SingleActivity() {
        tracker.addActivity("Football", 60, "Monday");
        assertEquals(60, tracker.calculateTotalTime());
    }

    // Test the calculateTotalTime method by adding multiple activities and checking if the total time is calculated correctly
    @Test
    public void testCalculateTotalTime_MultipleActivities() {
        tracker.addActivity("Football", 60, "Monday");
        tracker.addActivity("Basketball", 90, "Tuesday");
        tracker.addActivity("Swimming", 45, "Wednesday");
        assertEquals(195, tracker.calculateTotalTime());
    }

    // Test the calculateTotalTime method with no activities added that the total time is 0
    @Test
    public void testCalculateTotalTime_NoActivities() {
        assertEquals(0, tracker.calculateTotalTime());
    }

    // Test the viewActivities method by adding multiple activities and checking if they are returned correctly
    @Test
    public void testViewActivities() {
        tracker.addActivity("Football", 60, "Monday");
        tracker.addActivity("Basketball", 90, "Tuesday");
        tracker.addActivity("Swimming", 45, "Wednesday");
        List<SportsTimeTracker.Activity> activities = tracker.getActivities();
        assertEquals(3, activities.size());
        assertEquals("Football", activities.get(0).getSport());
        assertEquals(60, activities.get(0).getTime());
        assertEquals("Monday", activities.get(0).getDay());
        assertEquals("Basketball", activities.get(1).getSport());
        assertEquals(90, activities.get(1).getTime());
        assertEquals("Tuesday", activities.get(1).getDay());
        assertEquals("Swimming", activities.get(2).getSport());
        assertEquals(45, activities.get(2).getTime());
        assertEquals("Wednesday", activities.get(2).getDay());
    }
}
