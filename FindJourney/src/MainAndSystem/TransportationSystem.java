package MainAndSystem;

import java.util.ArrayList;
import java.util.TreeSet;

import HasA.Driver;
import Inheritance.Cabify;
import Inheritance.Lyft;
import Inheritance.TransportationCompany;
import Inheritance.Uber;

public class TransportationSystem {
    
	public static ArrayList<TransportationCompany> compArr = new ArrayList<>();
   
    
    public static void addDriver(String driver, double rating, String company) {
        Driver dr = new Driver(driver, rating, company);
    	TransportationCompany.drivers.add(dr);
        
    }

    
    public static String displayDrivers() {
    	String st = "";
    	TreeSet<Driver> driverset = new TreeSet<>();
    	driverset.addAll(TransportationCompany.drivers);
        for (Driver driver : driverset) {
           st+=driver.getDriverInfo();
           }
        return st;
    }

    
    public static String searchDriver(String name) {
        for (Driver driver : TransportationCompany.drivers) {
            if (driver.getDriverName().equalsIgnoreCase(name)) {
                return driver.getDriverInfo();
            
            }
        }
        return null;
    }

    
    public static boolean deleteDriver(String driverName) {
      
        for (Driver driver : TransportationCompany.drivers) {
            if (driver.getDriverName().equalsIgnoreCase(driverName)) {
            	TransportationCompany.drivers.remove(driver);
            	return true;
            }
        }
        return false;
    }

    public static String calculateFee(String name, double baseRate, double fee, double discount)
    {
    	TransportationCompany temp = null;
    	switch (name) {
        case "Uber":
        	temp = new Uber(name, baseRate, fee);
            break;
        case "Lyft":
        	temp = new Lyft(name, baseRate, fee);
            break;
        case "Cabify":
        	temp = new Cabify(name, baseRate, fee);
            break;
    	}
    	String st = "";
    	st += "\nFee Without Discount: " + temp.calculateEarnings();
    	st += "\nFee With Discount: " + temp.calculateDiscount(baseRate, discount);
    	
    	compArr.add(temp);
    	
    	return st;
    }
    
    public static String displayTrips() {
    	String st = "";
    	for (TransportationCompany transportationCompany : compArr) {
			st += transportationCompany.toString();
		}
    	return st;
    }
    
  
}
