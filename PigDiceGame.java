import java.util.Scanner;

public class PigDiceGame {
	private static int totalScore = 0;
	private static int currentScore = 0;
	private static int turns = 1;
	private static int rolledValue;
	private static int sumValue;

	public static void rule() {
		System.out.println("Let's Play PIG!\n");
		System.out.println("* See how many turns it takes you to get to 20.");
		System.out.println("* Turn ends when you hold or roll a 1.");
		System.out.println("* If you roll a 1, you lose all points for the turn.");
		System.out.println("* If you hold, you save all points for the turn.\n");
	}

	public static void scoreUpdate() {
		System.out.println("Your turn score is " + currentScore + " and your total score is " + totalScore);
	}

	public static int diceRoll() {
		return (int) (Math.random() * 6 + 1);
	}

	public static void instruction() {
		System.out.println("Enter 'r' to roll again, 'h' to hold.");
	}

	public static void printRolledValue() {
		System.out.println("You rolled: " + rolledValue);
	}

	public static void incrementTurns() {
		turns++;
	}

	public static void wellWisherMsg() {
		int temp;
		temp = totalScore + sumValue;
		System.out.println("If you hold, you will have " + temp + " points.");
	}

	public static boolean roll() {
		rolledValue = diceRoll();
		if (rolledValue == 1) {
			currentScore = 0;
			incrementTurns();
			sumValue = 0;
			System.out.println("You rolled: 1\r\n" + "Turn over. No Score");
			return false;
		}
		currentScore += rolledValue;
		sumValue += rolledValue;

		return true;
	}

	public static void checkWin() {
		if (totalScore + sumValue >= 20) {
			printRolledValue();
			totalScore += sumValue;
			scoreUpdate();

			System.out.println("You Win! You finished in " + turns + " turns!\r\n" + "\r\n" + "Game over!");
			System.exit(0);
		}

	}

	public static void hold() {
		totalScore += sumValue;
		sumValue = 0;
		incrementTurns();
		scoreUpdate();

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char choice;
		rule();
		while (true) {
			System.out.println("TURN " + turns + ":\n");
			if (currentScore == 0) {
				System.out.println("Welcome to the game of Pig!\n");
			}
			while (true) {
				instruction();
				choice = scan.next().charAt(0);
				if (choice == 'r') {
					if (!roll()) {
						break;
					}

					checkWin();
					printRolledValue();
					scoreUpdate();
					wellWisherMsg();
				} else if (choice == 'h') {
					hold();
					break;

				} else {
					System.out.println("Wrong input");

				}

			}
			System.out.println();

		}
	}
}
