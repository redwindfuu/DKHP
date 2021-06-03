package com.Course.TeacherGUI;

import com.Course.DAO.*;
import com.Course.Pojo.*;
import com.Course.Pojo.Object;
import com.Course.TeacherGUI.ClassListGUI.ClassList_info;
import com.Course.TeacherGUI.ObjectListGUI.setTTBomon;
import com.Course.TeacherGUI.TeacherListGUI.setTTGV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class GUI_teacher implements Initializable {


    private Teacher User;
    private Semester MainSemester;
// Trang thông tin giáo vụ
    @FXML
    private ImageView TeacherAvatar;
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
    @FXML
    private Label LabelHK;
    @FXML
    private Label LabelNamhoc;


    public void setUsers(Teacher users){
        this.User = users;
        helloWorld.setText("Xin chào, "+User.getNameTea());
        TT_name.setText(User.getNameTea());
        TT_ID.setText(User.getIdTea());
        TT_numberphone.setText(User.getNumberPhone());
        TT_sex.setText(User.getSex());
        TT_Address.setText(User.getAddress());
        TT_Type.setText("Giáo Vụ");
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


// thông tín giáo vụ
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

    //Chỉnh sửa thông tin giản viên
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn có muốn cập nhật thông tin không ?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK){
            User.setNameTea(ReputName.getText().trim());
            User.setAddress(reputAddress.getText().trim());
            User.setNumberPhone(reputNumberPhone.getText().trim());
            User.setBirthday(Date.valueOf(reputBirth.getValue()));
            User.setSex(((RadioButton)ListGender.getSelectedToggle()).getText());
            TeacherDAO.updateTeacher(User);
        }
        setUsers(User);
    }
    // Đổi mật khẩu
    @FXML
    private PasswordField changePass_old;
    @FXML
    private PasswordField changePass_new;
    @FXML
    private PasswordField changePass_reNew;
    @FXML
    private Button buttonRePass;

    public void buttonRePassOnAction(ActionEvent e){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn có muốn cập nhật mật khẩu không ?");
        Optional<ButtonType> option = alert.showAndWait();
        if((option.get() == ButtonType.OK)){
            if(User.isConnectPass(changePass_old.getText())){
                if(changePass_new.getText().equals(changePass_reNew.getText())){
                    User.setPasswordTea(changePass_new.getText());
                    TeacherDAO.updateTeacher(User);
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Đổi Mật Khẩu");
                    alert1.setContentText("Đổi thành công");
                    alert1.showAndWait();
                }else {
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Đổi Mật Khẩu");
                    alert1.setContentText("Đổi thất bại");
                    alert1.showAndWait();
                }
            }else {
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Đổi Mật Khẩu");
                alert2.setContentText("Đổi thất bại");
                alert2.showAndWait();
            }}

    }

