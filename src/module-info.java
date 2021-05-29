module DKHP {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.sql;
    opens com.Course;
    opens com.Course.LoginAndSignup;
    opens com.Course.StudentGUI;
    opens com.Course.TeacherGUI;
}