package com.Course.TeacherGUI.StudentListGUI;

import com.Course.DAO.StudentDAO;
import com.Course.DAO.TeacherDAO;
import com.Course.Pojo.Student;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class setTTSV implements Initializable {

    @FXML
    private ImageView IconPage;
    @FXML
    private TextField ID;
    @FXML
    private TextField Hoten;
    @FXML
    private DatePicker ngaysinh;
    @FXML
    private ToggleGroup GenderList;
    @FXML
    private RadioButton Nam;
    @FXML
    private RadioButton Nu;
    @FXML
    private TextField std;
    @FXML
    private TextField Diachi;
    @FXML
    private Button Xacnhan;
    private Student thisStu;


    public void SetStudent(Student tc){
        this.thisStu = tc;
        Hoten.setText(thisStu.getNameStu());
        std.setText(thisStu.getNumberPhone());
        if(thisStu.getSex().equals("Nam")){
            Nam.setSelected(true);
        }else{
            Nu.setSelected(true);
        }
        Diachi.setText(thisStu.getAddress());
        ID.setText(thisStu.getIdStu());
        ID.setEditable(false);
        ngaysinh.setValue(thisStu.getBirthday().toLocalDate());
    }

    public void XacnhanOnAction(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn có muốn cập nhật thông tin không ?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK){
            thisStu.setNameStu(Hoten.getText().trim());
            thisStu.setAddress(Diachi.getText().trim());
            thisStu.setNumberPhone(std.getText().trim());
            thisStu.setBirthday(Date.valueOf(ngaysinh.getValue()));
            thisStu.setSex(((RadioButton)GenderList.getSelectedToggle()).getText());
            StudentDAO.updateStudent(thisStu);
            Stage stage = (Stage) Xacnhan.getScene().getWindow();
            stage.close();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/edit.png");
        Image image = new Image(Avafile.toURI().toString());
        IconPage.setImage(image);
    }





}
