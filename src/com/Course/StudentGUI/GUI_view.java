package com.Course.StudentGUI;

import com.Course.DAO.CourseDAO;
import com.Course.Pojo.Course;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI_view implements Initializable {


    private viewCourse choice;

    @FXML
    private Label Mamon;
    @FXML
    private Label tenMon;
    @FXML
    private Label Tengv;
    @FXML
    private Label sotinchi;
    @FXML
    private Label Slot;
    @FXML
    private Label giohoc;
    @FXML
    private ImageView sachlabel;

    public void setChoice(viewCourse ct){
        this.choice = ct;
        Course st = ct.getHocphan();
        Course monhoc =CourseDAO.getCourse(st.getIdCourse().getIdOb().getIdOb(),
                st.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester(),st.getIdCourse().getIdCoursesession().getIdCoursesession().getTimeBeg(),
                st.getIdCourse().getRoom(),st.getIdCourse().getDaystudy(),st.getIdCourse().getTimestudy());
        Mamon.setText(monhoc.getIdCourse().getIdOb().getIdOb());
        tenMon.setText(monhoc.getIdCourse().getIdOb().getNameOb());
        Tengv.setText(monhoc.getNameteacher());
        sotinchi.setText(String.valueOf(monhoc.getIdCourse().getIdOb().getCredit()));
        Slot.setText(String.valueOf(monhoc.getStudents().size())+" / "+String.valueOf(monhoc.getSlot()));
        giohoc.setText(ct.getPhong()+"  ,"+ct.getNgayhoc()+"  ,"+ct.getCa());
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File Avafile =new File("img/book.png");
        Image image = new Image(Avafile.toURI().toString());
        sachlabel.setImage(image);
    }
}
