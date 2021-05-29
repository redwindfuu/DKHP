package com.Course.Pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CoursePK implements Serializable {
    private Object idOb;
    private Coursesession idCoursesession;
    private String room;
    private byte daystudy;
    private byte timestudy;

    public Object getIdOb() {
        return idOb;
    }

    public void setIdOb(Object idOb) {
        this.idOb = idOb;
    }

    public Coursesession getIdCoursesession() {
        return idCoursesession;
    }

    public void setIdCoursesession(Coursesession idCoursesession) {
        this.idCoursesession = idCoursesession;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public byte getDaystudy() {
        return daystudy;
    }

    public void setDaystudy(byte daystudy) {
        this.daystudy = daystudy;
    }

    public byte getTimestudy() {
        return timestudy;
    }

    public void setTimestudy(byte timestudy) {
        this.timestudy = timestudy;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof CoursePK)) return false;
        CoursePK coursePK = (CoursePK) o;
        return getDaystudy() == coursePK.getDaystudy() && getTimestudy() == coursePK.getTimestudy() && Objects.equals(getIdOb(), coursePK.getIdOb()) && Objects.equals(getIdCoursesession(), coursePK.getIdCoursesession()) && Objects.equals(getRoom(), coursePK.getRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdOb(), getIdCoursesession(), getRoom(), getDaystudy(), getTimestudy());
    }

    @Override
    public String toString() {
        return "CoursePK{" +
                "idOb=" + idOb +
                ", idCoursesession=" + idCoursesession +
                ", room='" + room + '\'' +
                ", daystudy=" + daystudy +
                ", timestudy=" + timestudy +
                '}';
    }
}
