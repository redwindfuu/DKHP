package com.Course.StudentGUI;

import com.Course.DAO.StudentDAO;
import com.Course.Pojo.Course;
import com.Course.Pojo.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class GUI_student implements Initializable {

    private Student User;
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
    @FXML
    private Label helloWorld;

    public void setUsers(Student users){
        this.User = users;
        helloWorld.setText("Xin chào, "+User.getNameStu());
        TT_name.setText(User.getNameStu());
        TT_ID.setText(User.getIdStu());
        TT_numberphone.setText(User.getNumberPhone());
        TT_sex.setText(User.getSex());
        TT_Address.setText(User.getAddress());
        TT_Type.setText("Sinh viên");
        TT_birth.setText(User.getBirthday().toString());
        if(User.getClass() != null){
            TT_Class.setText(User.getIdClass().getNameClass());
        }else
            TT_Class.setText("chưa có");
        ReputName.setText(User.getNameStu());
        reputNumberPhone.setText(User.getNumberPhone());
        if(User.getSex().equals("Nam")){
            Male.setSelected(true);
        }else{
            female.setSelected(true);
        }
        reputAddress.setText(User.getAddress());
        reputID.setText(User.getIdStu());
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
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn có muốn cập nhật mật khẩu không ?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK){
        User.setNameStu(ReputName.getText());
        User.setAddress(reputAddress.getText());
        User.setNumberPhone(reputNumberPhone.getText());
        User.setBirthday(Date.valueOf(reputBirth.getValue()));
        User.setSex(Listgender.getSelectedToggle().toString());
        StudentDAO.updateStudent(User);
        }
        setUsers(User);
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
        if(User.isConnectPass(changePass_old.getText())){
            if(changePass_new.getText().equals(changePass_reNew.getText())){
                User.setPasswordStu(changePass_new.getText());
                StudentDAO.updateStudent(User);
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Đổi Mật Khẩu");
                alert.setContentText("Đổi thành công");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Đổi Mật Khẩu");
                alert.setContentText("Đổi thất bại");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Đổi Mật Khẩu");
            alert.setContentText("Đổi thất bại");
            alert.showAndWait();
        }
    }
// Đăng kí học Phần

    @FXML
    private TableView<Course> Userhocphan;
    @FXML
    private TableView<Course> hocphanmo;
    @FXML
    private Label labelSeme;
    @FXML
    private Label schoolyear;



}
