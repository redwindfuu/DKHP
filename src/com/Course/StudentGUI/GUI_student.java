package com.Course.StudentGUI;

import com.Course.DAO.CourseDAO;
import com.Course.DAO.SemesterDAO;
import com.Course.DAO.StudentDAO;
import com.Course.Pojo.Course;
import com.Course.Pojo.Semester;
import com.Course.Pojo.Student;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Semester MainSemester;
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
        this.User = StudentDAO.getStudent(users.getIdStu());
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
    private Label labelSeme;
    @FXML
    private Label schoolyear;
    @FXML
    private TableView<viewCourse> Userhocphan;
    @FXML
    private TableView<viewCourse> hocphanmo;
    @FXML
    private TableColumn<viewCourse,String> Mamon;
    @FXML
    private TableColumn<viewCourse,String> TenGV;
    @FXML
    private TableColumn<viewCourse,String> Hocki;
    @FXML
    private TableColumn<viewCourse,String> Namhoc;
    @FXML
    private TableColumn<viewCourse,Date> Thoigianmo;
    @FXML
    private TableColumn<viewCourse,Date> Thoigaindong;
    @FXML
    private TableColumn<viewCourse,String> Phong;
    @FXML
    private TableColumn<viewCourse,String> Ngayhoc;
    @FXML
    private TableColumn<viewCourse,String> Cahoc;
    @FXML
    private TableColumn<viewCourse,Integer> Slot;
    @FXML
    private TableColumn<viewCourse,CheckBox> huymon;
    @FXML
    private TableColumn<viewCourse,String> Mamon1;
    @FXML
    private TableColumn<viewCourse,String> TenGV1;
    @FXML
    private TableColumn<viewCourse,String> Hocki1;
    @FXML
    private TableColumn<viewCourse,String> Namhoc1;
    @FXML
    private TableColumn<viewCourse,Date> Thoigianmo1;
    @FXML
    private TableColumn<viewCourse,Date> Thoigaindong1;
    @FXML
    private TableColumn<viewCourse,String> Phong1;
    @FXML
    private TableColumn<viewCourse,String> Ngayhoc1;
    @FXML
    private TableColumn<viewCourse,String> Cahoc1;
    @FXML
    private TableColumn<viewCourse,Integer> Slot1;
    @FXML
    private TableColumn<viewCourse,CheckBox> chonmon;
    @FXML
    private Button buttonrefesh;
    @FXML
    private Button capnhat;
    private final ObservableList<viewCourse> forCourseList = FXCollections.observableArrayList();
    private final ObservableList<viewCourse> forStudentList = FXCollections.observableArrayList();
    public void ChangeDKHP(ActionEvent e) {
        forStudentList.clear();
        forCourseList.clear();
        for (Course h: User.getCourses()) {
            System.out.println(h.toString());
            forStudentList.add(new viewCourse(h));
        }

        for (Course h: CourseDAO.getALlCourseList()) {
            if(!User.getCourses().contains(h))
                forCourseList.add(new viewCourse(h));
        }

        hocphanmo.setItems(forCourseList);
        Userhocphan.setItems(forStudentList);

    }


    public void capnhaOnAction(ActionEvent e){
        for (viewCourse h: forStudentList) {
            if(h.getSelecte().isSelected()){
                User.getCourses().remove(h);
                StudentDAO.updateStudent(User);
            }
        }
        for (viewCourse h: forCourseList) {
            if(h.getSelecte().isSelected()){
                if(User.getCourses().size() + 1 <8){
                User.getCourses().add(h.getHocphan());
                StudentDAO.updateStudent(User);
                }else{
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Chỉnh sửa");
                    alert.setContentText("Chỉnh sửa học phần thất bại");
                    alert.showAndWait();
                    break;
                }
            }
        }
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Chỉnh sửa");
        alert.setContentText("Nhấn nút Làm mới xem kết quả");
        alert.showAndWait();


    }



















    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/graduate-user-icon.png");
        Image image = new Image(Avafile.toURI().toString());
        StudentAvatar.setImage(image);
        MainSemester = SemesterDAO.getMainSemester();
        labelSeme.setText(MainSemester.getIdSemester().getSemeId());
        schoolyear.setText(MainSemester.getIdSemester().getYearSeme());

        //set table
        Mamon.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("mamon"));
        TenGV.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Giaovien"));
        Hocki.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("hocki"));
        Namhoc.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Namhoc"));
        Thoigianmo.setCellValueFactory(new PropertyValueFactory<viewCourse,Date>("Thoigianmo"));
        Thoigaindong.setCellValueFactory(new PropertyValueFactory<viewCourse,Date>("Thoigiandong"));
        Phong.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("phong"));
        Ngayhoc.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Ngayhoc"));
        Cahoc.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Ca"));
        Slot.setCellValueFactory(new PropertyValueFactory<viewCourse,Integer>("Slot"));
        huymon.setCellValueFactory(new PropertyValueFactory<viewCourse,CheckBox>("selecte"));
        //
        Mamon1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("mamon"));
        TenGV1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Giaovien"));
        Hocki1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("hocki"));
        Namhoc1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Namhoc"));
        Thoigianmo1.setCellValueFactory(new PropertyValueFactory<viewCourse,Date>("Thoigianmo"));
        Thoigaindong1.setCellValueFactory(new PropertyValueFactory<viewCourse,Date>("Thoigiandong"));
        Phong1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("phong"));
        Ngayhoc1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Ngayhoc"));
        Cahoc1.setCellValueFactory(new PropertyValueFactory<viewCourse,String>("Ca"));
        Slot1.setCellValueFactory(new PropertyValueFactory<viewCourse,Integer>("Slot"));
        chonmon.setCellValueFactory(new PropertyValueFactory<viewCourse,CheckBox>("selecte"));


    }






}
