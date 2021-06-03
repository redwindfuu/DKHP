package com.Course.TeacherGUI.CourseListGUI;

import com.Course.Pojo.Course;
import com.Course.Pojo.Student;
import com.Course.TeacherGUI.StudentListGUI.viewCourse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class XemDSSV implements Initializable {

    private Student student;

    @FXML
    private ImageView iconhocphan;
    @FXML
    private TableView<viewCourse>  Banghocphan;
    @FXML
    private TableColumn<viewCourse,String> mamonhoc;
    @FXML
    private TableColumn<viewCourse,String> monhoc;
    @FXML
    private TableColumn<viewCourse,String> giangvien;
    @FXML
    private TableColumn<viewCourse,String> hocki;
    @FXML
    private TableColumn<viewCourse,String> Namhoc;
    @FXML
    private TableColumn<viewCourse,String> ngay;
    @FXML
    private TableColumn<viewCourse,String> gio;
    @FXML
    private TableColumn<viewCourse,String> phong;
    ObservableList<viewCourse> h = FXCollections.observableArrayList();
    public void setStudent(Student st){
        this.student= st;
        for (Course i : st.getCourses()) {
            h.add(new viewCourse(i));
        }
        Banghocphan.setItems(h);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/online-course.png");
        Image image = new Image(Avafile.toURI().toString());
        iconhocphan.setImage(image);
        mamonhoc.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("IDmon"));
        monhoc.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("tenmon"));
        giangvien.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Giangvien"));
        hocki.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Hocki"));
        Namhoc.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Namhoc"));
        phong.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Phong"));
        ngay.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Ngay"));
        gio.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Gio"));



    }
}
