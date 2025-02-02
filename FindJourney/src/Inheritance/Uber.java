package Inheritance;

public class Uber extends TransportationCompany {
    private double surgeMultiplier;

    public Uber(String companyName, double baseRate, double surgeMultiplier) {
        super(companyName, baseRate);
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double calculateEarnings() {
        return baseRate * surgeMultiplier + 5;
    }

    @Override
    public double calculateDiscount(double baseRate, double discountRate) {
        return calculateEarnings() - baseRate * discountRate;
    }

	@Override
	public String toString() {
		return super.toString() + "\nSurge Multiplier: " + surgeMultiplier + "\nFee: " + calculateDiscount(baseRate, discountRate) + "\n\n";
	}
    
    
}