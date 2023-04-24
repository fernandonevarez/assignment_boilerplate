/* 
 * Assignment #: 5
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The Assignment 5 class is the main class for the program. It contains the main method and the    printMenu method. The main method creates an ArrayList of PlayerEntity objects and then prompts the user for input. The user can add a hero to the guild, calculate the combat power for all heroes in the guild, or quit the program. The printMenu method prints the menu options for the user. 
*/

import java.io.*; //to use InputStreamReader and BufferedReader
import java.util.*; //to use ArrayList

public class Assignment5 {

    public static void main(String[] args) {
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the hero objects
        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try {
            System.out.println("Welcome to the battle stats simulator!");
            printMenu();

            // creates a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if (line.length() == 1) {
                    switch (input) {
                        case 'A': // add hero to the guild
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();

                            PlayerEntity newPlayer = PlayerParser.parseNewPlayer(inputInfo); // create a new player
                                                                                             // object from the pasered
                                                                                             // string input
                            playerList.add(newPlayer); // add the new player object to the ArrayList
                            break;

                        case 'C': // calculates the combat points for all heroes in the guild
                            for (int i = 0; i < playerList.size(); i++) {
                                PlayerEntity currentPlayer = playerList.get(i);
                                currentPlayer.computeCombatPower();
                            }
                            System.out.println("Combat points computed");
                            break;

                        case 'D': // output the combat points for all heroes in the guild that have a combat
                                  // points equal to or larger than the input value
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;

                            for (int i = 0; i < playerList.size(); i++) {
                                // loops through the ArrayList and counts the number of heroes with combat
                                // points equal to or larger than the input value
                                if (playerList.get(i).getCombatPoints() >= min) {
                                    count++;
                                }
                            }

                            System.out.println("The number of heroes with " + min
                                    + " combat points or more is: " + count);
                            break;

                        case 'L': // lists all the heroes status in the guild in string format
                            if (playerList.size() == 0) {
                                // if the ArrayList is empty, this message will be displayed
                                System.out.println("No heroes in guild yet.");
                            } else {
                                // loops through the ArrayList and prints the string representation of each hero
                                for (int i = 0; i < playerList.size(); i++) {
                                    System.out.print(playerList.get(i).toString());
                                }
                            }
                            break;

                        case 'Q': // quits the program
                            break;

                        case '?': // prints the menu again for the user to see
                            printMenu();
                            break;

                        default: // if the user enters an invalid input, this message will be displayed
                            System.out.print("Unknown action\n");
                            break;
                    }
                } else // if the user enters an invalid input, this message will be displayed
                    System.out.println("Unknown action");

            } while (input != 'Q');
            System.out.println("Thanks for playing!");
            stdin.close();
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    // A method that prints the menu options for the user
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
