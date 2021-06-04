package com.Course.TeacherGUI.CourseListGUI;

import com.Course.DAO.*;
import com.Course.Pojo.*;
import com.Course.Pojo.Object;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class themHP implements Initializable {
    @FXML
    private ImageView iconPage;
    @FXML
    private ChoiceBox<Object> ChoiceMonhoc;
    @FXML
    private ChoiceBox<Coursesession> ChoiceKiDangki;
    @FXML
    private TextField giangvien;
    @FXML
    private TextField phong;
    @FXML
    private TextField Slot;
    @FXML
    private ChoiceBox<String> ChoiceCa;
    @FXML
    private ChoiceBox<String> ChoiceNgay;

    ObservableList<Object> objects = FXCollections.observableArrayList(ObjectDAO.getALlObjectList());
    ObservableList<Coursesession> CoursesessionLists ;
    ObservableList<String> Thu = FXCollections.observableArrayList("Thứ hai","Thứ ba","Thứ tư","Thứ năm","Thứ sáu","Thứ bảy","Chủ nhật");
    ObservableList<String>  cahoc = FXCollections.observableArrayList("7:30 – 9:30","9:30 – 11:30","13:30 – 15:30","15:30 – 17:30");
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
    public int NgetDayStudy(String i){
        int n = 1;
        switch (i){
            case  "Thứ hai":
                n = 1;
                break;
            case  "Thứ ba":
                n = 2 ;
                break;
            case  "Thứ tư":
                n = 3;
                break;
            case  "Thứ năm":
                n = 4;
                break;
            case "Thứ sáu":
                n =5;
                break;
            case  "Thứ bảy":
                n=6;
                break;
            case  "Chủ nhật":
                n=7;
                break;
            default:
                break;
        }
        return n;
    }
    public static int NgetTimeStudy(String i){

        if (i.trim().equals("7:30 – 9:30".trim())) return 1;
        if (i.trim().equals("9:30 – 11:30".trim())) return  2;
        if (i.trim().equals("13:30 – 15:30".trim())) return 3;
        if (i.trim().equals("15:30 – 17:30".trim())) return  4; else
            return 1;

    }
    private boolean trunggio(Course v1){
        List<Course> n = CourseDAO.getALlCourseList();
        for (Course i: n ) {
            if(v1.DKHP_forTeacher(i)){
                return true;
            }
        }
        return false;
    }
    public void ThemButtonClick(ActionEvent e){
        String msg ="";
        if(!phong.getText().isEmpty() && !giangvien.getText().isEmpty() && !Slot.getText().isEmpty()&& Slot.getText().chars().allMatch( Character::isDigit )
            && !ChoiceCa.getValue().isEmpty() && !ChoiceNgay.getValue().isEmpty() && ChoiceMonhoc.getValue() != null
                && ChoiceKiDangki.getValue() != null ){
                Object mon = ChoiceMonhoc.getValue();
                Coursesession kidk = ChoiceKiDangki.getValue();
                int cahc = NgetTimeStudy(ChoiceCa.getValue());
                int ngay = NgetDayStudy(ChoiceNgay.getValue());
                CoursePK newCPK= new CoursePK();
                newCPK.setIdCoursesession(kidk);
                newCPK.setIdOb(mon);
                newCPK.setRoom(phong.getText());
                newCPK.setTimestudy((byte) cahc);
                newCPK.setDaystudy((byte) ngay);
                Course st =new Course();
                st.setIdCourse(newCPK);
                st.setNameteacher(giangvien.getText());
                st.setSlot(Integer.parseInt(Slot.getText()));
                if((CourseDAO.getCourse(st.getIdCourse().getIdOb().getIdOb(),
                    st.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester(),st.getIdCourse().getIdCoursesession().getIdCoursesession().getTimeBeg(),
                    st.getIdCourse().getRoom(),st.getIdCourse().getDaystudy(),st.getIdCourse().getTimestudy()) == null)&&(trunggio(st) ==false)){
                CourseDAO.addCourse(st);
                    msg =" thêm thành công";
                    Stage t = (Stage) iconPage.getScene().getWindow();
                    t.close();
                }else{
                    msg =" đã tồn tại học phần này";
                }
        }else{
           msg ="Nhập Sai ";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" thêm học phần");
        alert.setContentText(msg);
        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/online-course.png");
        Image image = new Image(Avafile.toURI().toString());
        iconPage.setImage(image);
        List<Coursesession> lst = CoursesessionDAO.getALlCoursesessionList();
        CoursesessionLists = FXCollections.observableArrayList();
        Semester h = SemesterDAO.getMainSemester();
        for (Coursesession i: lst) {
            if( i.getIdCoursesession().getIdSemester().equals(h)){
                CoursesessionLists.add(i);
            }
        }
        ChoiceKiDangki.setItems(CoursesessionLists);
        ChoiceKiDangki.setValue(CoursesessionLists.get(0));
        ChoiceMonhoc.setItems(objects);
        ChoiceMonhoc.setValue(objects.get(0));
        ChoiceCa.setItems(cahoc);
        ChoiceCa.setValue(cahoc.get(0));
        ChoiceNgay.setItems(Thu);
        ChoiceNgay.setValue(Thu.get(0));


    }
}
