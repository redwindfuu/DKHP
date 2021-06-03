package com.Course.TeacherGUI.StudentListGUI;

import com.Course.Pojo.Course;

public class viewCourse {
    private Course thisCourse;
    private String IDmon;
    private String tenmon;
    private String Giangvien;
    private String Hocki;
    private String Namhoc;
    private String Phong;
    private String Ngay;
    private String Gio;
    private Integer Slot;

    public Integer getSlot() {
        return Slot;
    }

    public void setSlot(Integer slot) {
        Slot = slot;
    }

    public viewCourse(Course ts) {
        this.thisCourse = ts;
        IDmon = thisCourse.getIdCourse().getIdOb().getIdOb();
        tenmon =thisCourse.getIdCourse().getIdOb().getNameOb();
        Giangvien = thisCourse.getNameteacher();
        Hocki = thisCourse.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester().getSemeId();
        Namhoc= thisCourse.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester().getYearSeme();
        Phong= thisCourse.getIdCourse().getRoom();
        Ngay=SgetDayStudy(thisCourse.getIdCourse().getDaystudy());
        Gio=SgetTimeStudy(thisCourse.getIdCourse().getTimestudy());
        Slot = thisCourse.getSlot();
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
    public Course getThisCourse() {
        return thisCourse;
    }

    public void setThisCourse(Course thisCourse) {
        this.thisCourse = thisCourse;
    }

    public String getIDmon() {
        return IDmon;
    }

    public void setIDmon(String IDmon) {
        this.IDmon = IDmon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGiangvien() {
        return Giangvien;
    }

    public void setGiangvien(String giangvien) {
        Giangvien = giangvien;
    }

    public String getHocki() {
        return Hocki;
    }

    public void setHocki(String hocki) {
        Hocki = hocki;
    }

    public String getNamhoc() {
        return Namhoc;
    }

    public void setNamhoc(String namhoc) {
        Namhoc = namhoc;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getGio() {
        return Gio;
    }

    public void setGio(String gio) {
        Gio = gio;
    }
}
