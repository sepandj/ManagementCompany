/*
 * Class: CMSC203 
 * Instructor: Prf. Gary Thai
 * Project 4
 * Description: This program is used in a property management company
 * Due: 11/06/21 @11:59PM
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Sepand Jahrominejad
*/





public class ManagementCompany {
	
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	
	public ManagementCompany() {
		
		mgmFeePer = 0;
		name = "";
		properties = new Property[MAX_PROPERTY];
		taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer,
			int x, int y, int width, int depth) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x, y, width, depth);
	}
	
	ManagementCompany(ManagementCompany otherCompany){
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.name = otherCompany.name;
		this.plot = new Plot(otherCompany.plot);
		this.taxID = otherCompany.taxID;
		
		for(int i=0; i<MAX_PROPERTY; i++) {
			this.properties[i] = otherCompany.properties[i];
		}
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	int arrayCounter = 0;
	public int addProperty(Property property) {
		
		
		int returnInt = arrayCounter;
		
		if(arrayCounter>=5) 
			return -1;
		
		else if(property == null)
			return -2;
		
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		if(arrayCounter>0) {
			for(int i=0; i<arrayCounter; i++) {
				if(properties[i].getPlot().overlaps(property.getPlot()))
					return -4;
			}
		}
		
				properties[arrayCounter] = new Property(property);
				arrayCounter++;
				return returnInt;
	}
	
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		
			int returnInt = arrayCounter;
			Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
			if(arrayCounter>=5)
				return -1;
			else if(property == null)
				return -2;
		
			else if(!plot.encompasses(property.getPlot()))
				return -3;
		
			if(arrayCounter>0) {
				for(int i=0; i<arrayCounter; i++) {
					if(properties[i].getPlot().overlaps(plot))
					return -4;
				}
			}
		
			properties[arrayCounter] = new Property(property);
			arrayCounter++;
			return returnInt;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		
			int returnInt = arrayCounter;
			Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
		
			if(arrayCounter>=5)
			return -1;
			else if( property == null)
				return -2;
		
			else if(!plot.encompasses(property.getPlot()))
				return -3;
		
			if(arrayCounter>0) {
				for(int i=0; i<arrayCounter; i++) {
					if(properties[i].getPlot().overlaps(plot))
						return -4;
				}
		}
		
			properties[arrayCounter] = new Property(property);
			arrayCounter++;
			return returnInt;
	}
	
	
	public double totalRent() {
		double total = 0;
	
		for(int i = 0; i<arrayCounter;i++)
			total += properties[i].getRentAmount();
		
		return total;
	}
	
	public double maxRentProp() {
		double maxRent = 0;
		
		for(int i = 0; i<arrayCounter; i++) {
			if(properties[i].getRentAmount()>maxRent)
				maxRent = properties[i].getRentAmount();
		}
		return maxRent;
	}
	
	
	public int maxRentPropertyIndex() {
		
		int maxAt = 0;
		
		for(int i = 1; i<=arrayCounter; i++) {
			
			if(properties[i].getRentAmount()>properties[maxAt].getRentAmount())
				maxAt = i;
		}
		return maxAt;
	}
	
	public String displayPropertyAtIndex(int i) {
		
		return properties[i].toString();
	}
	
	public String toString() {
		String s = "List of the properties " + name + ", taxID: "
				+ taxID + "\n________________________________________";
		for(int i = 0; i<MAX_PROPERTY; i++) {
			s += properties[i].toString();
		}
		
		s += "________________________________________\n" +
		"total management Fee: " + maxRentProp()*mgmFeePer/100;
		
		return s;
	}
}
