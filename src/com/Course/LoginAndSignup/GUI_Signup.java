package com.Course.LoginAndSignup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GUI_Signup implements Initializable{
    private ObservableList<String> AccounttypeList = FXCollections.observableArrayList("Giáo vụ", "Sinh viên");
    @FXML
    private TextField varName;
    @FXML
    private TextField Address;
    @FXML
    private TextField NumberPhone;
    @FXML
    private PasswordField varPassword;
    @FXML
    private PasswordField varRePassword;
    @FXML
    private TextField varID;
    @FXML
    private DatePicker DateOfBirth;
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
        System.out.print(Gender);
    }
    public void getFemale(ActionEvent e) {
        Gender = Female.getText();
        System.out.print(Gender);
    }

    public void registerButtonOnAction(ActionEvent a){
        MessageInput.setText("");
        LocalDate date = DateOfBirth.getValue();
        if(!varName.getText().trim().isEmpty() && !Address.getText().trim().isEmpty()
                && !NumberPhone.getText().trim().isEmpty() && !varID.getText().trim().isEmpty() &&
                !varPassword.getText().trim().isEmpty() && !varRePassword.getText().trim().isEmpty()
                && date != null){
                    //if(varID)
                    if(varPassword.getText().equals(varRePassword.getText())){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Đăng kí");
                        alert.setContentText("tạo thành công");
                        alert.showAndWait();



                        Stage stage = (Stage) registerButton.getScene().getWindow();
                        stage.close();
                    }else{
                        MessageInput.setText("password is incorrect");
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
