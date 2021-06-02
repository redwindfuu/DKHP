package com.Course.TeacherGUI.ObjectListGUI;

import com.Course.DAO.ObjectDAO;
import com.Course.DAO.TeacherDAO;
import com.Course.Pojo.Object;
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

public class setTTBomon implements Initializable {

    @FXML
    private ImageView iconPage;
    @FXML
    private TextField ID;
    @FXML
    private TextField tenmon;
    @FXML
    private TextField Sotinchi;
    @FXML
    private Button Xacnhan;
    private Object thisObj;


    public void SetObject(Object tc){
        this.thisObj = tc;
        ID.setText(thisObj.getIdOb());
        tenmon.setText(thisObj.getNameOb());
        Sotinchi.setText(String.valueOf(thisObj.getCredit()));
        ID.setEditable(false);
    }

    public void XacnhanOnAction(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn có muốn cập nhật thông tin không ?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK){
            thisObj.setNameOb(tenmon.getText());
            thisObj.setCredit(Integer.parseInt(Sotinchi.getText()));
            ObjectDAO.updateObject(thisObj);
            Stage stage = (Stage) Xacnhan.getScene().getWindow();
            stage.close();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/edit.png");
        Image image = new Image(Avafile.toURI().toString());
        iconPage.setImage(image);
    }





}
