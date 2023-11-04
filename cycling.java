public class cycling extends Activity{
    private double kilometresPerHour;
    public cycling(String ActivityType, int Duration, String Date, double Distance, int AverageHeartRate, double kmh){
        super(ActivityType, Duration, Date, Distance, AverageHeartRate);
        this.kilometresPerHour = kmh;
    }

    public double getKilometresPerHour() {
        return kilometresPerHour;
    }
    public void setKilometresPerHour(double kilometresPerHour) {
        this.kilometresPerHour = kilometresPerHour;
    }
}
