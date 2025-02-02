package HasA;
public class Driver implements Comparable<Driver>{
    private String driverName;
    private double driverRating;
    private String driverCompany;

    public Driver(String driverName, double driverRating, String driverCompany) {
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.driverCompany = driverCompany;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getDriverRating() {
        return driverRating;
    }

    public String getDriverInfo() {
        return "\n\nDriver: " + driverName + "\nRating: " + driverRating + "\nCompany: " + driverCompany; 
    }

	@Override
	public int compareTo(Driver o) {
		// TODO Auto-generated method stub
		return driverName.compareTo(o.driverName);
	}
}
