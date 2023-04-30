package entity;

import java.util.Date;

public class Worker {
    private final String name;

    private final String type;
    private final Date birthday;

    public Worker(String name, String type, Date birthday) {
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
