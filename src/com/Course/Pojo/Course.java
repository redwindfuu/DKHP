package com.Course.Pojo;

import com.Course.DAO.SemesterDAO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course implements Serializable {
    private CoursePK idCourse;
    private Integer slot;
    private String nameteacher;
    private Set<Student> students = new HashSet<Student>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public CoursePK getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(CoursePK idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameteacher() {
        return nameteacher;
    }

    public void setNameteacher(String nameteacher) {
        this.nameteacher = nameteacher;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public boolean DKHP_forStudent(Course var){
        return (this.getIdCourse().getTimestudy() == var.getIdCourse().getTimestudy())
                && (this.getIdCourse().getDaystudy() == var.getIdCourse().getDaystudy()) && var.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester().equals(SemesterDAO.getMainSemester());
    }
    public boolean DKHP_forTeacher(Course var){
        return (this.getIdCourse().getTimestudy() == var.getIdCourse().getTimestudy())
                && (this.getIdCourse().getDaystudy() == var.getIdCourse().getDaystudy())&&(this.getIdCourse().getRoom() == var.getIdCourse().getRoom());
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getIdCourse(), course.getIdCourse()) && Objects.equals(getSlot(), course.getSlot()) && Objects.equals(getNameteacher(), course.getNameteacher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCourse()) ;
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse.toString() +
                ", slot=" + slot.toString() +
                ", nameteacher='" + nameteacher + '\'' +
                '}';
    }


}
