package com.Course.LoginAndSignup;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI_login implements Initializable {
    private ObservableList<String> AccounttypeList = FXCollections.observableArrayList("Giáo vụ", "Sinh viên");
    @FXML
    private  Button SignupButton;
    @FXML
    private Button cancelButton ;
    @FXML
    private Label loginmessagelabel;
    @FXML
    private ChoiceBox Accounttypebox;
    @FXML
    private TextField UserText;
    @FXML
    private PasswordField PasswordText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Accounttypebox.setValue("Sinh viên");
        Accounttypebox.setItems(AccounttypeList);
    }


    public void signupButtonOnAction(ActionEvent e){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Quản Lý Học Phần");
            signUpStage.setScene(new Scene(root, 564, 684));
            signUpStage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    public void loginButtonOnAction(ActionEvent e){
        if(UserText.getText().isBlank() && PasswordText.getText().isBlank()){
            loginmessagelabel.setText("invalid login please try again");
        }else {

            try {
                validatelogin();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    private void validatelogin() throws IOException  {
        String type = Accounttypebox.getValue().toString();
        Parent root;
        if(type == "Sinh viên"){
            /*Student doituong = null;
            String tk = UserText.getText();
            try {
                doituong = StudentDAO.getStudent(tk);
            }catch (HibernateException f){
                f.printStackTrace();
                System.out.println("loi ");
            }

            if(doituong != null) {
                if (doituong.isConnectPass(PasswordText.getText())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Đăng nhập");
                alert.setContentText("Đăng nhập tài khoản sinh viên");
                alert.showAndWait();
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                root = FXMLLoader.load(getClass().getResource("/com/Course/StudentGUI/GUI_student.fxml"));
                Stage signUpStage = new Stage();
                signUpStage.setTitle("Quản Lý Học Phần");
                signUpStage.setScene(new Scene(root, 945, 678));
                signUpStage.show();
                }else{
                    loginmessagelabel.setText("invalid login please try again");
                }
            }else{
                loginmessagelabel.setText("invalid login please try again");
            }*/

        }else if(type == "Giáo vụ"){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Đăng nhập");
                alert.setContentText("Đăng nhập tài khoản Giáo vụ");
                alert.showAndWait();
                    Stage stage = (Stage) cancelButton.getScene().getWindow();
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("/com/Course/TeacherGUI/GUI_teacher.fxml"));
                    Stage signUpStage = new Stage();
                    signUpStage.setTitle("Quản Lý Học Phần");
                    signUpStage.setScene(new Scene(root, 945, 678));
                    signUpStage.show();


        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Đăng nhập");
            alert.setContentText("Lỗi chọn tài khoản");
            alert.showAndWait();
        }
    }


    public void cancelButtonAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}
