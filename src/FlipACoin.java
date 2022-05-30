import java.util.Scanner;

public class FlipACoin {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        if (promptUser(console) == 1) {
            int totalTrials = promptLimitedTrials(console);
            runTrials(totalTrials);
        } else {
            int inARow = promptRunTil(console);
            runUntil(inARow);
        }
    }

    public static int promptUser(Scanner console) {
        System.out.println("Would you like to [1] run for x trials and see longest run or [2] flip until you reach x " +
                "in a row?");

        int option = getInt(console);

        while (option != 1 && option != 2) {
            System.out.println("Not a valid option. Pick 1 or 2!");
            option = getInt(console);
        }

        return option;
    }

    public static int getInt(Scanner console) { // Just grab an int first

        while (!console.hasNextInt()) {
            console.next();
            System.out.println("That is not an valid input. (Pick an integer number!)");
        }

        return console.nextInt();
    }

    public static int promptLimitedTrials(Scanner console) {
        System.out.println("How many flips would you like in total?");
        return getInt(console);
    }

    public static int promptRunTil(Scanner console) {
        System.out.println("How many times in a row would you like a result?");
        return getInt(console);
    }

    public static void runTrials(int totalTrials) {
        int numHeads = 0;
        int numTails = 0;

        int longestRun = 0;
        int longestRunType = -1;
        int currentRun = 0;
        int currentRunType = -1;
        int currentFlip = -1;

        for (int i = 0; i < totalTrials; i++) {
            double coin = Math.random();

            // set current flip
            if (coin < .5) { // heads
                numHeads++;
                currentFlip = 1;
            } else { // tails
                numTails++;
                currentFlip = 0;
            }
            // check current flip against the current run. If it matches, increment, else end current run
            if (currentFlip == currentRunType) {
                currentRun++;
            } else {
                currentRunType = currentFlip;
                currentRun = 1;
            }
            // check if the current run beats the max, updates if so
            if (currentRun > longestRun) {
                longestRun = currentRun;
                longestRunType = currentRunType;
            }
            System.out.println("Current flip: " + currentFlip);
            System.out.println("Current run: " + currentRun);
            System.out.println();
        }
        System.out.println("Longest Run: " + longestRun);
        System.out.println("Longest Run Type: " + longestRunType);
        System.out.println("Number of Heads: " + numHeads);
        System.out.println("Number of Tails: " + numTails);
    }

    public static void runUntil(int runs) {
        int currentRun = 0;
        int currentRunType = -1;
        int currentFlip = -1;
        int totalFlips = 0;

        while (currentRun != runs) {
            double coin = Math.random();
            totalFlips++;

            if (coin < .5) {
                currentFlip = 1;
            } else {
                currentFlip = 0;
            }

            if (currentFlip == currentRunType) {
                currentRun++;
            } else {
                currentRunType = currentFlip;
                currentRun = 1;
            }

            System.out.println("Current flip: " + currentFlip);
            System.out.println("Current run: " + currentRun);
            System.out.println();
        }
        System.out.println("It took " + totalFlips + " flips to get " + currentRun + " flips in a row!");

    }
}
