package com.Course.DAO;

import com.Course.HibernateUtil;
import com.Course.Pojo.Coursesession;
import com.Course.Pojo.CoursesessionPK;
import com.Course.Pojo.SemesterPK;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class CoursesessionDAO {
    public static List<Coursesession> getALlCoursesessionList(){
        Session session  = HibernateUtil.getSession();
        List<Coursesession> lst = null;
        try {
            final String hql = "select st from Coursesession st ";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return lst;
    }

    public static boolean isExistsCoursesession(CoursesessionPK idSv){
        Session session  = HibernateUtil.getSession();
        List<Coursesession> lst = null;
        try {
            final String hql = "select  st from Coursesession st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        for (Coursesession n : lst) {
            if(n.getIdCoursesession().equals(idSv)){
                return true;
            }
        }

        return false;
    }

    public static Coursesession getCoursesession(SemesterPK Q, Date ngay){
        Session session = HibernateUtil.getSession();
        Coursesession st = null;
        try{
            String hql ="select st from Coursesession st where st.idCoursesession.idSemester.idSemester.semeId =: Q1 and " +
                    " st.idCoursesession.idSemester.idSemester.yearSeme =: Q2 and st.idCoursesession.timeBeg =: Q3";
            st = (Coursesession) session.createQuery(hql).setString("Q1",Q.getSemeId()).setString("Q2", Q.getYearSeme())
                    .setString("Q3", ngay.toString()).uniqueResult();

        }catch (HibernateException ex){
            System.out.println("loi get Coursesession");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addCoursesession(Coursesession st){
        Session session = HibernateUtil.getSession();
        if(CoursesessionDAO.getCoursesession(st.getIdCoursesession().getIdSemester().getIdSemester(),st.getIdCoursesession().getTimeBeg() )!= null){
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

    public static boolean updateCoursesession(Coursesession st){
        Session session = HibernateUtil.getSession();
        if(CoursesessionDAO.getCoursesession(st.getIdCoursesession().getIdSemester().getIdSemester(),new Date (st.getIdCoursesession().getTimeBeg().getTime()) )== null){
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

    public static boolean deleteCoursesession(SemesterPK Q, java.util.Date ngay){
        Session session = HibernateUtil.getSession();
        Coursesession sv = CoursesessionDAO.getCoursesession(Q,new Date(ngay.getTime()));
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
