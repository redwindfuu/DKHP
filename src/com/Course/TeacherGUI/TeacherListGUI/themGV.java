package com.Course.TeacherGUI.TeacherListGUI;

import com.Course.DAO.TeacherDAO;
import com.Course.Pojo.Teacher;
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
import java.util.ResourceBundle;

public class themGV implements Initializable {
    @FXML
    private ImageView iconPage;
    @FXML
    private TextField ID;
    @FXML
    private PasswordField Matkhau;
    @FXML
    private TextField Hoten;
    @FXML
    private TextField SDT;
    @FXML
    private TextField Diachi;
    @FXML
    private DatePicker Ngaysinh;
    @FXML
    private ToggleGroup GenderList;
    @FXML
    private RadioButton Nam;
    @FXML
    private RadioButton Nu;
    @FXML
    private Button ThemButton;
    String Gender ="Nam";
    public void getMale(ActionEvent e) {
        Gender = Nam.getText();
        // System.out.print(Gender);
    }
    public void getFemale(ActionEvent e) {
        Gender = Nu.getText();
        //   System.out.print(Gender);
    }

    public void ThemButtonClick(ActionEvent e){
        if(!Hoten.getText().trim().isEmpty() && !Diachi.getText().trim().isEmpty()
                && !SDT.getText().trim().isEmpty()&& (SDT.getText().length()<=10)
                && !ID.getText().trim().isEmpty() &&
                !Matkhau.getText().trim().isEmpty() && Ngaysinh != null){
            if (TeacherDAO.getTeacher(ID.getText()) == null) {

                    Teacher newteacher = new Teacher(Matkhau.getText(), ID.getText(), Hoten.getText(), Gender, Date.valueOf(Ngaysinh.getValue()), SDT.getText(), Diachi.getText());
                    TeacherDAO.addTeacher(newteacher);
                    System.out.println("tao giao vu");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Đăng kí");
                    alert.setContentText("tạo thành công");
                    alert.showAndWait();
                    Stage stage = (Stage) ThemButton.getScene().getWindow();
                    stage.close();

        }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Đăng kí");
                alert.setContentText("Mã ID tồn tại ");
                alert.showAndWait();
            }
    }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Đăng kí");
            alert.setContentText("Nhập Sai ");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/businessman.png");
        Image image = new Image(Avafile.toURI().toString());
        iconPage.setImage(image);
    }
}
