
public class  Activity {

    private String ActivityType;
    private int Duration;
    private String Date;
    private double Distance;
    private int AverageHeartRate;
    private double calories;

    public static enum Intensity{VERY_LIGHT, LIGHT, MODERATE, VIGOROUS, VERY_VIGOROUS};

    public String getActivityType() {
        return ActivityType;
    }

    public int getDuration() {
        return Duration;
    }

    public String getDate() {
        return Date;
    }

    public double getDistance() {
        return Distance;
    }

    public int getAverageHeartRate() {
        return AverageHeartRate;
    }

    public double getCalories(){
        return calories;
    }


    public void setActivityType(String activityType) {
        ActivityType = activityType;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public void setAverageHeartRate(int averageHeartRate) {
        AverageHeartRate = averageHeartRate;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
    public Activity(String activityType, int duration, String date, double distance, int averageHeartRate) {
        ActivityType = activityType;
        Date = date;
        Duration = duration;
        Distance = distance;
        AverageHeartRate = averageHeartRate;
        calories = 0;
    }

    public Activity() {
        ActivityType = "";
        Date = "";
        Duration = 0;
        Distance = 0;
        AverageHeartRate = 0;
        calories = 0;
    }



    @Override
    public String toString() {
        return "Activity{" +
                "ActivityType='" + ActivityType + '\'' +
                ", Date='" + Date + '\'' +
                ", Duration=" + Duration +
                ", Distance=" + Distance +
                ", AverageHeartRate=" + AverageHeartRate +
                '}';
    }
}
