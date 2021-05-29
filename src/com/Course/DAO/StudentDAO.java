package com.Course.DAO;

import com.Course.HibernateUtil;
import com.Course.Pojo.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    public static List<Student> getALlStudentList(){
        Session session  = HibernateUtil.getSession();
        List<Student> lst = null;
        try {
            final String hql = "select  st from Student st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static boolean isExistsStudent(String idSv){
        Session session  = HibernateUtil.getSession();
        List<Student> lst = null;
        try {
            final String hql = "select  st from Student st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        for (Student n : lst) {
            if(n.getIdStu().equals(idSv)){
                return true;
            }
        }

        return false;
    }

    public static Student getStudent(String idSv){
        Session session = HibernateUtil.getSession();
        Student st = null;
        try{
            String hql ="select st from Student st where st.idStu = : ID";
            st = (Student) session.createQuery(hql).setString("ID",idSv).uniqueResult();

        }catch (HibernateException ex){
            System.out.println(" loi ");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addStudent(Student st){
        Session session = HibernateUtil.getSession();
        if(StudentDAO.isExistsStudent(st.getIdStu())){
            return false;
        }
        Transaction transaction = null;
        try{
            transaction =session.beginTransaction();
            session.saveOrUpdate(st);
            transaction.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }

    public static boolean updateStudent(Student st){
        Session session = HibernateUtil.getSession();
        if(StudentDAO.getStudent(st.getIdStu()) == null){
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

    public static boolean deleteStudent(String idStu){
        Session session = HibernateUtil.getSession();
        Student sv = StudentDAO.getStudent(idStu);
        if(sv  == null){
            return false;
        }
        sv.setIdClass(null);
        StudentDAO.updateStudent(sv);
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
