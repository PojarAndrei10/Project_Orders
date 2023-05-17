package DataAccess;

import DataAccess.AbstractDAO;
import Model.Products;

public class ProductDAO extends AbstractDAO<Products> {
    public ProductDAO(Class<Products> type) {
        super(type);
    }
}
