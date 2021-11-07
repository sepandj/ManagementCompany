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



public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0.0;
		plot = new Plot(0,0,1,1);
	}
	
	public Property(Property property) {
		
		this.city = property.city;
		this.owner = property.owner;
		this.propertyName = property.propertyName;
		this.rentAmount = property.rentAmount;
		this.plot = new Plot(property.getPlot());
	}
	
	public Property(String propertyName, String city, double rentAmount
			, String owner) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	public Property(String propertyName, String city, double rentAmount
			, String owner, int x, int y, int width, int depth) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		Plot p = new Plot(x, y, width ,depth);
		
		return p;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String toString() {
		
		return "\nProperty Name: " + propertyName +
				"\nLocated in " + city +
				"\nBelonging to: " + owner +
				"\nRent Amount: " + rentAmount
				+ "\n";
		
	}
}