// Trang môn học
     @FXML
     private TextField laytimkiemmamon;
    @FXML
    private  TableView<Object> BangMonHoc;
    @FXML
    private TableColumn<Object,String> Mamon_column;
    @FXML
    private TableColumn<Object,String> tenmon_column;
    @FXML
    private TableColumn<Object,Integer> Sotinchi_column;
    @FXML
    private Button timkiemmamon;
    @FXML
    private Button themmon;
    @FXML
    private Button capnhatmon;
    @FXML
    private Button xoamon;
    private ObservableList<Object> ObjectList;

    public void timkiemamonOnAction(ActionEvent e){
        String result = laytimkiemmamon.getText();
        ObservableList<Object> resultList = FXCollections.observableArrayList();
        Object h = ObjectDAO.getObject(result);
        if(h != null){
            resultList.add(h);
        }
        BangMonHoc.setItems(resultList);
        if(result.trim() == ""){
            BangMonHoc.setItems(ObjectList);
        }

    }
    public void themmonOnAction(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/Course/TeacherGUI/ObjectListGUI/themBomon.fxml"));
        Parent root = loader.load();
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Chỉnh Sửa giáo vụ");
        signUpStage.setScene(new Scene(root, 610, 443));
        signUpStage.show();
        signUpStage.setOnHiding( event -> {
            ObjectList = FXCollections.observableArrayList(ObjectDAO.getALlObjectList());
            BangMonHoc.setItems(ObjectList);
        } );
    }
    public void capnhatmonOnAction(ActionEvent e) throws IOException {
        Object result = BangMonHoc.getSelectionModel().getSelectedItem();
        if(result != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/Course/TeacherGUI/ObjectListGUI/setTTBomon.fxml"));
            Parent root = loader.load();
            setTTBomon control = loader.getController();
            control.SetObject(result);
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Chỉnh Sửa giáo vụ");
            signUpStage.setScene(new Scene(root, 610, 443));
            signUpStage.show();
            signUpStage.setOnHiding( event -> {
                ObjectList = FXCollections.observableArrayList(ObjectDAO.getALlObjectList());
                BangMonHoc.setItems(ObjectList);
            } );
        }
    }
    public void xoamonOnAction(ActionEvent e){
        String str ="";
        Object result = BangMonHoc.getSelectionModel().getSelectedItem();
        if(result != null){
            ObjectDAO.deleteObject(result.getIdOb());
            str ="Xóa thành công";
        }else {
            str ="Xóa thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Xóa Môn học");
        alert1.setContentText(str);
        alert1.showAndWait();
        ObjectList = FXCollections.observableArrayList(ObjectDAO.getALlObjectList());
        BangMonHoc.setItems(ObjectList);
    }
    @FXML
    private void tabMonhoc(Event event) {
        ObjectList = FXCollections.observableArrayList(ObjectDAO.getALlObjectList());
        BangMonHoc.setItems(ObjectList);
    }

// Trang Đăng kí Học Phần


