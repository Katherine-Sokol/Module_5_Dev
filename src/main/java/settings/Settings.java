package settings;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Settings {

    public static final String DEFAULT_PREFS_URL = "src/main/resources/prefs.json";
    public static final String JDBC_CONNECTION_URL = "jdbcUrl";
    public static final String INIT_DB_SQL_FILE_PATH = "initDbSql";
    public static final String POPULATE_DB_SQL_FILE_PATH = "populateDbSql";
    public static final String FIND_LONGEST_PROJECT_SQL_FILE_PATH = "findLongestProject";
    public static final String FIND_MAX_PROJECTS_CLIENT_SQL_FILE_PATH = "findMaxProjectsClient";
    public static final String FIND_MAX_SALARY_WORKER_SQL_FILE_PATH = "findMaxSalaryWorker";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH = "findYoungestEldestWorkers";
    public static final String PRINT_PROJECT_PRICES_SQL_FILE_PATH = "printProjectPrices";

    private Map<String, Object> prefs = new HashMap<>();

    public Settings() {
        this(DEFAULT_PREFS_URL);
    }

    public Settings(String url) {
        try {
            String json = Files.readString(Paths.get(url));
            prefs = new Gson().fromJson(json, new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }

    public String getString(String key) {
        return getPref(key).toString();
    }

}
