import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException{
        
    }

    public static void displayMenu(){
        System.out.println("\n0. Exit");
        System.out.println("1. Display Activity Data");
    }

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

    public static void CSVDataTable(ArrayList<Activity> activities) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate");

        for(Activity a: activities) {
            System.out.printf("%-10s %-30s %-10d %-10f %-30d\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAverageHeartRate());
        }
    }
}