// Trang học kì
    @FXML
    private Label M_LabelHocKi;
    @FXML
    private Label M_LabelNamhoc;
    @FXML
    private Label M_LabelNgayBD;
    @FXML
    private Label M_LabelNgayKT;
    private ObservableList<String> lstHK =  FXCollections.observableArrayList("HK1","HK2","Hk3");
    @FXML
    private ChoiceBox<String> inputHK;
    @FXML
    private TextField inputNamhoc;
    @FXML
    private DatePicker NgayBDHK;
    @FXML
    private DatePicker NgayKTHK;
    @FXML
    private Label TTLabelHK;
    @FXML
    private Label TTLabelNamhoc;
    @FXML
    private Label TTLabel_NgayBD;
    @FXML
    private Label TTLabel_NgayKT;
    @FXML
    private ChoiceBox<Semester> inputSearchSeme;
    @FXML
    private Button SearchSeButton;
    @FXML
    private Button TaoHK;
    @FXML
    private Button SetMainHK;
    @FXML
    private Button DeleteHK;
    private ObservableList<Semester> SemesterList ;










    @FXML
    private void tabHocki(Event event) {
        inputHK.setItems(lstHK);
        inputHK.setValue("HK1");
        SemesterList = FXCollections.observableArrayList(SemesterDAO.getALlSemesterList());
        MainSemester = SemesterDAO.getMainSemester();
        M_LabelHocKi.setText(MainSemester.getIdSemester().getSemeId());
        M_LabelNamhoc.setText(MainSemester.getIdSemester().getYearSeme());
        M_LabelNgayBD.setText(MainSemester.getDaybeg().toString());
        M_LabelNgayKT.setText(MainSemester.getDayfinal().toString());
        TTLabelHK.setText(MainSemester.getIdSemester().getSemeId());
        TTLabelNamhoc.setText(MainSemester.getIdSemester().getYearSeme());
        TTLabel_NgayBD.setText(MainSemester.getDaybeg().toString());
        TTLabel_NgayKT.setText(MainSemester.getDayfinal().toString());
        inputSearchSeme.setItems(SemesterList);
        inputSearchSeme.setValue(MainSemester);

    }
    @FXML
    private void SearchSeButtononAction(ActionEvent actionEvent) {
        Semester result =inputSearchSeme.getValue();
        TTLabelHK.setText(result.getIdSemester().getSemeId());
        TTLabelNamhoc.setText(result.getIdSemester().getYearSeme());
        TTLabel_NgayBD.setText(result.getDaybeg().toString());
        TTLabel_NgayKT.setText(result.getDayfinal().toString());
    }

    @FXML
    private void SetMainHKonAction(ActionEvent actionEvent) {
        Semester result =inputSearchSeme.getValue();
        SemesterDAO.setMainSemester(result);
        MainSemester = SemesterDAO.getMainSemester();
        M_LabelHocKi.setText(MainSemester.getIdSemester().getSemeId());
        M_LabelNamhoc.setText(MainSemester.getIdSemester().getYearSeme());
        M_LabelNgayBD.setText(MainSemester.getDaybeg().toString());
        M_LabelNgayKT.setText(MainSemester.getDayfinal().toString());
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Học kì");
        alert1.setContentText("đặt học kì chính thành công");
        alert1.showAndWait();
    }

    @FXML
    private void DeleteHKonAction(ActionEvent actionEvent) {
        Semester result =inputSearchSeme.getValue();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn có muốn xóa học kì không ?, nó sẽ xóa toàn bộ học phần , kì đăng kí học phần liên quan");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK){
            SemesterDAO.deleteSemester(result.getIdSemester().getYearSeme(),result.getIdSemester().getSemeId());
        }
        SemesterList = FXCollections.observableArrayList(SemesterDAO.getALlSemesterList());
        inputSearchSeme.setItems(SemesterList);
        inputSearchSeme.setValue(MainSemester);
    }

    @FXML
    private void TaoHKonAction(ActionEvent actionEvent) {
        String str ="";
        if(!inputNamhoc.getText().isEmpty() && inputNamhoc.getText().length() == 9 &&NgayBDHK != null && NgayKTHK!= null){
            SemesterPK keySemester = new SemesterPK(inputHK.getValue(),inputNamhoc.getText());
            Semester h = SemesterDAO.getSemester(inputNamhoc.getText(),inputHK.getValue());
            if(h == null) {
                Semester newSemester = new Semester(keySemester, Date.valueOf(NgayBDHK.getValue()), Date.valueOf(NgayKTHK.getValue()));
                SemesterDAO.addSemester(newSemester);
                str = "tạo học kì thành công";
            }else
            str = "đã có học kì này rồi" ;
        }else{
            str = "Nhập lỗi (Năm học 9 kí tự)" ;
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Học kì");
        alert1.setContentText(str);
        alert1.showAndWait();
        SemesterList = FXCollections.observableArrayList(SemesterDAO.getALlSemesterList());
        inputSearchSeme.setItems(SemesterList);
        inputSearchSeme.setValue(MainSemester);
    }


// Tài Khoản giáo viên
    @FXML
    private TextField layIDtimkiemgiaovien;
    @FXML
    private Button timkiemgiaovien;
    @FXML
    private Button resetmkgv;
    @FXML
    private Button themgv;
    @FXML
    private Button capnhatgv;
    @FXML
    private Button xoagv;
    @FXML
    private TableView<Teacher>  BangGV;
    @FXML
    private TableColumn<Teacher,String> IDGV_column;
    @FXML
    private TableColumn<Teacher,String> HotenGV_column;
    @FXML
    private TableColumn<Teacher,String> GioitinhGV_column;
    @FXML
    private TableColumn<Teacher,Date> NgaysinhGV_column;
    @FXML
    private TableColumn<Teacher,String> SDTGV_coulumn;
    @FXML
    private TableColumn<Teacher,String> DiachiGV_column;
    private ObservableList<Teacher> teachersList;

    public void TimKiemGVButton(ActionEvent e){
        String result = layIDtimkiemgiaovien.getText();
        ObservableList<Teacher> resultList = FXCollections.observableArrayList();
        Teacher h = TeacherDAO.getTeacher(result);
        if(h != null){
            resultList.add(h);
        }
        BangGV.setItems(resultList);
        if(result.trim() == ""){
            BangGV.setItems(teachersList);
        }
    }
    public void ResetGVButton(ActionEvent e){
        String str =null;
        Teacher result = BangGV.getSelectionModel().getSelectedItem();
        if(result != null){
            result.setPasswordTea(result.getIdTea());
            TeacherDAO.updateTeacher(result);
            str ="Reset thành công";
        }else {
            str ="Reset thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Reset mật khẩu khoản giáo vụ");
        alert1.setContentText(str);
        alert1.showAndWait();
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        BangGV.setItems(teachersList);
    }
    public void ThemGVButton(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/Course/TeacherGUI/TeacherListGUI/themGV.fxml"));
        Parent root = loader.load();
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Chỉnh Sửa giáo vụ");
        signUpStage.setScene(new Scene(root, 609, 570));
        signUpStage.show();
        signUpStage.setOnHiding( event -> {
            teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
            BangGV.setItems(teachersList);
        } );
    }
    public void CapNhatGVButton(ActionEvent e) throws IOException {
        Teacher result = BangGV.getSelectionModel().getSelectedItem();
        if(result != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/Course/TeacherGUI/TeacherListGUI/setTTGV.fxml"));
            Parent root = loader.load();
            setTTGV control = loader.getController();
            control.SetTeacher(result);
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Chỉnh Sửa giáo vụ");
            signUpStage.setScene(new Scene(root, 609, 570));
            signUpStage.show();
            signUpStage.setOnHiding( event -> {
                teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
                BangGV.setItems(teachersList);
                setUsers(TeacherDAO.getTeacher(User.getIdTea()));
            } );
        }
    }
    public void XoaGVButton(ActionEvent e){
        String str ="";
        Teacher result = BangGV.getSelectionModel().getSelectedItem();
        if(result != null){
            TeacherDAO.deleteTeacher(result.getIdTea());
            str ="Xóa thành công";
        }else {
            str ="Xóa thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Xóa tài khoản giáo vụ");
        alert1.setContentText(str);
        alert1.showAndWait();
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        BangGV.setItems(teachersList);
    }
    @FXML
    private void tabGiaovu(Event event) {
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        BangGV.setItems(teachersList);
    }
//Trang lớp học
    @FXML
    private TextField laytimkiemlop;
    @FXML
    private TableView<ClassList_info> BangLophoc;
    @FXML
    private TableColumn<ClassList_info,String> STTLop_column;
    @FXML
    private TableColumn<ClassList_info,String> tenlop_column;
    @FXML
    private TableColumn<ClassList_info,Integer> Sosinhvien_column;
    @FXML
    private TableColumn<ClassList_info,Integer> Sosinhviennam_column;
    @FXML
    private TableColumn<ClassList_info,Integer> Sosinhviennu_column;
    @FXML
    private TextField InputNameClass;
    private ObservableList<ClaSs> ClassList ;
    @FXML
    private TextField InputIDSV_Class;
    public ObservableList<ClassList_info> getListClass()
    {
        ClassList = FXCollections.observableArrayList(ClaSsDAO.getALlCLassList());
        ObservableList<ClassList_info> f = FXCollections.observableArrayList();
        for (ClaSs i : ClassList){
            f.add(new ClassList_info(i));
        }
        return f;
    }
    @FXML
    private void tabLophoc(Event event) {

        STTLop_column.setCellValueFactory(new PropertyValueFactory<ClassList_info,String>("idClass"));
        tenlop_column.setCellValueFactory(new PropertyValueFactory<ClassList_info,String>("nameClass"));
        Sosinhvien_column.setCellValueFactory(new PropertyValueFactory<ClassList_info,Integer>("TongSV"));
        Sosinhviennam_column.setCellValueFactory(new PropertyValueFactory<ClassList_info,Integer>("SVnam"));
        Sosinhviennu_column.setCellValueFactory(new PropertyValueFactory<ClassList_info,Integer>("SVnu"));
        ObservableList<ClassList_info> lst = getListClass();
        BangLophoc.setItems(lst);
    }
    @FXML
    private void addSVvaolop(ActionEvent actionEvent) {
        ClassList_info tmp = BangLophoc.getSelectionModel().getSelectedItem();
        String idStu =  InputIDSV_Class.getText();
        if(tmp != null && !idStu.isEmpty()){
            Student student = StudentDAO.getStudent(idStu);
            if(student != null){
            ClaSs h = tmp.getThisClass();
            student.setIdClass(h);
            StudentDAO.updateStudent(student);
            }
        }
        BangLophoc.setItems(getListClass());
    }
    @FXML
    private void xoalophocClick(ActionEvent actionEvent) {
        ClassList_info tmp = BangLophoc.getSelectionModel().getSelectedItem();
        String str ="";
        if(tmp != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận");
            alert.setContentText("Bạn có muốn xóa Lớp học này không");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == ButtonType.OK) {
                ClaSs cls = tmp.getThisClass();
                ClaSsDAO.deleteClaSs(cls.getNameClass());
                str =" thêm sinh viên vào lớp "+cls.getNameClass()+" thành công";
            }else{
                str =" thêm sinh viên vào lớp thất bại";
            }
        }else {
            str =" thêm sinh viên vào lớp thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Thêm lớp học");
        alert1.setContentText(str);
        alert1.showAndWait();
        BangLophoc.setItems(getListClass());
    }
    @FXML
    private void ThemlophocClick(ActionEvent actionEvent) {
        String result = InputNameClass.getText();
        String msg ="";
        if(ClaSsDAO.getClaSs(result) == null){
            ClaSs newClss = new ClaSs(result);
            ClaSsDAO.addClaSs(newClss);
            msg = "thêm thành công ";
        }else{
            msg =" thêm thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Thêm lớp học");
        alert1.setContentText(msg);
        alert1.showAndWait();
        BangLophoc.setItems(getListClass());
    }
    @FXML
    private void timkiemlopClick(ActionEvent actionEvent) {
        String result = laytimkiemlop.getText();
        ObservableList<ClassList_info> lst = getListClass();
        ObservableList<ClassList_info> rulstlst = FXCollections.observableArrayList();
        if(!result.trim().isEmpty()){
            for (ClassList_info i: lst) {
                if(i.getNameClass().equals(result)){
                    rulstlst.add(i);
                    break;
                }

            }
            BangLophoc.setItems(rulstlst);
        }else{
            BangLophoc.setItems(lst);
        }
    }
