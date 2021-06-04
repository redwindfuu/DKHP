package com.Course.Pojo;

import java.sql.Date;
import java.util.Objects;

public class Semester {


    private SemesterPK idSemester;
    private Date daybeg;
    private Date dayfinal;
    private int thisSeme;


    public int getThisSeme() {
        return thisSeme;
    }

    public void setThisSeme(int thisSeme) {
        this.thisSeme = thisSeme;
    }

    public Semester() {

    }
    public Semester(SemesterPK idSemester, Date daybeg, Date dayfinal) {
        this.idSemester = idSemester;
        this.daybeg = daybeg;
        this.dayfinal = dayfinal;
        this.thisSeme =0;
    }

    public Semester(SemesterPK idSemester) {
        this.idSemester = idSemester;
    }
    public SemesterPK getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(SemesterPK idSemester) {
        this.idSemester = idSemester;
    }

    public Date getDaybeg() {
        return daybeg;
    }

    public void setDaybeg(Date daybeg) {
        this.daybeg = daybeg;
    }

    public Date getDayfinal() {
        return dayfinal;
    }
    public void setDayfinal(Date dayfinal) {
        this.dayfinal = dayfinal;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Semester)) return false;
        Semester semester = (Semester) o;
        return idSemester.equals(semester.idSemester) && Objects.equals(daybeg, semester.daybeg) && Objects.equals(getDayfinal(), semester.getDayfinal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemester, daybeg, getDayfinal());
    }



    @Override
    public String toString() {
        return  idSemester.toString() ;
    }
}

