package model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {

    private int id;
    private String job;
    private Double salary;

    public Employee(String name, int age, int id, String job, Double salary) {
        super(name, age);
        this.id = id;
        this.job = job;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public List<String> displayInformation() {

        ArrayList<String> information = new ArrayList<>();

        information.add("ID: " + String.valueOf(getId()));
        information.add("Age: "+ String.valueOf(getAge()));
        information.add("Job:" + getJob());
        information.add("Salary: " + String.valueOf(getSalary()));

        return information;

    }
}
