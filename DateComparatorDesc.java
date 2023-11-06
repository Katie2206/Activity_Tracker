import java.util.Comparator;

public class DateComparatorDesc implements Comparator<Activity> {
    public int compare(Activity date1, Activity date2)
    {
        String[] d1 = date1.getDate().trim().split("/");
        String[] d2 = date2.getDate().trim().split("/");

        if(Integer.parseInt(d1[2]) == Integer.parseInt(d2[2]))
        {
            if(Integer.parseInt(d1[1]) == Integer.parseInt(d2[1]))
            {
                return Integer.parseInt(d2[0]) - Integer.parseInt(d1[0]);
            }
            return Integer.parseInt(d2[1]) - Integer.parseInt(d1[1]);
        }
        return Integer.parseInt(d2[2]) - Integer.parseInt(d1[2]);
    }
}
