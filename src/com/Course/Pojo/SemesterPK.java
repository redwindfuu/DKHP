package com.Course.Pojo;

import java.io.Serializable;
import java.util.Objects;

public class SemesterPK implements Serializable {
    private String semeId;
    private String yearSeme;

    public SemesterPK(String semeId, String yearSeme) {
        this.semeId = semeId;
        this.yearSeme = yearSeme;
    }

    public SemesterPK() {

    }

    public String getSemeId() {
        return semeId;
    }

    public void setSemeId(String semeId) {
        this.semeId = semeId;
    }

    public String getYearSeme() {
        return yearSeme;
    }

    public void setYearSeme(String yearSeme) {
        this.yearSeme = yearSeme;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof SemesterPK)) return false;
        SemesterPK that = (SemesterPK) o;
        return getSemeId().equals(that.getSemeId()) && getYearSeme().equals(that.getYearSeme());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemeId(), getYearSeme());
    }

    @Override
    public String toString() {
        return  semeId + " năm học " + yearSeme;
    }
}