package home.jackking.entity;

import javax.persistence.Entity;

@Entity
public class Student {
    private int id;
    private String name;
    private int sex;

    public Student(){
    }
    public Student(int id, String name, int sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
