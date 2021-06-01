package com.Course.DAO;

import com.Course.HibernateUtil;
import com.Course.Pojo.Course;
import com.Course.Pojo.CoursePK;
import com.Course.Pojo.SemesterPK;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class CourseDAO {
    public static List<Course> getALlCourseList(){
        Session session  = HibernateUtil.getSession();
        List<Course> lst = null;
        try {
            final String hql = "select st from Course st ";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return lst;
    }

    public static boolean isExistsCourse(CoursePK idSv){
        Session session  = HibernateUtil.getSession();
        List<Course> lst = null;
        try {
            final String hql = "select  st from Course st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        for (Course n : lst) {
            if(n.getIdCourse().equals(idSv)){
                return true;
            }
        }

        return false;
    }

    public static Course getCourse(String Q1, SemesterPK Q2, Date Q3, String room , byte day, byte time){
        Session session = HibernateUtil.getSession();
        Course st = null;
        try{
            String hql ="select st from Course st " +
                    "    where st.idCourse.idOb.idOb =:Q1 and " +
                    "st.idCourse.idCoursesession.idCoursesession.idSemester.idSemester.semeId =: Q2 " +
                    "and st.idCourse.idCoursesession.idCoursesession.idSemester.idSemester.yearSeme =: Q2_1 " +
                    "and st.idCourse.idCoursesession.idCoursesession.timeBeg = : Q2_3 " +
                    "and st.idCourse.room =: room " +
                    "and st.idCourse.daystudy =: day " +
                    "and st.idCourse.timestudy =: time";
            st = (Course) session.createQuery(hql).setString("Q1",Q1)
                    .setString("Q2", Q2.getSemeId())
                    .setString("Q2_1", Q2.getYearSeme())
                    .setString("Q2_3",Q3.toString())
                    .setString("room",room)
                    .setString("day",String.valueOf(day))
                    .setString("time",String.valueOf(time)).uniqueResult();

        }catch (HibernateException ex){
            System.out.println("loi get Course");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addCourse(Course st){
        Session session = HibernateUtil.getSession();
        if(CourseDAO.isExistsCourse(st.getIdCourse())){
            return false;
        }
        Transaction transaction = null;
        try{
            transaction =session.beginTransaction();
            session.save(st);
            transaction.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }

    public static boolean updateCourse(Course st){
        Session session = HibernateUtil.getSession();
        if(CourseDAO.getCourse(st.getIdCourse().getIdOb().getIdOb(),
                st.getIdCourse().getIdCoursesession().getIdCoursesession().getIdSemester().getIdSemester(),st.getIdCourse().getIdCoursesession().getIdCoursesession().getTimeBeg(),
                st.getIdCourse().getRoom(),st.getIdCourse().getDaystudy(),st.getIdCourse().getTimestudy()) == null){
            return false;
        }
        Transaction transaction = null;
        try{
            transaction =session.beginTransaction();
            session.update(st);
            transaction.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }

    public static boolean deleteCourse(String Q1, SemesterPK Q2, Date ngaybd , String room , byte day, byte time){
        Session session = HibernateUtil.getSession();
        Course sv = CourseDAO.getCourse(Q1, Q2,ngaybd, room, day, time);
        if(sv  == null){
            return false;
        }
        Transaction transaction = null;
        try{
            transaction =session.beginTransaction();
            session.delete(sv);
            transaction.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }
}
