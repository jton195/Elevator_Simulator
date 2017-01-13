package Controller;

import java.util.List;

import Core.Building;
import Core.Person;

/*
 * THE RULES ARE:
 * 1) Each elevator can only move up or down once per step.
 * 2) People automatically get in and out of elevators.
 * 3) If there are ever too many people, the simulation ends and gives you your final score.
 * 4) To determine how to move, you have access to the state of each of the 4 elevators (each elevator has a floor and a list of occupants), and the list of each of the waiting people (each has a location and a destination).
 * 		HINT: This means that this is a "game of perfect information", meaning your elevator controller can see the state of all elevators and all people waiting on all floors (take this as a strategic advantage).
 */
public interface ElevatorController {
	public void runElevator(Building building, List<Person> people);
}
