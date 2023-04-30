package entity;

public class Client {
    private String name;
    private int projectCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
