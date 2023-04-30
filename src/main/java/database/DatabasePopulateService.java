package database;

import settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public void populateDb(Database database) {
        try {
            String fileName = new Settings().getString(Settings.POPULATE_DB_SQL_FILE_PATH);
            String sql = Files.readString(Paths.get(fileName));
            database.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabasePopulateService().populateDb(database);
    }
}
