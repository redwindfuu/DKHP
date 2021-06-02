package com.Course.TeacherGUI.ObjectListGUI;

import com.Course.DAO.ObjectDAO;
import com.Course.DAO.TeacherDAO;
import com.Course.Pojo.Object;
import com.Course.Pojo.Teacher;
import com.mysql.cj.util.StringUtils;
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

public class themBomon implements Initializable {
    @FXML
    private ImageView iconPage;
    @FXML
    private TextField ID;
    @FXML
    private TextField tenmon;
    @FXML
    private TextField Sotinchi;



    public void ThemButtonClick(ActionEvent e){
            String str = "";
            if(!ID.getText().trim().isEmpty() && !tenmon.getText().trim().isEmpty() && !Sotinchi.getText().trim().isEmpty()&&
                    Sotinchi.getText().matches("-?\\d+(\\.\\d+)?")){
                if(ObjectDAO.getObject(ID.getText()) == null) {
                    Object newObject = new Object(ID.getText(),tenmon.getText(),Integer.parseInt(Sotinchi.getText()));
                    ObjectDAO.addObject(newObject);
                    Stage stage = (Stage) ID.getScene().getWindow();
                    stage.close();
                    str = " thêm thành công";
                }else{
                    str ="lỗi có mã môn học trùng";
                }
            }else{
                str ="thêm thất bại";
            }

        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Thêm Môn học");
        alert1.setContentText(str);
        alert1.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/add-objects.png");
        Image image = new Image(Avafile.toURI().toString());
        iconPage.setImage(image);
    }
}
