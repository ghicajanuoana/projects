package bll.model;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;
import connection.*;

public class PersistentaUtilizator {
	 private static PersistentaUtilizator instance = new PersistentaUtilizator();
	 private static final String insertStatementString = "INSERT INTO user (userID,username,password,role)"
				+ " VALUES (?,?,?,?)";
	    private Connection makeConnection() {
	        return ConnectionFactory.getConnection();
	    }

	    private void inchideConexiune(Connection dbConnection, PreparedStatement statement, ResultSet resultSet) {
	        ConnectionFactory.close(statement);
	        ConnectionFactory.close(dbConnection);
	        ConnectionFactory.close(resultSet);
	    }

	    public static PersistentaUtilizator getInstance() {
	        return instance;
	    }


	    private PersistentaUtilizator() {

	    }
	    public static void printSQLException(SQLException ex) {

		    for (Throwable e : ex) {
		        if (e instanceof SQLException) {
		           
		                e.printStackTrace(System.err);
		                System.err.println("SQLState: " +
		                    ((SQLException)e).getSQLState());

		                System.err.println("Error Code: " +
		                    ((SQLException)e).getErrorCode());

		                System.err.println("Message: " + e.getMessage());

		                Throwable t = ex.getCause();
		                while(t != null) {
		                    System.out.println("Cause: " + t);
		                    t = t.getCause();
		                }
		            }
		        }
		    }
	    public void insertUser(Utilizator user) {
			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement insertStatement = null;
			try {
				insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
				insertStatement.setString(1, user.getId());
				insertStatement.setString(2, user.getUsername());
				insertStatement.setString(3, user.getPassword());
				insertStatement.setString(4, user.getRole());
				insertStatement.executeUpdate();
			}catch (SQLException e) {
	        	printSQLException(e);
	        }
		}
	   

	    public int actualizareUtilizator(Utilizator utilizatorVechi, Utilizator utilizatorNou) {
	        Connection dbConnection = makeConnection();
	        PreparedStatement statement = null;
	        int updated = -1;
	        String id = utilizatorVechi.getId();
	        String statementString = "UPDATE user SET username =" + "\'" + utilizatorNou.getUsername() + "\'" + ", password ="+ "\'" +
	                utilizatorNou.getPassword() + "\'" + ", role =" + "\'"  + utilizatorNou.getRole() + "\'" +
	                "WHERE userID = " + "\'" + id+"\'";
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

	    public int stergereUtilizator(Utilizator utilizator) {
	        Connection dbConnection = makeConnection();
	        PreparedStatement statement = null;
	        int deleted = -1;
	        String id = utilizator.getId();
	        String statementString = "DELETE FROM user " +
	                "WHERE userID = " + "\'" + id + "\'";
	        try {
	            statement = dbConnection.prepareStatement(statementString, Statement.RETURN_GENERATED_KEYS);
	            deleted = statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            inchideConexiune(dbConnection, statement, null);
	        }
	        /*if(deleted==1){
	            HashMap<String,Utilizator> hashMap=new HashMap<>();
	            hashMap.put("delete",utilizator);
	            setChanged();
	            notifyObservers(hashMap);
	        }*/
	        return deleted;
	    }

	    public ArrayList<Utilizator> getLista() {
	    	ArrayList<Utilizator> list = new ArrayList<Utilizator>();
	        try {
	            
	        	    Connection con = makeConnection();
	            	
	            	String query = "SELECT * FROM user ";
	                Statement st=con.createStatement();
	                ResultSet rs = st.executeQuery(query);
	                Utilizator client;
	                while(rs.next()) {
	                	client = new Utilizator(rs.getString("userID"),rs.getString("username"),rs.getString("password"),rs.getString("role"));
	                	list.add(client);
	                }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
}
