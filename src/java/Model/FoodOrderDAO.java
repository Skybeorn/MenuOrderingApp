package Model;

import db.accesor.DBAccessor;
import db.accesor.DB_Generic;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Use this version to connect to your local database.
 *
 * @author jlombardo
 */
public class FoodOrderDAO implements IFoodOrderDAO {

    private DBAccessor db;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/restaurant";
    private static final String USER = "admin";
    private static final String PWD = "admin";
    private static int orderCount = 0;

    public FoodOrderDAO() {
        db = new DB_Generic();
    }

    @Override
    public List<FoodCombo> getCurrentMenuChoices() throws RuntimeException {
        List<FoodCombo> items = new ArrayList<FoodCombo>();

        try {
            // Make sure you always open a connection before trying to
            // send commands to the database.            
            db.openConnection(FoodOrderDAO.DRIVER, FoodOrderDAO.URL, FoodOrderDAO.USER, FoodOrderDAO.PWD);

            String sql = "select * from menu_item order by item_name";
            List<Map> rawData = db.findRecords(sql, true);
            for (Map record : rawData) {
                FoodCombo item = new FoodCombo();
                String id = (record.get("name").toString());
                item.setName(id);
                String name = String.valueOf(record.get("description"));
                item.setDescription(name);
                Double price = Double.valueOf(record.get("price").toString());
                item.setPrice(price);
                items.add(item);
            }

            return items;

        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    @Override
    public void saveOrder(List<FoodCombo> orderList) throws RuntimeException {
        try {
            List colDescriptors = new ArrayList();
            List colValues = new ArrayList();
            db.openConnection(FoodOrderDAO.DRIVER, FoodOrderDAO.URL,
                    FoodOrderDAO.USER, FoodOrderDAO.PWD);

            for (FoodCombo item : orderList) {
                colDescriptors.add("name");
                colValues.add(item.getName());

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
                String dateStr = sdf.format(date);
                colValues.add(dateStr + "-" + ++orderCount);
                colDescriptors.add("order_id");

                // Usuallly you want the connection to be closed when the db
                // method finishes (second parameter = true). The reason is that
                // if you leave it open (second parameter = false) then you risk
                // the database connection might time out and close on its own.
                db.insertRecord("order_history", colDescriptors, colValues, false);
                colDescriptors.clear();
                colValues.clear();
            }
            db.closeConnection();

        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) {
        FoodOrderDAO dao = new FoodOrderDAO();
        List<FoodCombo> items = dao.getCurrentMenuChoices();
    }
}
