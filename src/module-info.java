module DKHP {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.sql;
    requires mysql.connector.java;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.xml.bind;
    requires java.naming;
    requires net.bytebuddy;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires org.jboss.logging;
    requires org.hibernate.commons.annotations;
    opens com.Course.Xml;
    opens com.Course.DAO;
    opens com.Course.Pojo;
    opens com.Course;
    opens com.Course.LoginAndSignup;
    opens com.Course.StudentGUI;
    opens com.Course.TeacherGUI;
}