//Trang sinh viên
@FXML
    private TextField layIDtimkiemsv;
    @FXML
    private Button timkiemsv;
    @FXML
    private Button resetmksv;
    @FXML
    private Button themsv;
    @FXML
    private Button capnhatsv;
    @FXML
    private Button xoasv;
    @FXML
    private TableView<Student>  BangSV;
    @FXML
    private TableColumn<Student,String> IDSV_column;
    @FXML
    private TableColumn<Student,String> HotenSV_column;
    @FXML
    private TableColumn<Student,String> GioitinhSV_column;
    @FXML
    private TableColumn<Student,Date> NgaysinhSV_column;
    @FXML
    private TableColumn<Student,String> SDTSV_coulumn;
    @FXML
    private TableColumn<Student,String> DiachiSV_column;
    private ObservableList<Student> studentList;

    @FXML
    private void seenHocphanOnAcion(ActionEvent actionEvent) {

    }
    public void TimKiemSVButton(ActionEvent e){
        String result = layIDtimkiemgiaovien.getText();
        ObservableList<Teacher> resultList = FXCollections.observableArrayList();
        Teacher h = TeacherDAO.getTeacher(result);
        if(h != null){
            resultList.add(h);
        }
        BangGV.setItems(resultList);
        if(result.trim() == ""){
            BangGV.setItems(teachersList);
        }
    }
    public void ResetSVButton(ActionEvent e){
        String str =null;
        Teacher result = BangGV.getSelectionModel().getSelectedItem();
        if(result != null){
            result.setPasswordTea(result.getIdTea());
            TeacherDAO.updateTeacher(result);
            str ="Reset thành công";
        }else {
            str ="Reset thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Reset mật khẩu khoản giáo vụ");
        alert1.setContentText(str);
        alert1.showAndWait();
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        BangGV.setItems(teachersList);
    }
    public void ThemSVButton(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/Course/TeacherGUI/TeacherListGUI/themGV.fxml"));
        Parent root = loader.load();
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Chỉnh Sửa giáo vụ");
        signUpStage.setScene(new Scene(root, 609, 570));
        signUpStage.show();
        signUpStage.setOnHiding( event -> {
            teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
            BangGV.setItems(teachersList);
        } );
    }
    public void CapNhatSVButton(ActionEvent e) throws IOException {
        Teacher result = BangGV.getSelectionModel().getSelectedItem();
        if(result != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/Course/TeacherGUI/TeacherListGUI/setTTGV.fxml"));
            Parent root = loader.load();
            setTTGV control = loader.getController();
            control.SetTeacher(result);
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Chỉnh Sửa giáo vụ");
            signUpStage.setScene(new Scene(root, 609, 570));
            signUpStage.show();
            signUpStage.setOnHiding( event -> {
                teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
                BangGV.setItems(teachersList);
                setUsers(TeacherDAO.getTeacher(User.getIdTea()));
            } );
        }
    }
    public void XoaSVButton(ActionEvent e){
        String str ="";
        Teacher result = BangGV.getSelectionModel().getSelectedItem();
        if(result != null){
            TeacherDAO.deleteTeacher(result.getIdTea());
            str ="Xóa thành công";
        }else {
            str ="Xóa thất bại";
        }
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Xóa tài khoản giáo vụ");
        alert1.setContentText(str);
        alert1.showAndWait();
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        BangGV.setItems(teachersList);
    }
    @FXML
    private void tabSinhvien(Event event) {
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        BangGV.setItems(teachersList);
    }



























