package Inheritance;

public class Cabify extends TransportationCompany {
    private double luxuryFee;

    public Cabify(String companyName, double baseRate, double luxuryFee) {
        super(companyName, baseRate);
        this.luxuryFee = luxuryFee;
    }

    @Override
    public double calculateEarnings() {
        return baseRate * luxuryFee + 4;
    }

    @Override
    public double calculateDiscount(double baseRate, double discountRate) {
        return calculateEarnings() - baseRate * discountRate;
    }
    
    public String toString() {
		return super.toString() + "\nLuxury Fee: " + luxuryFee + "\nFee: " + calculateDiscount(baseRate, discountRate) + "\n\n";
	}
}