package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private int id;
    private String program;

    public Student(String name, int age, int id, String program) {
        super(name, age);
        this.id = id;
        this.program = program;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public List<String> displayInformation() {

        ArrayList<String> information = new ArrayList<>();

        information.add("ID: " + String.valueOf(getId()));
        information.add("Age: "+ String.valueOf(getAge()));
        information.add("Program:" + getProgram());

        return information;
    }
}
