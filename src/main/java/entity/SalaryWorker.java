package entity;

public class SalaryWorker {
    private final String name;
    private final int salary;

    public SalaryWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
