package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Provider implements ProviderService{
    static Connection connection;
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,username,pass);
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
