package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Controller.ElevatorController;
import Controller.SimpleController;

public class Simulation {
	static final int SPAWN_RATE = 10;
	static final int SLEEP_TIME = 0;
	static final int MAX_PEOPLE = 50;
	
	static final ElevatorController controller = new SimpleController();
	
	static int score = 0;
	static int iterationCount = 0;
	static Building building = new Building();
	static List<Person> people = new ArrayList<Person>();
	
	//boolean to tell if someone has spawned this tick
	public static boolean spawned = false;
	
	public static void main(String[] args) {
		int spawnCt = 0;
		while (true) {
			iterationCount++;
			
			//	Sleep (to make the application human readable)
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//	Remove people who are already at their destination
			for (Elevator elevator : building.getElevators()) {
				for (int i = elevator.getOccupants().size()-1; i >= 0; i--) {
					Person occupant = elevator.getOccupants().get(i);
					if (occupant != null) {
						if (occupant.getDestination() == occupant.getLocation()) {
							elevator.removeOccupant(occupant);
							score++;
						}
					}
				}
				elevator.resetMove();
			}
						
			//	Spawn new people
			spawnCt++;
			if (spawnCt >= SPAWN_RATE) {
				//	Randomly create a new person
				Person newPerson = new Person();
				newPerson.setDestination(randInt(1, 10));
				int location = randInt(1, 10);
				while (location == newPerson.getDestination()) {
					location = randInt(1, 10);
				}
				newPerson.setLocation(location);
				people.add(newPerson);
				spawned = true;
				spawnCt = 0;
			} 
			else {
				spawned = false;
			}
			
			//	Run the elevator controller
			controller.runElevator(building, people);
			
			//	Push new people into the elevator
			for (Elevator elevator : building.getElevators()) {
				for (int i = people.size()-1; i >= 0; i--) {
					Person person = people.get(i);
					if (elevator.getFloor() == person.getLocation()) {
						try {
							elevator.addOccupant(person);
							people.remove(i);
						} catch (Exception e) {  
							//  THE ELEVATOR IS FULL  //
						}
					}
				}
			}
			
			if (people.size() >= MAX_PEOPLE) {
				System.out.println("TOO MANY PEOPLE WAITING -- BUILDING COLLAPSED UNDER ALL OF THE WEIGHT OF ALL THE PEOPLE YOU DISAPPOINTED.  GOOD JOB.");
				System.out.println("FINAL SCORE IS " + score);
				System.out.println("NUMBER OF STEPS IS " + iterationCount);
				System.exit(0);
			}
			
			//	Draw
			Drawer.draw(people, building);
		}
	}
	public static int randInt(int min, int max) {
	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}
