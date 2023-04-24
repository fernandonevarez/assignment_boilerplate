/* 
 * Assignment #: 5
 * Name: David Nevarez
 * StudentID: xxxxxxxxxx
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: The Fighter class is a subclass of the PlayerEntity class. 
 *              The Fighter class has same attributes as the parent class(playerEntity), but also has the following attributes: armor, maxAttack, and isRanged.
 *              Within the it used the abstract method computeCombatPower() to compute the combat points of the fighter.
 *              and also has a toString() method that returns a string representation of the object.
*/

public class Fighter extends PlayerEntity {
  // unique variables for the this child class of the PlayerEntity class
  private double armor;
  private int maxAttack;
  private boolean isRanged;

  public Fighter(double health, String entityName, int stamina, int attack, String weapon, boolean isRanged) {
    // calls the constructor of the parent class and passes the following arguments
    // into the constructor to set the attributes of the parent class to the
    // following values to their respective attributes.
    super(health, entityName, stamina, attack, weapon);
    // sets this instance of the Fighter class to have isRanged to have the
    // following values
    this.isRanged = isRanged;

    // the following code will set the armor and maxAttack attributes of the Fighter
    // class to the following values based on if the fighter is ranged or not.
    if (this.isRanged == true) {
      this.armor = 0.25;
      this.maxAttack = 125;
    } else {
      this.armor = 0.5;
      this.maxAttack = 100;
    }
  }

  // getter

  public void computeCombatPower() {
    /*
     * the following code will computeCombatPower
     */

    if (this.maxAttack <= this.attack) {
      /*
       * If the fighter's maxAttack is less than or equal to the damage the fighter
       * can do with a single
       * attack (attribute: attack), the combat points will be computed as follows:
       */
      this.combatPoints = (int) ((this.maxAttack + this.health) * (1 - this.armor));

    } else {
      /*
       * Otherwise, combatPoints will be computed as follows:
       */
      this.combatPoints = (int) ((this.attack + this.health) * (1 - this.armor));

    }

    // the following code will check if the weapon is a rock and if the fighter is a
    // ranged type. If so, the combatPoints will be increased by 50.
    if (this.isRanged && this.weapon.equals("Rock")) {
      this.combatPoints += 50;
    }
    // the following code will check if the weapon is a sword and if the fighter is
    // a melee type. If so, the combatPoints will be doubled.
    if (!this.isRanged && this.weapon.equals("Sword")) {
      this.combatPoints *= 2;
    }

  }

  /*
   * The following meathod will return a string representation of the object
   */
  public String toString() {
    String stringOutput = "\nFighter Hero:\t\t" + (this.isRanged == true ? "Ranged Type" : "Melee Type")
        + super.toString() + "Armor:\t\t\t" + getPercentValue(this.armor) + "\n";
    return stringOutput;
  }

}
