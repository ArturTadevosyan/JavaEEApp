package com.digi.model;

public class Car {
    private int id;
    private String name;
    private String model;
    private int year;
    private int userId;

    public Car(String name, String model, int year, int userId) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.userId = userId;
    }

    public Car(int id, String name, String model, int year, int userId) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
        this.userId = userId;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", userId=" + userId +
                '}';
    }
}
