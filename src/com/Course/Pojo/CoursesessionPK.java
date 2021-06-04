package com.Course.Pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CoursesessionPK implements Serializable {
    private Semester idSemester;
    private Date timeBeg;

    public Semester getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(Semester idSemester) {
        this.idSemester = idSemester;
    }

    public Date getTimeBeg() {
        return timeBeg;
    }

    public void setTimeBeg(Date timeBeg) {
        this.timeBeg = timeBeg;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof CoursesessionPK)) return false;
        CoursesessionPK that = (CoursesessionPK) o;
        return Objects.equals(getIdSemester(), that.getIdSemester()) && Objects.equals(getTimeBeg(), that.getTimeBeg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSemester(), getTimeBeg());
    }

    @Override
    public String toString() {
        return  timeBeg.toString() ;
    }
}
