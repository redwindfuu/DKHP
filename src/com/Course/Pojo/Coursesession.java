package com.Course.Pojo;

import java.sql.Date;
import java.util.Objects;

public class Coursesession {
    private CoursesessionPK idCoursesession ;
    private Date timeFin;

    public CoursesessionPK getIdCoursesession() {
        return idCoursesession;
    }

    public void setIdCoursesession(CoursesessionPK idCoursesession) {
        this.idCoursesession = idCoursesession;
    }

    public Date getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(Date timeFin) {
        this.timeFin = timeFin;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Coursesession)) return false;
        Coursesession that = (Coursesession) o;
        return Objects.equals(getIdCoursesession(), that.getIdCoursesession()) && Objects.equals(getTimeFin(), that.getTimeFin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCoursesession(), getTimeFin());
    }

    @Override
    public String toString() {
        return  idCoursesession.toString() +
                " đến " + timeFin.toString() ;
    }
}
