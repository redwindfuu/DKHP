package com.Course.Pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student implements Serializable {

    private Long keyStudent;
    private String passwordStu;
    private String idStu;
    private String nameStu;
    private String sex;
    private Date birthday;
    private String numberPhone;
    private String address;
    private ClaSs idClass;
    private Set<Course> courses = new HashSet<Course>();

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getKeyStudent() == student.getKeyStudent() && Objects.equals(getPasswordStu(), student.getPasswordStu()) && Objects.equals(getIdStu(), student.getIdStu()) && Objects.equals(getNameStu(), student.getNameStu()) && Objects.equals(getSex(), student.getSex()) && Objects.equals(getBirthday(), student.getBirthday()) && Objects.equals(getNumberPhone(), student.getNumberPhone()) && Objects.equals(getAddress(), student.getAddress()) && Objects.equals(getIdClass(), student.getIdClass()) && Objects.equals(getCourses(), student.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeyStudent(), getPasswordStu(), getIdStu(), getNameStu(), getSex(), getBirthday(), getNumberPhone(), getAddress(), getIdClass(), getCourses());
    }

    public Student(String passwordStu, String idStu, String nameStu, String sex, Date birthday, String numberPhone, String address, ClaSs idClass) {
        this.passwordStu = passwordStu;
        this.idStu = idStu;
        this.nameStu = nameStu;
        this.sex = sex;
        this.birthday = birthday;
        this.numberPhone = numberPhone;
        this.address = address;
        this.idClass = idClass;
    }

    public Student() {

    }

    public Long getKeyStudent() {
        return keyStudent;
    }

    public void setKeyStudent(Long keyStudent) {
        this.keyStudent = keyStudent;
    }

    public String getPasswordStu() {
        return passwordStu;
    }

    public void setPasswordStu(String passwordStu) {
        this.passwordStu = passwordStu;
    }

    public String getIdStu() {
        return idStu;
    }

    public void setIdStu(String idStu) {
        this.idStu = idStu;
    }

    public String getNameStu() {
        return nameStu;
    }

    public void setNameStu(String nameStu) {
        this.nameStu = nameStu;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public ClaSs getIdClass() {
        return idClass;
    }
    public void setIdClass(ClaSs idClass) {
        this.idClass = idClass;
    }



    @Override
    public String toString() {
        return "Student{" +
                ", idStu='" + idStu + '\'' +
                ", nameStu='" + nameStu + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", numberPhone='" + numberPhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    public boolean isConnectPass(String text) {
        return passwordStu.equals(text);
    }
}

