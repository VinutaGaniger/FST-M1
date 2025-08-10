package Activies;

public class Activity1 {

	public static void main(String[] args) {
		// Create objects of car
      Car honda = new Car("Black","Automatic", 2020);
      
      //Print details of car
      honda.displayCharacteristics();
      //Move the Car
      honda.accelerate();
      //Stop the Car
      honda.brake();
	}

}