//

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/professor.png");
        Image image = new Image(Avafile.toURI().toString());
        TeacherAvatar.setImage(image);
        MainSemester = SemesterDAO.getMainSemester();
        LabelHK.setText(MainSemester.getIdSemester().getSemeId());
        LabelNamhoc.setText(MainSemester.getIdSemester().getYearSeme());
        //Bảng giáo viên
        teachersList = FXCollections.observableArrayList(TeacherDAO.getALlTeacherList());
        IDGV_column.setCellValueFactory(new PropertyValueFactory<Teacher,String>("idTea"));
        HotenGV_column.setCellValueFactory(new PropertyValueFactory<Teacher,String>("nameTea"));
        GioitinhGV_column.setCellValueFactory(new PropertyValueFactory<Teacher,String>("sex"));
        NgaysinhGV_column.setCellValueFactory(new PropertyValueFactory<Teacher,Date>("birthday"));
        SDTGV_coulumn.setCellValueFactory(new PropertyValueFactory<Teacher,String>("numberPhone"));
        DiachiGV_column.setCellValueFactory(new PropertyValueFactory<Teacher,String>("address"));
        BangGV.setItems(teachersList);
        //Bảng Môn học
        ObjectList = FXCollections.observableArrayList(ObjectDAO.getALlObjectList());
        Mamon_column.setCellValueFactory(new PropertyValueFactory<Object,String>("idOb"));
        tenmon_column.setCellValueFactory(new PropertyValueFactory<Object,String>("nameOb"));
        Sotinchi_column.setCellValueFactory(new PropertyValueFactory<Object,Integer>("credit"));
        BangMonHoc.setItems(ObjectList);
        //



















    }



}
