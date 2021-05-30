package com.Course.LoginAndSignup;

import com.Course.DAO.StudentDAO;
import com.Course.DAO.TeacherDAO;
import com.Course.Pojo.Student;
import com.Course.Pojo.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GUI_Signup implements Initializable{
    private ObservableList<String> AccounttypeList = FXCollections.observableArrayList("Giáo vụ", "Sinh viên");
    @FXML
    private TextField varName;// lấy tên
    @FXML
    private TextField Address;// lấy địa chỉ
    @FXML
    private TextField NumberPhone;// lấy điện thoại
    @FXML
    private PasswordField varPassword;//lấy mật khẩu
    @FXML
    private PasswordField varRePassword;//nhập lại mật khẩu
    @FXML
    private TextField varID;//lấy ID
    @FXML
    private DatePicker DateOfBirth; // lấy ngày sinh
    @FXML
    private Button registerButton;
    @FXML
    private Label MessageInput;
    @FXML
    private ChoiceBox TypeAcc;
    @FXML
    private ToggleGroup ListGender;
    @FXML
    private RadioButton Male;
    @FXML
    private RadioButton Female;
    private String Gender = "Nam";
    public void getMale(ActionEvent e) {
        Gender = Male.getText();
       // System.out.print(Gender);
    }
    public void getFemale(ActionEvent e) {
        Gender = Female.getText();
     //   System.out.print(Gender);
    }

    public void registerButtonOnAction(ActionEvent a){
        MessageInput.setText("");
        LocalDate date = DateOfBirth.getValue();
        java.sql.Date DoB = Date.valueOf(date);
        if(!varName.getText().trim().isEmpty() && !Address.getText().trim().isEmpty()
                && !NumberPhone.getText().trim().isEmpty()&& (NumberPhone.getText().length()<=10)
                && !varID.getText().trim().isEmpty() &&
                !varPassword.getText().trim().isEmpty() && !varRePassword.getText().trim().isEmpty()
                && date != null){
                if(TypeAcc.getValue().equals("Sinh viên")) {
                    if (StudentDAO.getStudent(varID.getText()) == null) {
                        if (varPassword.getText().equals(varRePassword.getText())) {
                            Student newstudent = new Student(varPassword.getText(), varID.getText(), varName.getText(), Gender, DoB, NumberPhone.getText(), Address.getText(), null);
                            StudentDAO.addStudent(newstudent);
                            System.out.println("tao sinh vien");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Đăng kí");
                            alert.setContentText("tạo thành công");
                            alert.showAndWait();
                            Stage stage = (Stage) registerButton.getScene().getWindow();
                            stage.close();
                        } else {
                            MessageInput.setText("password is incorrect");
                        }
                    } else {
                        MessageInput.setText("ID is incorrect");
                    }
                }else if(TypeAcc.getValue().equals("Giáo vụ")){
                    if (TeacherDAO.getTeacher(varID.getText()) == null) {
                        if (varPassword.getText().equals(varRePassword.getText())) {
                            Teacher newteacher = new Teacher(varPassword.getText(), varID.getText(), varName.getText(), Gender, DoB, NumberPhone.getText(), Address.getText());
                            TeacherDAO.addTeacher(newteacher);
                            System.out.println("tao giao vu");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Đăng kí");
                            alert.setContentText("tạo thành công");
                            alert.showAndWait();
                            Stage stage = (Stage) registerButton.getScene().getWindow();
                            stage.close();
                        } else {
                            MessageInput.setText("password is incorrect");
                        }
                    } else {
                        MessageInput.setText("ID is incorrect");
                    }
                }



        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Đăng kí");
            alert.setContentText("thông tin không đủ nhập lại");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TypeAcc.setValue("Sinh viên");
        TypeAcc.setItems(AccounttypeList);

    }





}
