
public class Activity {

    private String ActivityType;
    private int Duration;
    private String Date;
    private double Distance;
    private int AverageHeartRate;

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
}
