package pl.pwasil.Repository;

import java.util.UUID;

public class Car {
    private String name;
    private UUID id;

    public Car(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
