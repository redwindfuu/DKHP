package com.Course.TeacherGUI;

import com.Course.Pojo.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI_teacher implements Initializable {
    @FXML
    private ImageView TeacherAvatar;

    private Teacher User;

// Trang thông tin giáo vụ
    @FXML
    private Button ButtonInformation;
    @FXML
    private Button ButtonReInformation;
    @FXML
    private Button ButtonRePassword;
    @FXML
    private Button ButtonOut;
    @FXML
    private Label LabelOut;
    @FXML
    private GridPane RePassPane;
    @FXML
    private GridPane ReinfoPanel;
    @FXML
    private GridPane InfoPane;
    @FXML
    private Label helloWorld;

    public void setUsers(Teacher users){
        this.User = users;
        helloWorld.setText("Xin chào, "+User.getNameTea());
        TT_name.setText(User.getNameTea());
        TT_ID.setText(User.getIdTea());
        TT_numberphone.setText(User.getNumberPhone());
        TT_sex.setText(User.getSex());
        TT_Address.setText(User.getAddress());
        TT_Type.setText("Sinh viên");
        TT_birth.setText(User.getBirthday().toString());

        ReputName.setText(User.getNameTea());
        reputNumberPhone.setText(User.getNumberPhone());
        if(User.getSex().equals("Nam")){
            Male.setSelected(true);
        }else{
            female.setSelected(true);
        }
        reputAddress.setText(User.getAddress());
        reputID.setText(User.getIdTea());
        reputID.setEditable(false);
        reputBirth.setValue(User.getBirthday().toLocalDate());
    }

    public void OutonAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/Course/LoginAndSignup/login.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Quản Lý Học Phần");
        signUpStage.setScene(new Scene(root,  650, 400));
        signUpStage.show();
        Stage stage = (Stage) LabelOut.getScene().getWindow();
        stage.close();
    }
    public void OutonActionforLabel(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/Course/LoginAndSignup/login.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Quản Lý Học Phần");
        signUpStage.setScene(new Scene(root,  650, 400));
        signUpStage.show();
        Stage stage = (Stage) LabelOut.getScene().getWindow();
        stage.close();
    }
    public void ButtonInformationOnAction(ActionEvent e){
        InfoPane.setVisible(true);
        ReinfoPanel.setVisible(false);
        RePassPane.setVisible(false);
    }
    public void ButtonReInformationOnAction(ActionEvent e){
        InfoPane.setVisible(false);
        ReinfoPanel.setVisible(true);
        RePassPane.setVisible(false);
    }
    public void ButtonRePasswordOnAction(ActionEvent e){
        InfoPane.setVisible(false);
        ReinfoPanel.setVisible(false);
        RePassPane.setVisible(true);
    }


// Trang lớp học
    @FXML
    private Label TT_name;
    @FXML
    private Label TT_ID;
    @FXML
    private Label TT_Address;
    @FXML
    private Label TT_numberphone;
    @FXML
    private Label TT_Type;
    @FXML
    private Label TT_birth;
    @FXML
    private Label TT_sex;



    //Chỉnh sửa thông tin sinh viên
    @FXML
    private TextField ReputName;
    @FXML
    private  TextField reputID;
    @FXML
    private  TextField reputAddress;
    @FXML
    private  TextField reputNumberPhone;
    @FXML
    private RadioButton Male;
    @FXML
    private RadioButton female;
    @FXML
    private DatePicker reputBirth;
    @FXML
    private ToggleGroup ListGender;
    @FXML
    private Button buttonUpdate;

    public void buttonUpdateOnAction(ActionEvent e){

    }









    // Đổi mật khẩu
    @FXML
    private TextField changePass_old;
    @FXML
    private TextField changePass_new;
    @FXML
    private TextField changePass_reNew;
    @FXML
    private Button buttonRePass;

    public void buttonRePassOnAction(ActionEvent e){

    }







// Trang môn học
// Trang Đăng kí Học Phần
// Trang học kì
// Tài Khoản giáo viên
//

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/professor.png");
        Image image = new Image(Avafile.toURI().toString());
        TeacherAvatar.setImage(image);
    }
}
