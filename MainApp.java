import java.io.File;
import java.io.IOException;
import java.util.*;

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
        System.out.println("7. Display Activity Data By Activity Type (Alphabetical Order)");
        System.out.println("8. Display Activity Data By Distance (Ascending)");
        System.out.println("9. Display Activity Data By Distance (Descending)");
        System.out.println("10. Display Activity Data By Minimum Duration");
        System.out.println("11. Display Activity Data By Minimum Distance");
        System.out.println("12. Display Average of Distance per Activity");
        System.out.println("13. Display Average of Calories per Activity");
        System.out.println("14. Display Subset Of Activity Data By Activity Type");
        System.out.println("15. Display Activity Type With Natural Ordering Using Binary Search");
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

    public static double calculateKmH(Activity a){

        double KmH = 0;
        double hours = 0;

        hours = (double)a.getDuration()/60;
        KmH = a.getDistance()/hours;

        return KmH;
    }

    public static void calculateCalories(ArrayList<Activity> activities){
        double KmH = 0;

        double calories = 0;

        for (Activity a : activities){

            KmH = calculateKmH(a);
            if (a.getActivityType().equals("Running")){
                if (KmH < 4){
                    calories = a.getDuration()*4.1;
                    a.setIntensity(String.valueOf(Activity.Intensity.VERY_LIGHT));
                } else if (KmH >= 4 && KmH < 8 ) {
                    calories = a.getDuration()*7.2;
                    a.setIntensity(String.valueOf(Activity.Intensity.LIGHT));
                }
                else if (KmH >= 8 && KmH < 12 ) {
                    calories = a.getDuration()*10;
                    a.setIntensity(String.valueOf(Activity.Intensity.MODERATE));
                }
                else if (KmH >= 12 && KmH < 16 ) {
                    calories = a.getDuration()*15.4;
                    a.setIntensity(String.valueOf(Activity.Intensity.VIGOROUS));
                }else if (KmH >= 16 ) {
                    calories = a.getDuration()*20.8 ;
                    a.setIntensity(String.valueOf(Activity.Intensity.VERY_VIGOROUS));
                }
            }
            else if (a.getActivityType().equals("Swimming")){
                if (KmH < 0.5){
                    calories = a.getDuration()*5;
                    a.setIntensity(String.valueOf(Activity.Intensity.VERY_LIGHT));
                } else if (KmH >= 0.25 && KmH < 1.25 ) {
                    calories = a.getDuration()*6.3;
                    a.setIntensity(String.valueOf(Activity.Intensity.LIGHT));
                }
                else if (KmH >= 1.25 && KmH < 2) {
                    calories = a.getDuration()*7.6;
                    a.setIntensity(String.valueOf(Activity.Intensity.MODERATE));
                }
                else if (KmH >= 2 && KmH < 2.75 ) {
                    calories = a.getDuration()*8.9;
                    a.setIntensity(String.valueOf(Activity.Intensity.VIGOROUS));
                }else if (KmH >= 2.75 ) {
                    calories = a.getDuration()*10.2  ;
                    a.setIntensity(String.valueOf(Activity.Intensity.VERY_VIGOROUS));
                }
            }
            else if (a.getActivityType().equals("Cycling")){
                if (KmH < 8){
                    calories = a.getDuration()*2;
                    a.setIntensity(String.valueOf(Activity.Intensity.VERY_LIGHT));
                } else if (KmH >= 8 && KmH < 16 ) {
                    calories = a.getDuration()*5;
                    a.setIntensity(String.valueOf(Activity.Intensity.LIGHT));
                }
                else if (KmH >= 16 && KmH < 25) {
                    calories = a.getDuration()*7;
                    a.setIntensity(String.valueOf(Activity.Intensity.MODERATE));
                }
                else if (KmH >= 25 && KmH < 33 ) {
                    calories = a.getDuration()*13;
                    a.setIntensity(String.valueOf(Activity.Intensity.VIGOROUS));
                }else if (KmH >= 33) {
                    calories = a.getDuration()*15 ;
                    a.setIntensity(String.valueOf(Activity.Intensity.VERY_VIGOROUS));
                }
            }
            a.setCalories(calories);
        }
    }


    public static void averageDistance(ArrayList<Activity> activities /*String chosenActivity*/){
        /*double count = 0;
        double sum = 0;*/
         double countRun = 0;
         double countSwim = 0;
         double countCycle = 0;
         double sumRun = 0;
         double sumSwim = 0;
         double sumCycle = 0;
         double avrgDistanceRun = 0.0;
         double avrgDistanceSwim = 0.0;
         double avrgDistanceCycle = 0.0;
       // double avrgDistance = 0.0;
         /*for (Activity a : activities){
             if (a.getActivityType().equals(chosenActivity)){
                 sum+= a.getDistance();
                 count++;
             }

         }
         avrgDistance = sum/count;

         System.out.printf("You did %s for an average of %.2fKM%n",  chosenActivity, avrgDistance);*/

         for (Activity a : activities){
             if (a.getActivityType().equals("Running")){
                 sumRun+= a.getDistance();
                 countRun++;
             }
             else if (a.getActivityType().equals("Swimming")){
                 sumSwim+= a.getDistance();
                 countSwim++;
             }
             else if (a.getActivityType().equals("Cycling")){
                 sumCycle+= a.getDistance();
                 countCycle++;
             }

         }
         avrgDistanceRun = sumRun/countRun;
          avrgDistanceSwim = sumSwim/countSwim;
        avrgDistanceCycle = sumCycle/countCycle;

         System.out.println("--------- Average Distance --------- ");
         System.out.printf("Running: %.2fKM %nSwimming: %.2fKM %nCycling: %.2fKM %n", avrgDistanceRun, avrgDistanceSwim, avrgDistanceCycle);

     }

    public static void averageCalories(ArrayList<Activity> activities ){

        double countRun = 0;
        double countSwim = 0;
        double countCycle = 0;
        double sumRun = 0;
        double sumSwim = 0;
        double sumCycle = 0;
        double avrgCaloriesRun = 0.0;
        double avrgCaloriesSwim = 0.0;
        double avrgCaloriesCycle = 0.0;

        for (Activity a : activities){
            if (a.getActivityType().equals("Running")){
                sumRun+= a.getCalories();
                countRun++;
            }
            else if (a.getActivityType().equals("Swimming")){
                sumSwim+= a.getCalories();
                countSwim++;
            }
            else if (a.getActivityType().equals("Cycling")){
                sumCycle+= a.getCalories();
                countCycle++;
            }

        }
        avrgCaloriesRun = sumRun/countRun;
        avrgCaloriesSwim = sumSwim/countSwim;
        avrgCaloriesCycle = sumCycle/countCycle;

        System.out.println("--------- Average Calories --------- ");
        System.out.printf("Running: %.2fKcal %nSwimming: %.2fKcal %nCycling: %.2fKcal %n", avrgCaloriesRun, avrgCaloriesSwim, avrgCaloriesCycle);

    }

    public static void displayActivitiesBinary(ArrayList<Activity> activities){
        Comparator<Activity> compareActivityType = (a1, a2) -> a1.getActivityType().compareToIgnoreCase(a2.getActivityType());
        activities.sort(compareActivityType);
        Activity keyType = new Activity("Running", "16/01/2020", 42,  4.46, 139);
        int index = Collections.binarySearch(activities, keyType, compareActivityType);
        if(index >= 0){
            System.out.println("Sorted " + activities.get(index) + " At Line " + index);
        }else{
            System.out.println("Activity Not Found");
        }
    }

    public static void displayActivity(String activityType, ArrayList<Activity> activities){
        ArrayList<Activity> activityWanted = new ArrayList<>();

        for(Activity a: activities){
            if(a.getActivityType().equalsIgnoreCase(activityType)){
                activityWanted.add(a);
            }
        }

        Comparator<Activity> activityTypeComparator = new Comparator<Activity>() {
            public int compare(Activity a1, Activity a2) {
                return a1.getActivityType().compareToIgnoreCase(a2.getActivityType());
            }

        };

        CSVDataTable(activityWanted);
    }

    public static void CSVDataTable(ArrayList<Activity> activities) {
        System.out.printf("%-19s %-10s %-10s %-10s %-10s %10s %15s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate", "Calories", "Intensity");
//        for(Activity a: activities) {
//            System.out.printf("%-10s %-30s %-10d %-10f %-30d\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAverageHeartRate());
//        }
        activities.forEach((a) -> {System.out.printf("%-15s %-17s %-10d %-15.2f %-5d %15.2f %15s\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAverageHeartRate(), a.getCalories(), a.getIntensity());});
    }


    public static void displayAboveMinDistance(double aboveThisDistance, ArrayList<Activity> activities){
        ArrayList<Activity> dataWanted = new ArrayList<>();
        for(Activity a: activities){
            if(a.getDistance() >= aboveThisDistance){
                dataWanted.add(a);
            }
        }
        CSVDataTable(dataWanted);
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
        readFromCSV("activity_data_50.csv", activities, true);
        readFromCSV("activity_data_100.csv", activities, true);
        readFromCSV("activity_data_1000.csv", activities, true);

        Comparator<Activity> activityTypeComparator = new Comparator<Activity>() {
            public int compare(Activity a1, Activity a2) {
                return a1.getActivityType().compareToIgnoreCase(a2.getActivityType());
            }
        };
        Comparator<Activity> caloriesComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity c1, Activity c2) {
                return (int)((c2.getCalories() - c1.getCalories()));
            }
        };

        calculateCalories(activities);
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
//                    Collections.sort(activities, caloriesComparator);
                    Comparator<Activity> compare = (a1, a2) -> (int)(a2.getCalories() - (a1.getCalories()));
                    activities.sort(compare);
                    CSVDataTable(activities);
                    break;
                case 3:
                    Collections.sort(activities, new DateComparator());
                    CSVDataTable(activities);
                    break;
                case 4:
                    Collections.sort(activities, new DateComparatorDesc());
                   CSVDataTable(activities);
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
//                    Collections.sort(activities, activityTypeComparator);
                    Comparator<Activity> compareActivities = (a1, a2) -> a1.getActivityType().compareToIgnoreCase(a2.getActivityType());
                    activities.sort(compareActivities);
                    CSVDataTable(activities);
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
                case 11:
                    System.out.println("Insert Distance");
                    int aboveThisDistance = kbrd.nextInt();
                    displayAboveMinDistance(aboveThisDistance, activities);
                    break;
                case 12:
                    averageDistance(activities);
                    break;

                case 13:
                    averageCalories(activities);
                    break;

                case 14:
                    System.out.println("Enter Activity Type");
                    String activityType = kbrd.nextLine();
                    displayActivity(activityType, activities);
                    break;
                case 15:
//                    System.out.println("Enter Activity Wanted");
//                    String keyType = kbrd.nextLine();
                    displayActivitiesBinary(activities);
            }

        }while(choice != 0);

    }
}
