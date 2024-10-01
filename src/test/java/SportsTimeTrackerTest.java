import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SportsTimeTrackerTest {
    private SportsTimeTracker tracker;

    @Before
    public void setUp() {
        tracker = new SportsTimeTracker();
    }

    @Test
    public void testAddActivity() {
        tracker.addActivity("Football", 60, "Monday");
        List<SportsTimeTracker.Activity> activities = tracker.getActivities();
        assertEquals(1, activities.size());
        assertEquals("Football", activities.get(0).getSport());
        assertEquals(60, activities.get(0).getTime());
        assertEquals("Monday", activities.get(0).getDay());
    }

    @Test
    public void testCalculateTotalTime_SingleActivity() {
        tracker.addActivity("Football", 60, "Monday");
        assertEquals(60, tracker.calculateTotalTime());
    }

    @Test
    public void testCalculateTotalTime_MultipleActivities() {
        tracker.addActivity("Football", 60, "Monday");
        tracker.addActivity("Basketball", 90, "Tuesday");
        tracker.addActivity("Swimming", 45, "Wednesday");
        assertEquals(195, tracker.calculateTotalTime());
    }

    @Test
    public void testCalculateTotalTime_NoActivities() {
        assertEquals(0, tracker.calculateTotalTime());
    }

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
