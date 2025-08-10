package Activies;

public class Activity2 {

	public static void main(String[] args) {
		// Given Array
		int[] numArr = {10, 77, 10, 54, -11, 10};
		//Total sun of 10's
		int sum = 0;
		
		//Iteration through the array, finding 10's
		for (int num : numArr) {
			//Check if the number is 10
			if(num == 10) {
				//add value to sum
				sum += num;
				
			}
		if(sum >30) {
			break;
		}

	}
	//check the sum value
	if(sum == 30) {
		System.out.println("Sum value is: " + sum);
	}
	else {
		System.out.println("Sum value is not 30");
	}
	}
}


