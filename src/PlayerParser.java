/* 
 * Assignment #: 5
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The PlayerParser class will parse the string that is passed into the method parseNewPlayer() and create a new player object based on the string that is passed in.
*/

public class PlayerParser {

  public static PlayerEntity parseNewPlayer(String lineToParse) {

    /*
     * The method's argument will be a string in the following format:
     * Mage: playerType/health/name/stamina/attack/weapon/mana
     * Fighter: playerType/health/name/stamina/attack/weapon/fighterType
     * 
     * Here, playerType can be either “Mage” or “Fighter”, and the fighterType can
     * be “Melee” or “Range”. Input should be accepted in both lowercase and
     * uppercase.
     * 
     * An example of this string would be:
     * Mage/100/Tolfdir/125/150/No Weapon/.25 OR
     * Fighter/150/Vilkas/90/130/Sword/Melee
     */

    PlayerEntity newPlayer = null; // create a new player object amd set it to null as a default

    /*
     * creation of variables to store the values of the string
     */
    double health;
    String entityName;
    int stamina;
    int attack;
    String weapon;

    String[] lineArray = lineToParse.split("/"); // splits the string into an array of strings
    /*
     * The following code:
     * - acepts input in both lowercase and uppercase
     * - stores the values of the string into the variables
     */
    String playerType = lineArray[0].toLowerCase();
    health = Double.parseDouble(lineArray[1].toLowerCase());
    entityName = lineArray[2];
    stamina = Integer.parseInt(lineArray[3].toLowerCase());
    attack = Integer.parseInt(lineArray[4].toLowerCase());
    weapon = lineArray[5];

    /*
     * The following code will create a new player object based on the string that
     * is passed in.
     */

    switch (playerType) {
      case "mage":
        double mana = Double.parseDouble(lineArray[6].toLowerCase());
        newPlayer = new Mage(health, entityName, stamina, attack, weapon, mana);
        break;
      case "fighter":
        String fighterType = lineArray[6].toLowerCase();
        if (fighterType.equals("range")) {
          newPlayer = new Fighter(health, entityName, stamina, attack, weapon, true);
        } else if (fighterType.equals("melee")) {
          newPlayer = new Fighter(health, entityName, stamina, attack, weapon, false);
        }
        // replace the if statement with a switch statement
        // switch (fighterType) {
        // case "range":
        // newPlayer = new Fighter(health, entityName, stamina, attack, weapon, true);
        // break;
        // case "melee":
        // newPlayer = new Fighter(health, entityName, stamina, attack, weapon, false);
        // break;
        // }
        break;
    }

    // Method withou the switch statement

    // if (playerType.equals("mage")) { // creates a mage object if playerType is a
    // "mage"
    // double mana = Double.parseDouble(lineArray[6].toLowerCase());
    // newPlayer = new Mage(health, entityName, stamina, attack, weapon, mana);
    // } else if (playerType.equals("fighter")) { // creates a fighter object if
    // playerType is a "fighter"
    // String fighterType = lineArray[6].toLowerCase();
    // if (fighterType.equals("range")) { // will create the fighter object as a
    // ranged fighter if fighterType is "range"
    // newPlayer = new Fighter(health, entityName, stamina, attack, weapon, true);
    // } else if (fighterType.equals("melee")) { // will create the fighter object
    // as a melee fighter if fighterType is
    // // "melee"
    // newPlayer = new Fighter(health, entityName, stamina, attack, weapon, false);
    // }
    // }
    return newPlayer; // returns the new player object
  }

}
