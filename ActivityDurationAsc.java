import java.util.Comparator;

public class ActivityDurationAsc implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2){
        int ascOrder = a1.getDuration() - a2.getDuration();
        return ascOrder;
    }
}
