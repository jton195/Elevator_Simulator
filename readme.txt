Introduction:
This project provides the base for the elevator simulator program.  The simulation works on the following rules:
1) There is one Elevator Controller per building.
2) There are four elevators per building.
3) There are ten floors per building, floor one through floor ten.
4) The elevator capacity is 6 occupants.
5) People waiting on a particular floor will automatically get on an elevator if the elevator passes the room, as long as there is room for those people.
6) People will automatically get off of the elevator as soon as they reach their destination floor.
7) Actions are broken down into steps.
8) On a particular step, each of the four elevators can go up one floor or go down one floor.
9) An Elevator controller has access to all of the information in the building, that is, the controller can see what floor each of the four elevators is on, what occupants each of the elevators has, and the list of people waiting for an elevator on all of the building's ten floors.
10) every n steps, a new person randomly appears at one of the building's ten floors and requests to be transported to another of the building's ten floors.  n is determined by the variable "SPAWN_RATE" in "Simulation.java".
11) If the number of people waiting exceeds some value x, the simulation ends and prints how long the Elevator Controller was able run as well as the number of people correctly transported.  x is determined by the variable "MAX_PEOPLE" in "Simulation.java"
12) The third input parameter defined in "Simulation.java" is "SLEEP_TIME", which determines how many milliseconds to wait between steps (this parameter has no bearing on the simulation, it is just there to allow the user to visually see what is happening at each step).


SimpleController:
Included is one example controller, SimpleController.java.  This controller only operates one elevator ever and is very short sighted.  Your controller can use all 4 elevators the building has to offer and plan routes up and down based on the list of waiting people on each floor.  SimpleController just trys to move one person at a time and sometimes happens to move others by accident.  Also, SimpleController waits for a person to happen to spawn on the floor with the elevator.  You controller is encouraged to seek floors with waiting people instead of waiting (Hint, your elevators should never stand still unless there is no one waiting for a ride!).


Challenge:
The challenge is to create an Elevator Controller which can transport as many people as possible before the queue fills up completely.  To do this, perform the following:
1) Load the project according to the steps in Installation
2) Create a new java file called whatever (WhateverElevatorController.java, for example).
3) Make this class implement ElevatorController.java and implement the required method (runElevator).
4) In Simulation.java, line 15 defines the elevator controller to use for the simulation.  Replace "SimpleController" with the name of your controller.  For example, line 15 would read:
	static final ElevatorController controller = new WhateverElevatorController();
5) Change the parameters discussed above and test your Elevator Controller.
6) You will be ranked based on the average of your final outputs, gradually making people spawn faster and faster.


Sub-challenge:
Rewrite "Drawer.java" to display information better (maybe some ascii graphics or javax.swing graphics).


Importing the Project into Eclipse:
1) Load eclipse with any workstation you want.
2) Go to File -> Import
3) Choose General -> Existing Projects into Workspace
4) Click Browse and select the folder this file is in by clicking Open.
5) Make sure ElevatorSimulator project is checked and click Finish

Purpose of the Challenge:
The number one purpose is to develop core Java skills.  Also, if you have not figured it out by now, the elevators symbolize how hard drives read data.  Each 'elevator' is a read head and the 'people' are data blocks which need to be read.  This should get you thinking about hard drives and diminishing returns on multi-platter hard disk drives (given a good enough algorithm, the elevator controller can keep up with any load with only 2 elevators, leaving the other 2 unused).