package com.tel.ran.pojo;

public class Car {
    private String brand;
    private String model;
    private Integer year;
    private Integer kilometersRun;

    public Car(String brand, String model, Integer year, Integer kilometersRun) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.kilometersRun = kilometersRun;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getKilometersRun() {
        return kilometersRun;
    }

    public void setKilometersRun(Integer kilometersRun) {
        this.kilometersRun = kilometersRun;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", kilometersRun=" + kilometersRun +
                '}';
    }
}
