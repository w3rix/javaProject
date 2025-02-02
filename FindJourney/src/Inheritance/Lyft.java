package Inheritance;

public class Lyft extends TransportationCompany {
    private double tripFee;

    public Lyft(String companyName, double baseRate, double tripFee) {
        super(companyName, baseRate);
        this.tripFee = tripFee;
    }

    @Override
    public double calculateEarnings() {
        return baseRate * tripFee + 3;
    }
    
    public double calculateDiscount(double baseRate, double discountRate) {
        return calculateEarnings() - baseRate * discountRate;
    }
    
    public String toString() {
		return super.toString() + "\nTrip Fee: " + tripFee + "\nFee: " + calculateDiscount(baseRate, discountRate) + "\n\n";
	}
}