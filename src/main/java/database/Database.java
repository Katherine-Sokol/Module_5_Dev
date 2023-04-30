package database;

import settings.Settings;

import java.sql.*;

public class Database {

    private static final Database INSTANCE = new Database();
    private Connection connection;

    private Database(){
        try {
            String connectionUrl = new Settings().getString(Settings.JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection(){
        return  connection;
    }

    public void executeUpdate(String url){
        try(PreparedStatement st = connection.prepareStatement(url)){
            st.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
