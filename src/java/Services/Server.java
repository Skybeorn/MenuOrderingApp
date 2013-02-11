
package Services;

import Model.FoodTicket;


public class Server {
    
    private FoodTicket customersOrder = new FoodTicket();
    
    public void addToOrder(String item) {
        customersOrder.addItemToOrder(item);
    }

    public String getReceipt() {
        return customersOrder.getReceipt();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Server other = (Server) obj;
        if (this.customersOrder != other.customersOrder && (this.customersOrder == null || !this.customersOrder.equals(other.customersOrder))) {
            return false;
        }
        return true;
    }
    
}
