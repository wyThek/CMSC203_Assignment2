
/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: An application that will generate random number and allow the user to guess it. It will narrow down the range until the user guess it correctly.
 * Due: 9/27/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Yei Thek Wang
*/
import java.util.Scanner;

public class RandomNumberGuesser {

	/**
	 * The main method
	 * @param args
	 */
	public static void main(String[] args) {

		// declared variables
		int randNum, highGuess = 100, lowGuess = 1, nextGuess = 0;
		String tryAgain = "", tempInput;
		boolean trigger = true;
		Scanner s = new Scanner(System.in);

		randNum = RNG.rand();
		randNum =65;
		// out most for loop for whole program
		for (;;) {
			System.out.println("== Random Number Guesser ===========");
			System.out.println("Enter your first guess:");

			// infinite while loop: control by user after the guessed the correct number.
			while (trigger) {
				tempInput = s.nextLine();
				
				// This while loop check if the input is integer of not, continue to loop if input is not integer.
				while (0 == inputDataTypeValidation(tempInput)) {
					tempInput = s.nextLine();			// receive a new input
				}
				
				// assign the valid integer input to nextGuess
				nextGuess = inputDataTypeValidation(tempInput);

				// check if the user input is within range
				if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {

					// compare the user input with the random number
					System.out.println("Number of guesses is " + RNG.getCount() + ".");
					if (nextGuess == randNum) { // correct guess
						System.out.println("Congratulations, you guessed correctly.");
						highGuess = 100;
						lowGuess = 1;
						System.out.println("Try again? (yes or no)");
						RNG.resetCount();
						tryAgain = s.nextLine();
						if (tryAgain.equals("no") || tryAgain.equals("No")) {
							System.out.println("Thanks for playing...");
							s.close();
							System.exit(0); // terminate the program
						} else {
							System.out.println("\n");
							break;
						}
					} else if (nextGuess < randNum) { // too low
						System.out.println("Your guess is too low.");
						lowGuess = nextGuess;
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + ".");
					} else { // too high
						System.out.println("Your guess is too high.");
						highGuess = nextGuess;
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + ".");
					}

				}
			}
		}
	}

	/**
	 * This Method check if the user input is integer of not
	 * @param inputS 	String user input
	 * @return	return valid integer as user's guess, else return 0 when input is not integer data type.
	 */
	public static int inputDataTypeValidation(String inputS) {

		try {
			// convert the String data type into integer, exceptions will be thrown
			int x = Integer.parseInt(inputS);
			return x;
		} catch (NumberFormatException e) {
			// Here catch NumberFormatException
			System.out.println("Invalid input, please enter an integer number.");
			return 0;
		}

	}
}