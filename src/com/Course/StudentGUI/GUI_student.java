package com.Course.StudentGUI;

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

public class GUI_student implements Initializable {


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
    private ImageView StudentAvatar;
    @FXML
    private GridPane RePassPane;
    @FXML
    private GridPane ReinfoPanel;
    @FXML
    private GridPane InfoPane;

    public void setUsers(){

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/graduate-user-icon.png");
        Image image = new Image(Avafile.toURI().toString());
        StudentAvatar.setImage(image);




    }
// thông tin sinh viên



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
    private Label TT_Class;
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
    private ToggleGroup Listgender;
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
// Đăng kí học Phần





}
