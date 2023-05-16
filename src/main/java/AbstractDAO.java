import Connection.ConnectionF;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
    private final Class<T> type;
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    @SuppressWarnings("unchecked")
    public AbstractDAO(Class<T> type) {

        this.type = type;
    }
    private String createSelectQuery(String field, int a) {
        StringBuilder stringBuilder ;
        stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append(" * ");
        stringBuilder.append(" FROM ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" WHERE ").append(field).append("=").append(a);

        return stringBuilder.toString();
    }
    List<T> createObjects(ResultSet resultSet) {
        int i;
        List<T> list = new ArrayList<T>();
        Constructor[] constructors = type.getDeclaredConstructors();
        Constructor constructor = null;
        for (i = 0; i < constructors.length; i++)
        {
            constructor = constructors[i];
            if (constructor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next())
            {
                constructor.setAccessible(true);
                T instance = (T) constructor.newInstance();
                for (Field f : type.getDeclaredFields()) {
                    String fName = f.getName();
                    Object val = resultSet.getObject(fName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, val);
                }
                list.add(instance);
            }
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IntrospectionException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public T findById(int id) {
        ResultSet resultSet = null;
        Connection connection = null;
        Field[] fields = type.getDeclaredFields();
        PreparedStatement statement = null;
        String selectInterogare = createSelectQuery(fields[0].getName(), id);
        try {
            connection = ConnectionF.getConnection();
            statement = connection.prepareStatement(selectInterogare);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        }
        catch (SQLException e)
        {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        }
        finally
        {
            ConnectionF.close(resultSet);
            ConnectionF.close(statement);
            ConnectionF.close(connection);
        }
        return null;
    }
    private String getTable(String type) {
        HashMap<String, String> tableMapping = new HashMap<>();
        tableMapping.put("Client", "client");
        tableMapping.put("Order", "order");
        tableMapping.put("Product", "product");

        String tableName;
        tableName = tableMapping.getOrDefault(type, "");
        if (tableName.isEmpty())
        {
            System.out.println("Invalid type: " + type);
        }

        return tableName;
    }
    public void inserare(T t)
    {
        PreparedStatement preparedStatement = null;
        Connection dataBase;
        try {
            dataBase = ConnectionF.getConnection();
            StringBuilder construireInterogare = new StringBuilder();
            construireInterogare.append("INSERT INTO `").append(type.getSimpleName()).append("` ").append("(");
            for (Field i : type.getDeclaredFields())
            {
                String fName = i.getName();
                construireInterogare.append(fName);
                construireInterogare.append(", ");
            }
            construireInterogare.replace(construireInterogare.length() - 2,
                    construireInterogare.length(), "");
            construireInterogare.append(") VALUES (");
            for (Field j : type.getDeclaredFields())
            {
                j.setAccessible(true);
                Object o = j.get(t);
                if (j.getType().getSimpleName().equals("String"))
                    construireInterogare.append("'").append(o).append("'");
                else
                    construireInterogare.append(o);
                construireInterogare.append(", ");
            }
            construireInterogare.replace(construireInterogare.length() - 2,
                    construireInterogare.length(), ");");
            System.out.println(construireInterogare);
            try {
                dataBase = ConnectionF.getConnection();
                preparedStatement = dataBase.prepareStatement(construireInterogare.toString());
                preparedStatement.executeUpdate();
            }
            catch (SQLException e)
            {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:Insert " + e.getMessage());
            }
            finally
            {
                ConnectionF.close(preparedStatement);
                ConnectionF.close(dataBase);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update(T t)
    {
        PreparedStatement statement = null;
        Connection dbConnection;
        try {
            dbConnection = ConnectionF.getConnection();
            StringBuilder queryBuild ;
            queryBuild = new StringBuilder();
            queryBuild.append("UPDATE `").append(type.getSimpleName()).append("` SET ");
            for (Field i : type.getDeclaredFields())
            {
                i.setAccessible(true);
                String fieldName = i.getName();
                queryBuild.append(fieldName);
                queryBuild.append("=");
                Object value = i.get(t);
                if (i.getType().getSimpleName().equals("String"))
                    queryBuild.append("'").append(value).append("'");
                else
                    queryBuild.append(value);
                queryBuild.append(", ");
            }
            queryBuild.replace(queryBuild.length() - 2, queryBuild.length(), " ");
            Field[] ff = t.getClass().getDeclaredFields();
            ff[0].setAccessible(true);
            Object val;
            val = ff[0].get(t);

            queryBuild.append("WHERE ").append(ff[0].getName()).append("=").append(val);
            try {
                dbConnection = ConnectionF.getConnection();
                statement = dbConnection.prepareStatement(queryBuild.toString());
                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:Update " + e.getMessage());
            }
            finally
            {
                ConnectionF.close(statement);
                ConnectionF.close(dbConnection);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ;
    }
    public JTable createTable(ArrayList<T> list)
    {
        JTable table;
        int cont=0;
        int size=type.getDeclaredFields().length;
        String[] columns=new String[size];
        for (Field j : type.getDeclaredFields())
        {
            j.setAccessible(true);
            columns[cont++]=j.getName();
        }
        DefaultTableModel myModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        myModel.setColumnIdentifiers(columns);
        int c;
        for (Object o : list)
        {
            Object[] obj = new Object[size];
            c = 0;
            for (java.lang.reflect.Field currentField : o.getClass().getDeclaredFields())
            {
                currentField.setAccessible(true);
                try {
                    obj[c] = currentField.get(o);
                    c++;
                }
                catch (IllegalArgumentException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
            myModel.addRow(obj);
        }
        JTable tablee = new JTable(myModel);
        return tablee;
    }
    public ArrayList<T> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuilder sb;
        ResultSet resultSet = null;
        sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM `");
        sb.append(type.getSimpleName());
        sb.append("`");
        try {
            connection = ConnectionF.getConnection();
            statement = connection.prepareStatement(sb.toString());
            resultSet = statement.executeQuery();

            return (ArrayList<T>) createObjects(resultSet);
        }
        catch (SQLException e)
        {
            LOGGER.log(Level.WARNING,type.getName() + "DAO:findById " + e.getMessage());
        }
        finally
        {
            ConnectionF.close(resultSet);
            ConnectionF.close(statement);
            ConnectionF.close(connection);
        }
        return null;
    }
    public void stergere(int id) {
        Connection dbConnection;
        StringBuilder queryBuild ;
        queryBuild = new StringBuilder();
        PreparedStatement statement = null;
        dbConnection = ConnectionF.getConnection();
        Field[] ff = type.getDeclaredFields();
        queryBuild.append("DELETE FROM `").append(type.getSimpleName()).
                append("` WHERE ").append(ff[0].getName()).append("=").append(id);
        try {
            dbConnection = ConnectionF.getConnection();
            statement = dbConnection.prepareStatement(queryBuild.toString());
            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        }
        finally
        {
            ConnectionF.close(statement);
            ConnectionF.close(dbConnection);
        }
        return ;
    }
}