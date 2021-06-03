package com.Course.TeacherGUI.ClassListGUI;

import com.Course.Pojo.ClaSs;

import java.io.Serializable;
import java.util.Objects;

public class ClassList_info implements Serializable {
    private ClaSs thisClass;
    private String idClass;
    private String nameClass;
    private Integer TongSV;
    private Integer SVnu;
    private Integer SVnam;

    public ClassList_info(){

    }
    public ClassList_info(ClaSs h) {
        this.thisClass = h;
        idClass = String.valueOf(h.getIdClss());
        nameClass = h.getNameClass();
        TongSV = h.totalStudent();
        SVnu = h.totalFemaleStudent();
        SVnam = TongSV - SVnu;
    }

    public ClaSs getThisClass() {
        return thisClass;
    }

    public void setThisClass(ClaSs thisClass) {
        this.thisClass = thisClass;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Integer getTongSV() {
        return TongSV;
    }

    public void setTongSV(Integer tongSV) {
        TongSV = tongSV;
    }

    public Integer getSVnu() {
        return SVnu;
    }

    public void setSVnu(Integer SVnu) {
        this.SVnu = SVnu;
    }

    public Integer getSVnam() {
        return SVnam;
    }

    public void setSVnam(Integer SVnam) {
        this.SVnam = SVnam;
    }

    public ClassList_info(ClaSs thisClass, String idClass, String nameClass, Integer tongSV, Integer SVnu, Integer SVnam) {
        this.thisClass = thisClass;
        this.idClass = idClass;
        this.nameClass = nameClass;
        TongSV = tongSV;
        this.SVnu = SVnu;
        this.SVnam = SVnam;
    }
}
