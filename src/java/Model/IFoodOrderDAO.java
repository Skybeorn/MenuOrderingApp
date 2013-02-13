package Model;

import java.util.List;

/**
 * The general contract for all versions of OrderDAO classes.
 * 
 * @author jlombardo
 */
public interface IFoodOrderDAO {

    List<FoodCombo> getCurrentMenuChoices() throws RuntimeException;

    void saveOrder(List<FoodCombo> orderList) throws RuntimeException;

}
