package com.Course.Pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClaSs implements Serializable {
    private int idClss;
    private String nameClass;

    public ClaSs(String nameClass) {
        this.nameClass = nameClass;
    }

    private Set<Student> students = new HashSet<Student>(0)  ;

    public ClaSs() {

    }

    public int totalStudent(){
        return students.size();
    }
    public int totalFemaleStudent(){
        int count =0 ;
        for (Student h : students) {
            if (h.getSex().trim().equals("Nữ")) count++;
        }
        return count;
    }

    public int getIdClss() {
        return idClss;
    }

    public void setIdClss(int idClss) {
        this.idClss = idClss;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;
        ClaSs aClass = (ClaSs) o;
        return getIdClss() == aClass.getIdClss() && Objects.equals(getNameClass(), aClass.getNameClass()) && Objects.equals(getStudents(), aClass.getStudents());
    }

    @Override
    public String toString() {
        return nameClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClss(), getNameClass());
    }
}
