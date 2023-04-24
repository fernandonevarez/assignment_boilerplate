/* 
 * Assignment #: 5
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The PlayerEntity class is an abstract class that will be inherited by the Fighter and Mage subclasses.
 *              That will have the following attributes pasting through the children classes: health, entityName, stamina, attack, combatPoints, weapon, and isRanged.
 *              The playerEntity method also has methods that will be inherited by the child classes.
*/

import java.text.DecimalFormat; // import DecimalFormat class, which allows for the formatting of decimal numbers

public abstract class PlayerEntity {

  // protected attributes of the PlayerEntity class that will be inherited by the
  // child classes
  protected double health;
  protected String entityName;
  protected int stamina;
  protected int attack;
  protected int combatPoints;
  protected String weapon;
  protected boolean isRanged;

  // the following constructor will set the attributes of the PlayerEntity class
  // to the following given values
  public PlayerEntity(double newHealth, String newName, int newStamina, int newAttack, String newWeapon) {
    this.health = newHealth;
    this.entityName = newName;
    this.stamina = newStamina;
    this.attack = newAttack;
    this.weapon = newWeapon;
  }

  // getter

  public String getPercentValue(double value) {
    /*
     * This method converts a double value into a string repersention of a percent
     * value and returns the string.
     */
    // formats the value to two decimal places using the DecimalFormat class
    DecimalFormat df = new DecimalFormat("#.##");
    value = Double.valueOf(df.format(value));
    value = value * 100;
    // converts to string and adds a percent sign to the end
    String stringValue = String.valueOf((int) value) + "%";
    // returns the string
    return stringValue;
  }

  // the folowing method returns the combat points of the hero
  public int getCombatPoints() {
    return this.combatPoints;
  }

  // the following method is an abstract method that will be implemented in the
  // child classes
  // In which method will compute the combat points of the hero
  public abstract void computeCombatPower();

  // the following method will return a string representation of the object
  public String toString() {
    String stringOutput = "\nHero name:\t\t" + this.entityName + "\nCurrent Health:\t\t" + this.health
        + "\nStamina:\t\t"
        + this.stamina + "\nAttack Damage:\t\t" + this.attack + "\nWeapon:\t\t\t" + this.weapon
        + "\nCurrent Combat Points:\t"
        + this.combatPoints + "\n";
    return stringOutput;
  }
}
