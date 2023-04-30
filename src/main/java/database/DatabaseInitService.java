package database;

import settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public void initDb (Database database) {
        try {
            String fileName = new Settings().getString(Settings.INIT_DB_SQL_FILE_PATH);
            String sql = Files.readString(Paths.get(fileName));
            database.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseInitService().initDb(database);
    }
}
