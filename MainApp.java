import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException{
        CSVDataDisplayed();
    }

    public static void displayMenu(){
        System.out.println("\n0. Exit");
        System.out.println("1. Display Activity Data (Original Order)");
        System.out.println("2. Display Activity Data By Calories Burned (Descending)");
        System.out.println("3. Display Activity Data By Date (Ascending)");
        System.out.println("4. Display Activity Data By Date (Descending)");
        System.out.println("5. Display Activity Data By Duration (Ascending)");
        System.out.println("6. Display Activity Data By Duration (Descending)");
        System.out.println("7. Display Activity Data By Activity Type");
        System.out.println("8. Display Activity Data By Distance (Ascending)");
        System.out.println("9. Display Activity Data By Distance (Descending)");
        System.out.println("10. Display Activity Data By Minimum Duration");
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
        System.out.printf("%-19s %-10s %-10s %-10s %-10s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate");

//        for(Activity a: activities) {
//            System.out.printf("%-10s %-30s %-10d %-10f %-30d\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAverageHeartRate());
//        }
        activities.forEach((a) -> {System.out.printf("%-15s %-17s %-10d %-15.2f %-5d\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAverageHeartRate());});
    }

    public static void displayMinDuration(int wantedDuration, ArrayList<Activity> activities ){
        ArrayList<Activity> newData = new ArrayList<>();

        for(Activity a: activities){
            if(a.getDuration() >= wantedDuration){
                newData.add(a);
            }
        }

        CSVDataTable(newData);
    }

    public static void CSVDataDisplayed() throws IOException{
        ArrayList<Activity> activities = new ArrayList<>();
        readFromCSV("activity_data_10.csv", activities, true);
//        readFromCSV("activity_data_50.csv", activities, true);
//        readFromCSV("activity_data_100.csv", activities, true);
//        readFromCSV("activity_data_1000.csv", activities, true);

        Scanner kbrd = new Scanner(System.in);
        int choice = 0;

        do{
            displayMenu();
            choice = kbrd.nextInt();
            kbrd.nextLine();

            switch(choice){
                case 1:
                    CSVDataTable(activities);
                    break;
                case 2:
                    System.out.println("Calories");
                    break;
                case 3:
                    System.out.println("Date (Ascending)");
//                    CSVDataTable(activities);
                    break;
                case 4:
                    System.out.println("Date (Descending)");
//                    CSVDataTable(activities);
                    break;
                case 5:
                    Collections.sort(activities, new ActivityDurationAsc());
                    CSVDataTable(activities);
                    break;
                case 6:
                    Collections.sort(activities, new ActivityDurationDesc());
                    CSVDataTable(activities);
                    break;
                case 7:
                    System.out.println("Activity Type");
//                    CSVDataTable(activities);
                    break;
                case 8:
                    Collections.sort(activities, new ActivityDistanceAsc());
                    CSVDataTable(activities);
                    break;
                case 9:
                    Collections.sort(activities, new ActivityDistanceDesc());
                    CSVDataTable(activities);
                    break;
                case 10:
                    System.out.println("Insert Duration (In Mins)");
                    int wantedDuration = kbrd.nextInt();
                    displayMinDuration(wantedDuration, activities);
                    break;

            }

        }while(choice != 0);

    }
}
