/* 
 * Assignment #: 5
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The Mage class is a subclass of the PlayerEntity class. 
 *              The Mage class has same attributes as the parent class(playerEntity), but also has the following attributes: mana.
 *              Within the it used the abstract method computeCombatPower() to compute the combat points of the fighter.
 *              and also has a toString() method that returns a string representation of the object.
*/

public class Mage extends PlayerEntity {
  // unique variables for this child class of the PlayerEntity class
  private double mana;

  public Mage(double health, String entityName, int stamina, int attack, String weapon, double mana) {
    // calls the constructor of the parent class and passes the following arguments
    // to set this inatance of the Mage class to have the pass in values
    super(health, entityName, stamina, attack, weapon);
    // sets the unique attribute(mana) of this instance of the Mage class to have
    // the following value
    this.mana = mana;
  }

  public void computeCombatPower() {
    /*
     * This method will compute the combat points of the mage. Then if the mage is
     * using a staff, the combat points will be increased by 30.
     */
    this.combatPoints = (int) ((this.attack + this.health) * (1 + this.mana));
    if (this.weapon == "Staff") {
      this.combatPoints = this.combatPoints + 30;
    }
  }

  // getter
  /*
   * The following meathod will return a string representation of the object
   */
  public String toString() {
    String stringOutput = "\nMage Hero:" + super.toString() + "Mana:\t\t\t" + getPercentValue(this.mana) + "\n";
    return stringOutput;
  }

}
