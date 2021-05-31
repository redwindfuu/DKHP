package com.Course.StudentGUI;

import com.Course.Pojo.Course;
import com.Course.Pojo.Semester;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.io.Serializable;
import java.sql.Date;

public class viewCourse implements Serializable {
    private Course hocphan;
    private final SimpleStringProperty mamon;
    private final SimpleStringProperty Giaovien;
    private final SimpleStringProperty hocki;
    private final SimpleStringProperty Namhoc;
    private Date Thoigianmo;
    private Date Thoigiandong;
    private final SimpleStringProperty phong;
    private final SimpleStringProperty Ngayhoc;
    private final SimpleStringProperty Ca;
    private Integer Slot;
    private CheckBox selecte;

    public Course getHocphan() {
        return hocphan;
    }

    public void setHocphan(Course hocphan) {
        this.hocphan = hocphan;
    }

    public String getMamon() {
        return mamon.get();
    }

    public SimpleStringProperty mamonProperty() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon.set(mamon);
    }

    public String getGiaovien() {
        return Giaovien.get();
    }

    public SimpleStringProperty giaovienProperty() {
        return Giaovien;
    }

    public void setGiaovien(String giaovien) {
        this.Giaovien.set(giaovien);
    }

    public String getHocki() {
        return hocki.get();
    }

    public SimpleStringProperty hockiProperty() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki.set(hocki);
    }

    public String getNamhoc() {
        return Namhoc.get();
    }

    public SimpleStringProperty namhocProperty() {
        return Namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.Namhoc.set(namhoc);
    }




    public String getPhong() {
        return phong.get();
    }

    public SimpleStringProperty phongProperty() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong.set(phong);
    }

    public String getNgayhoc() {
        return Ngayhoc.get();
    }

    public Date getThoigianmo() {
        return Thoigianmo;
    }

    public void setThoigianmo(Date thoigianmo) {
        Thoigianmo = thoigianmo;
    }

    public Date getThoigiandong() {
        return Thoigiandong;
    }

    public void setThoigiandong(Date thoigiandong) {
        Thoigiandong = thoigiandong;
    }

    public SimpleStringProperty ngayhocProperty() {
        return Ngayhoc;
    }

    public void setNgayhoc(String ngayhoc) {
        this.Ngayhoc.set(ngayhoc);
    }

    public String getCa() {
        return Ca.get();
    }

    public SimpleStringProperty caProperty() {
        return Ca;
    }

    public void setCa(String ca) {
        this.Ca.set(ca);
    }

    public Integer getSlot() {
        return Slot;
    }

    public void setSlot(Integer slot) {
        Slot = slot;
    }

    public CheckBox getSelecte() {
        return selecte;
    }

    public void setSelecte(CheckBox selecte) {
        this.selecte = selecte;
    }

    public static String SgetDayStudy(int i){
        String n = "";
        switch (i){
            case 1:
                n= "Thứ hai";
                break;
            case 2:
                n= "Thứ ba";
                break;
            case 3:
                n= "Thứ tư";
                break;
            case 4:
                n= "Thứ năm";
                break;
            case 5:
                n= "Thứ sáu";
                break;
            case 6:
                n= "Thứ bảy";
                break;
            case 7:
                n= "Chủ nhật";
                break;
            default:
                break;
        }
        return n;
    }
    public static String SgetTimeStudy(int i){
        String n = "";
        switch (i){
            case 1:
                n= "7:30 – 9:30";
                break;
            case 2:
                n= "9:30 – 11:30";
                break;
            case 3:
                n= "13:30 – 15:30";
                break;
            case 4:
                n= "15:30 – 17:30";
                break;
            default:
                break;
        }
        return n;
    }


    public viewCourse(Course HP) {
        this.hocphan = HP;

        this.mamon = new SimpleStringProperty(HP.getIdCourse().getIdOb().getIdOb());
        Giaovien =  new SimpleStringProperty(HP.getNameteacher());
        this.hocki =  new SimpleStringProperty(HP.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester().getSemeId());
        Namhoc =  new SimpleStringProperty(HP.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester().getYearSeme());
        Thoigianmo = HP.getIdCourse().getIdCoursesession().getIdCoursesession().getTimeBeg();
        Thoigiandong = HP.getIdCourse().getIdCoursesession().getTimeFin();
        this.phong =  new SimpleStringProperty(HP.getIdCourse().getRoom());
        Ngayhoc =  new SimpleStringProperty(SgetDayStudy(HP.getIdCourse().getDaystudy()));
        Ca =  new SimpleStringProperty(SgetTimeStudy(HP.getIdCourse().getTimestudy()));
        Slot = HP.getSlot();
        selecte = new CheckBox();
    }



}
