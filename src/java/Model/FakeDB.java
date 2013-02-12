
package Model;

public class FakeDB {

    public static final FoodCombo[] combos = new FoodCombo[2];
    
    
    static {
        combos[0] = new FoodCombo("comboOne", "Nacho's With Chorizo", 12.00);
        combos[1] = new FoodCombo("comboTwo", "Nacho's With Beef", 10.00);
    }
}
