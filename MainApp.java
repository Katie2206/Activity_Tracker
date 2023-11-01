import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void readFromCSV (String file, ArrayList<Activity> activity, boolean headers) throws IOException {
        File activityData = new File(file);
        Scanner read = new Scanner(activityData);
        String line;
        boolean headersChecked = false;
        while(read.hasNextLine()){
            line = read.nextLine();
            if(!headers || headers && headersChecked){
                if(line!=""){
                    Activity a = parseLine(line);
                    activity.add(a);
                }
            }else{
                headersChecked = true;
            }
        }
    }

    public static Activity parseLine(String line) throws IOException{
        String ActivityType;
        String Date;
        int Duration;
        double Distance;
        int AverageHeartRate;

        StringTokenizer st = new StringTokenizer(line, ",");

        ActivityType = st.nextToken();
        Date = st.nextToken();
        Duration = Integer.parseInt(st.nextToken().trim());
        Distance = Double.parseDouble(st.nextToken().trim());
        AverageHeartRate = Integer.parseInt(st.nextToken().trim());

        return new Activity(ActivityType, Date, Duration, Distance, AverageHeartRate);
    }

    public static void main(String[] args) throws IOException{
        ArrayList<Activity> activities = new ArrayList<>();
        readFromCSV("activity_data_10.csv", activities, true);
        readFromCSV("activity_data_50.csv", activities, true);
        readFromCSV("activity_data_100.csv", activities, true);
        readFromCSV("activity_data_1000.csv", activities, true);
        for(Activity a: activities){
            System.out.println(a.getActivityType() + "\t" + a.getDate() + "\t" + a.getDuration() + "\t" + a.getDistance() + "\t" + a.getAverageHeartRate());
        }
    }
}
