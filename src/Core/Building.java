package Core;

public class Building {
	private Elevator[] elevators;
	
	public Building() {
		//	There are four elevators per building
		elevators = new Elevator[4];
		for (int i = 0; i < elevators.length; i++) {
			elevators[i] = new Elevator();
		}
	}
	
	public Elevator[] getElevators() {
		return elevators;
	}
	
	public String toString() {
		String ret = "{";
		
		for (int i = 0; i < elevators.length; i++) {
			ret += "ELEVATOR" + i + ":" + elevators[i] + ",\n";
		}
		
		ret = ret.substring(0, ret.length()-2);
		ret += "}";
		
		return ret;
	}
}
