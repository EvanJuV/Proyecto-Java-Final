/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Evan
 */
public class DbConnection {
    private static Connection conn;
    
    // Se define el usuario de la base de datos
    // Debe ser cambiado en cada ambiente de desarrollo
    private static final String USERNAME = "root";
    private static final String DATABASE = "inscripciones";
    private static final String PASSWORD = "jcou1992-?";
    
    public DbConnection() {
    }
    
    public static ArrayList<HashMap> select(String query) {
        Statement statement;
        ResultSet resultSet = null;
        ResultSetMetaData rsmd;
        ArrayList<HashMap> data = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?characterEncoding=utf8",
                    USERNAME, PASSWORD);
        } catch (ClassNotFoundException cnfex) {
            System.err.println("Failed to load JDBC/ODBC driver.");
            cnfex.printStackTrace();
            System.exit(1);
        } catch (SQLException sqlex) {
            System.err.println("Unable to connect to database " + DATABASE);
            sqlex.printStackTrace();
        }
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            rsmd = resultSet.getMetaData();
            data = getResults(resultSet, rsmd);
            statement.close();
        }
        catch(SQLException sqlex) {
            sqlex.printStackTrace();
        }
        
        return data;
    }
    
    public static int query(String query) {
        Statement statement = null;
        ResultSetMetaData rsmd;
        int data = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?characterEncoding=utf8",
                    USERNAME, PASSWORD);
        } catch (ClassNotFoundException cnfex) {
            System.err.println("Failed to load JDBC/ODBC driver.");
            cnfex.printStackTrace();
            System.exit(1);
        } catch (SQLException sqlex) {
            System.err.println("Unable to connect to database " + DATABASE);
            sqlex.printStackTrace();
        }
        
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                data = (int) generatedKeys.getLong(1);
            }
            
            statement.close();

        }
        catch(SQLException sqlex) {
            sqlex.printStackTrace();
        }
        
        
        return data;
    }
    
    public static ArrayList<HashMap> getResults(ResultSet rs, 
            ResultSetMetaData rsmd) throws SQLException {
        ArrayList<HashMap> data = new ArrayList<>();
        ArrayList<String> heads = new ArrayList<>();
        
        for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
            heads.add(rsmd.getColumnName(i));
            System.out.println(rsmd.getColumnName(i));
        }
        
        while(rs.next()) {
            HashMap row = new HashMap();
            for(int i = 0; i < heads.size(); i++) {
                switch(rsmd.getColumnType(i + 1)) {
                    case Types.VARCHAR:
                        row.put(heads.get(i), rs.getString(i + 1));
                        break;
                    case Types.INTEGER:
                        row.put(heads.get(i), rs.getInt(i + 1));
                        break;
                    case Types.DOUBLE:
                        row.put(heads.get(i), rs.getDouble(i + 1));
                        break;
                    case Types.FLOAT:
                        row.put(heads.get(i), rs.getFloat(i + 1));
                        break;
                    case Types.BOOLEAN:
                        row.put(heads.get(i), rs.getBoolean(i + 1));
                        break;
                }
                
//                if(heads.get(i).equals("honors"))
                    System.out.println(heads.get(i) + " " + rs.getBoolean(i + 1)); 
            }
            System.out.println("------------");

            data.add(row);
        }
        
        return data;
    }
}
