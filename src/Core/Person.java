package Core;

public class Person {
	private int location;
	private int destination;
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	public String toString() {
		return "{LOCATION:" + location + ", DESTINATION:" + destination + "}";
	}
}
