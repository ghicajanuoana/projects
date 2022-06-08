package main.java.model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import main.java.connection.ConnectionFactory;
import java.util.logging.Logger;

public class PersistentaPlanta {
	protected static final Logger LOGGER = Logger.getLogger(PersistentaPlanta.class.getName());
	private static PersistentaPlanta instance = new PersistentaPlanta();

    private Connection makeConnection() {
        return ConnectionFactory.getConnection();
    }

    private void inchideConexiune(Connection dbConnection, PreparedStatement statement, ResultSet resultSet) {
        ConnectionFactory.close(statement);
        ConnectionFactory.close(dbConnection);
        ConnectionFactory.close(resultSet);
    }

    public static PersistentaPlanta getInstance() {
        return instance;
    }


    public PersistentaPlanta() {

    }

    public int salvarePlanta(Planta planta) {
        Connection dbConnection = makeConnection();
        PreparedStatement insertStatement = null;
        int inserted = -1;
        String nume = planta.getNume();
        String tip=planta.getTip();
        String specie=planta.getSpecie();
        String zona=planta.getZona();
        String insertStatementString = "INSERT INTO planta " +
                "VALUES(" +"\'" + nume + "\', \'" + tip + "\', \'" + specie + "\', \'" +
                zona + "\')";


        try {

            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            inserted = insertStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            inchideConexiune(dbConnection, insertStatement, null);

        }
        //setChanged();
        //notifyObservers(planta);
        return inserted;
    }

    public int actualizarePlanta(Planta plantaveche, Planta plantanoua) {
        Connection dbConnection = makeConnection();
        PreparedStatement statement = null;
        int updated = -1;
        String nume=plantaveche.getNume();
        String statementString = "UPDATE planta SET tip =" + "\'" + plantanoua.getTip() + "\'" + ", specie =" + " \'" +
                plantanoua.getSpecie() + "\'" + ", zona = " + "\'" + plantanoua.getZona() + "\'" +
                " WHERE nume = " + "\'" + nume+ "\'";
        try {
            statement = dbConnection.prepareStatement(statementString, Statement.RETURN_GENERATED_KEYS);
            updated = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            inchideConexiune(dbConnection, statement, null);
        }
        return updated;
    }

    public int stergerePlanta(Planta planta) {
        Connection dbConnection = makeConnection();
        PreparedStatement statement = null;
        int deleted = -1;
        String nume=planta.getNume();
        String statementString = "DELETE FROM planta " +
                "WHERE nume = " + "\'"+nume+"\'";

        try {
            statement = dbConnection.prepareStatement(statementString, Statement.RETURN_GENERATED_KEYS);
            deleted = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            inchideConexiune(dbConnection, statement, null);
        }
        return deleted;
    }

    public List<Planta> getListaPlante() {
        Connection dbConnection = makeConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM planta ";
        try {
            statement = dbConnection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return creeazaPlante(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            inchideConexiune(dbConnection, statement, resultSet);
        }
        return null;
    }

    public List<Planta> creeazaPlante(ResultSet rs) {
        List<Planta> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Planta instance = Planta.class.getDeclaredConstructor().newInstance();
                for (Field field : Planta.class.getDeclaredFields()) {
                    Object value = rs.getObject(field.getName());
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), Planta.class);
                    Method method = pd.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);

            }

        } catch (SQLException | IllegalAccessException | IntrospectionException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }
}
