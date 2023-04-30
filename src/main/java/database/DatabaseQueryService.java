package database;

import entity.*;
import settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public List<Project> findLongestProject() {
        String fileName = new Settings().getString(Settings.FIND_LONGEST_PROJECT_SQL_FILE_PATH);
        String sql = getSql(fileName);
        List<Project> projects = new ArrayList<>();
        try(PreparedStatement st = database.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()){
                Project project = new Project();
                String name = rs.getString("name");
                project.setName(name);
                int monthCount = rs.getInt("month_count");
                project.setMonthCount(monthCount);
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public List<Client> findMaxProjectsClient() {
        String fileName = new Settings().getString(Settings.FIND_MAX_PROJECTS_CLIENT_SQL_FILE_PATH);
        String sql = getSql(fileName);
        List<Client> clients = new ArrayList<>();
        try(PreparedStatement st = database.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()){
                Client client = new Client();
                String name = rs.getString("name");
                client.setName(name);
                int projectCount = rs.getInt("project_count");
                client.setProjectCount(projectCount);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    public List<SalaryWorker> findMaxSalaryWorker() {
        String fileName = new Settings().getString(Settings.FIND_MAX_SALARY_WORKER_SQL_FILE_PATH);
        String sql = getSql(fileName);
        List<SalaryWorker> workers = new ArrayList<>();
        try(PreparedStatement st = database.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()){
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                SalaryWorker worker = new SalaryWorker(name, salary);
                workers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }
    public List<Worker> findYoungestEldestWorkers() {
        String fileName = new Settings().getString(Settings.FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH);
        String sql = getSql(fileName);
        List<Worker> workers = new ArrayList<>();
        try(PreparedStatement st = database.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()){
                String name = rs.getString("name");
                String type = rs.getString("type");
                Date birthday = rs.getDate("birthday");
                Worker worker = new Worker(name, type, birthday);
                workers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }
    public List<ProjectPrice> printProjectPrices() {
        String fileName = new Settings().getString(Settings.PRINT_PROJECT_PRICES_SQL_FILE_PATH);
        String sql = getSql(fileName);
        List<ProjectPrice> projects = new ArrayList<>();
        try(PreparedStatement st = database.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()){
                ProjectPrice project = new ProjectPrice();
                String name = rs.getString("name");
                project.setName(name);
                int price = rs.getInt("price");
                project.setPrice(price);
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    private static String getSql(String fileName) {
        String sql = null;
        try {
            sql = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public static void main(String[] args) {
        Database database1 = Database.getInstance();

        List<Project> longestProjects = new DatabaseQueryService(database1).findLongestProject();
        System.out.println("longestProjects = " + longestProjects);

        List<Client> clientsWithMaxProjectsCount = new DatabaseQueryService(database1).findMaxProjectsClient();
        System.out.println("clientsWithMaxProjectsCount = " + clientsWithMaxProjectsCount);

        List<SalaryWorker> workersWithMaxSalary = new DatabaseQueryService(database1).findMaxSalaryWorker();
        System.out.println("workersWithMaxSalary = " + workersWithMaxSalary);

        List<Worker> youngestAndEldestWorkers = new DatabaseQueryService(database1).findYoungestEldestWorkers();
        System.out.println("youngestAndEldestWorkers = " + youngestAndEldestWorkers);

        List<ProjectPrice> projectsWithPrices = new DatabaseQueryService(database1).printProjectPrices();
        System.out.println("projectsWithPrices = " + projectsWithPrices);
    }
}
