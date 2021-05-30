package com.Course.Pojo;

import java.sql.Date;
import java.util.Objects;

public class Teacher {
    private int keyTeacher;
    private String passwordTea;
    private String idTea;
    private String nameTea;
    private String sex;
    private Date birthday;
    private String numberPhone;
    private String address;

    public Teacher(String passwordTea, String idTea, String nameTea, String sex, Date birthday, String numberPhone, String address) {
        this.passwordTea = passwordTea;
        this.idTea = idTea;
        this.nameTea = nameTea;
        this.sex = sex;
        this.birthday = birthday;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    public Teacher() {

    }

    public int getKeyTeacher() {
        return keyTeacher;
    }

    public void setKeyTeacher(int keyTeacher) {
        this.keyTeacher = keyTeacher;
    }

    public String getPasswordTea() {
        return passwordTea;
    }

    public void setPasswordTea(String passwordTea) {
        this.passwordTea = passwordTea;
    }

    public String getIdTea() {
        return idTea;
    }

    public void setIdTea(String idTea) {
        this.idTea = idTea;
    }

    public String getNameTea() {
        return nameTea;
    }

    public void setNameTea(String nameTea) {
        this.nameTea = nameTea;
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return keyTeacher == teacher.keyTeacher && Objects.equals(passwordTea, teacher.passwordTea) && Objects.equals(idTea, teacher.idTea) && Objects.equals(nameTea, teacher.nameTea) && Objects.equals(sex, teacher.sex) && Objects.equals(birthday, teacher.birthday) && Objects.equals(numberPhone, teacher.numberPhone) && Objects.equals(address, teacher.address);
    }

    public boolean isConnectPass(String text) {
        return passwordTea.equals(text.trim());
    }
}
