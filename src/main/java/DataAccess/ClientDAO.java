package DataAccess;

import DataAccess.AbstractDAO;
import Model.Clients;

public class ClientDAO extends AbstractDAO<Clients> {
    public ClientDAO(Class<Clients> type) {
        super(type);
    }
}
