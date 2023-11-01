import java.util.Comparator;

public class DateComparator implements Comparator<Activity> {
    public int compare(Activity date1, Activity date2){
        return date1.getDate().compareTo(date2.getDate());
    }
}
