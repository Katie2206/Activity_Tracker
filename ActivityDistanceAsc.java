import java.util.Comparator;

public class ActivityDistanceAsc implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2){
        int ascOrder = (int)((a1.getDistance() - a2.getDistance())*100);
        return ascOrder;
    }
}
