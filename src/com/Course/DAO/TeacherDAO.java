package com.Course.DAO;

import com.Course.HibernateUtil;
import com.Course.Pojo.ClaSs;
import com.Course.Pojo.Student;
import com.Course.Pojo.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherDAO {
    public static List<Teacher> getALlTeacherList(){
        Session session  = HibernateUtil.getSession();
        List<Teacher> lst = null;
        try {
            final String hql = "select  st from Teacher st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static boolean isExistsTeacher(String idSv){
        Session session  = HibernateUtil.getSession();
        List<Teacher> lst = null;
        try {
            final String hql = "select  st from Teacher st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        for (Teacher n : lst) {
            if(n.getIdTea().equals(idSv)){
                return true;
            }
        }

        return false;
    }

    public static Teacher getTeacher(String idSv){
        Session session = HibernateUtil.getSession();
        Teacher st = null;
        try{
            String hql ="select st from Teacher st where st.idTea = : ID";
            st = (Teacher) session.createQuery(hql).setString("ID",idSv).uniqueResult();

        }catch (HibernateException ex){
            System.out.println(" loi ");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addTeacher(Teacher st){
        Session session = HibernateUtil.getSession();
        if(TeacherDAO.isExistsTeacher(st.getIdTea())){
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

    public static boolean updateTeacher(Teacher st){
        Session session = HibernateUtil.getSession();
        if(TeacherDAO.getTeacher(st.getIdTea()) == null){
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

    public static boolean deleteTeacher(String idStu){
        Session session = HibernateUtil.getSession();
        Teacher sv = TeacherDAO.getTeacher(idStu);
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
