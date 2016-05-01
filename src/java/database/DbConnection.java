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
    private String username = "root";
    private String database = "inscripciones";
    private String password = "";
    
    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database,
                    username, password);
        }
        catch(ClassNotFoundException cnfex) {
            System.err.println("Failed to load JDBC/ODBC driver.");
            cnfex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException sqlex) {
            System.err.println("Unable to connect to database " + database);
            sqlex.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        String query;
//        
//        Scanner in = new Scanner(System.in);
//        query = in.nextLine();
//        
//        DbConnection db = new DbConnection();
//        
//        ArrayList<HashMap> results = db.executeQuery(query);
//        for(HashMap r : results) {
//            
//            System.out.println("Usuario: " + r.get("username") + " password: " + r.get("password"));
//        }
//    }
    
    public static ArrayList<HashMap> executeQuery(String query) {
        Statement statement;
        ResultSet resultSet = null;
        ResultSetMetaData rsmd;
        ArrayList<HashMap> data = new ArrayList<>();
        
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
    
    public static ArrayList<HashMap> getResults(ResultSet rs, 
            ResultSetMetaData rsmd) throws SQLException {
        ArrayList<HashMap> data = new ArrayList<>();
        ArrayList<String> heads = new ArrayList<>();
        
        for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
            heads.add(rsmd.getColumnName(i));
        }
        
        while(rs.next()) {
            HashMap row = new HashMap();
            for(int i = 0; i < heads.size(); i++) {
                switch(rsmd.getColumnType(i + 1)) {
                    case Types.VARCHAR:
                        row.put(heads.get(i), rs.getString(i + 1));
                        break;
                    case Types.INTEGER:
                        row.put(heads.get(i), rs.getLong(i + 1));
                        break;
                    case Types.DOUBLE:
                        row.put(heads.get(i), rs.getDouble(i + 1));
                        break;
                    case Types.FLOAT:
                        row.put(heads.get(i), rs.getFloat(i + 1));
                        break;
                }
            }
            data.add(row);
        }
        
        return data;
    }
}
