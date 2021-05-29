package com.Course.Pojo;

import java.io.Serializable;
import java.util.Objects;

public class Object implements Serializable {

    private String idOb;
    private String nameOb;
    private long credit;
    public String getIdOb() {
        return idOb;
    }


    @Override
    public String toString() {
        return "Object{" +
                "idOb='" + idOb + '\'' +
                ", nameOb='" + nameOb + '\'' +
                ", credit=" + credit +
                '}';
    }
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Object)) return false;
        return getCredit() == ((Object) o).getCredit() && Objects.equals(getIdOb(), ((Object) o).getIdOb()) && Objects.equals(getNameOb(), ((Object) o).getNameOb());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdOb(), getNameOb(), getCredit());
    }

    public void setIdOb(String idOb) {
        this.idOb = idOb;
    }

    public String getNameOb() {
        return nameOb;
    }

    public void setNameOb(String nameOb) {
        this.nameOb = nameOb;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }




}
