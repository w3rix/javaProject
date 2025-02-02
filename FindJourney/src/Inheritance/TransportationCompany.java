package Inheritance;
import java.util.ArrayList;

import HasA.Driver;
import Interface.Discountable;

public abstract class TransportationCompany implements Discountable {
    protected String companyName;
    protected double baseRate;
    protected double discountRate;
    public static ArrayList<Driver> drivers = new ArrayList<>();

   
	public TransportationCompany() {
		
	}

	public TransportationCompany(String companyName, double baseRate) {
        this.companyName = companyName;
        this.baseRate = baseRate;
    }

    public abstract double calculateEarnings(); 


    @Override
	public String toString() {
		return "CompanyName: " + companyName + "\nBase Rate: " + baseRate;
	}

	
}