import java.util.Comparator;

public class ActivityDurationDesc implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2){
        int descOrder = a2.getDuration() - a1.getDuration();
        return descOrder;
    }
}
