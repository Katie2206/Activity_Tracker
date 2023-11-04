import java.util.Comparator;
public class ActivityDistanceDesc implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2){
        int DescOrder = (int)((a2.getDistance() - a1.getDistance())*100);
        return DescOrder;
    }
}
