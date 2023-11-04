public class running extends Activity{
    private double kilometresPerHour;
    public running(String ActivityType, int Duration, String Date, double Distance, int AverageHeartRate, double kmh){
        super(ActivityType, Duration, Date, Distance, AverageHeartRate);
        this.kilometresPerHour = kmh;
    }

    public double getKilometresPerHour() {
        return kilometresPerHour;
    }
    public void setKilometresPerHour(double kilometresPerHour) {
        this.kilometresPerHour = kilometresPerHour;
    }

    public Intensity getIntensity(){
        if(kilometresPerHour < 4){
            return Intensity.VERY_LIGHT;
        }else if(kilometresPerHour >= 4 && kilometresPerHour < 8){
            return Intensity.LIGHT;
        }else if(kilometresPerHour >= 8 && kilometresPerHour < 12){
            return Intensity.MODERATE;
        }else if(kilometresPerHour >= 12 && kilometresPerHour < 16){
            return Intensity.VIGOROUS;
        }else if(kilometresPerHour >= 16 && kilometresPerHour < 24){
            return Intensity.VERY_VIGOROUS;
        }else{
            return Intensity.VERY_VIGOROUS;
        }
    }

}
