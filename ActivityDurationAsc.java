import java.util.Comparator;

public class ActivityDurationAsc implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2){
        int ascOrder = a2.getDuration() - a1.getDuration();
        return ascOrder;
    }

}
