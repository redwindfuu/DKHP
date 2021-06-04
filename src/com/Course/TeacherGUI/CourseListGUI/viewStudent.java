package com.Course.TeacherGUI.CourseListGUI;

import com.Course.Pojo.ClaSs;
import com.Course.Pojo.Student;
import javafx.scene.control.CheckBox;

import java.sql.Date;

public class viewStudent {
    private Student st;
    private String ID;
    private String hoten;
    private String giotinh;
    private Date ngaysinh;
    private String sdt;
    private String diachi;
    private ClaSs lop;
    private CheckBox huy;
    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGiotinh() {
        return giotinh;
    }

    public void setGiotinh(String giotinh) {
        this.giotinh = giotinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public ClaSs getLop() {
        return lop;
    }

    public void setLop(ClaSs lop) {
        this.lop = lop;
    }

    public CheckBox getHuy() {
        return huy;
    }

    public void setHuy(CheckBox huy) {
        this.huy = huy;
    }


    public viewStudent(Student st) {
        this.st = st;
        ID = st.getIdStu();
        hoten= st.getNameStu();
        giotinh =st.getSex();
        ngaysinh =st.getBirthday();
        sdt = st.getNumberPhone();
        diachi = st.getAddress();
        lop = st.getIdClass();
        huy = new CheckBox();
    }
}
