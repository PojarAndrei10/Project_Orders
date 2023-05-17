package DataAccess;

import DataAccess.AbstractDAO;
import Model.Orders;

public class OrderDAO extends AbstractDAO<Orders> {
    public OrderDAO(Class<Orders> type) {
        super(type);
    }
}
