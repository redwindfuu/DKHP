package com.Course.TeacherGUI.CourseListGUI;

import com.Course.DAO.CourseDAO;
import com.Course.DAO.SemesterDAO;
import com.Course.DAO.StudentDAO;
import com.Course.Pojo.ClaSs;
import com.Course.Pojo.Course;
import com.Course.Pojo.Student;
import com.Course.StudentGUI.viewCourse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class XemDSSV implements Initializable {

    private Course hocphan;

    @FXML
    private ImageView iconhocphan;
    @FXML
    private TableView<viewStudent>  BangSV;
    @FXML
    private TableColumn<viewStudent,String> IDSV_column;
    @FXML
    private TableColumn<viewStudent,String> HotenSV_column;
    @FXML
    private TableColumn<viewStudent,String> NgaysinhSV_column;
    @FXML
    private TableColumn<viewStudent,String> GioitinhSV_column;
    @FXML
    private TableColumn<viewStudent,String> SDTSV_coulumn;
    @FXML
    private TableColumn<viewStudent,String> DiachiSV_column;
    @FXML
    private TableColumn<viewStudent,ClaSs> Lop_column;
    @FXML
    private TableColumn<viewStudent, CheckBox> Huy_column;
    @FXML
    private TextField MSSV;
    ObservableList<viewStudent> Lst = FXCollections.observableArrayList();
    public void setCourse(Course st){
        Lst.clear();
        SemesterDAO.getMainSemester();
        this.hocphan = st;
        for (Student i : hocphan.getStudents()) {
            Lst.add(new viewStudent(i));
        }
        BangSV.setItems(Lst);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/online-course.png");
        Image image = new Image(Avafile.toURI().toString());
        iconhocphan.setImage(image);
        IDSV_column.setCellValueFactory(new PropertyValueFactory<viewStudent,String>("ID"));
        HotenSV_column.setCellValueFactory(new PropertyValueFactory<viewStudent,String>("hoten"));
        NgaysinhSV_column.setCellValueFactory(new PropertyValueFactory<viewStudent,String>("ngaysinh"));
        GioitinhSV_column.setCellValueFactory(new PropertyValueFactory<viewStudent,String>("giotinh"));
        SDTSV_coulumn.setCellValueFactory(new PropertyValueFactory<viewStudent,String>("sdt"));
        DiachiSV_column.setCellValueFactory(new PropertyValueFactory<viewStudent,String>("diachi"));
        Lop_column.setCellValueFactory(new PropertyValueFactory<viewStudent, ClaSs>("lop"));
        Huy_column.setCellValueFactory(new PropertyValueFactory<viewStudent,CheckBox>("huy"));
        SemesterDAO.getMainSemester();

    }

    @FXML
    private void ThemSVonAction(ActionEvent actionEvent) {
        if(!MSSV.getText().isEmpty()&& StudentDAO.getStudent(MSSV.getText()) != null){
            hocphan.getStudents().add(StudentDAO.getStudent(MSSV.getText()));
            CourseDAO.updateCourse(hocphan);
            Stage stage = (Stage) MSSV.getScene().getWindow();
            stage.close();
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("thêm học sinh vào môn học" );
            alert1.setContentText("thêm thành công ");
            alert1.showAndWait();

        }

        SemesterDAO.getMainSemester();
        setCourse(hocphan);
    }

    @FXML
    private void XoaSVAction(ActionEvent actionEvent) {
        for (viewStudent h: Lst) {
            if(h.getHuy().isSelected()){
                hocphan.getStudents().remove(h.getSt());
                CourseDAO.updateCourse(hocphan);
                Stage stage = (Stage) MSSV.getScene().getWindow();
                stage.close();
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("xóa học sinh vào môn học" );
                alert1.setContentText("xóa thành công ");
                alert1.showAndWait();
            }
        }
        setCourse(hocphan);
    }
}
