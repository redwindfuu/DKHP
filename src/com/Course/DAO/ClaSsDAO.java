package com.Course.DAO;

import com.Course.HibernateUtil;
import com.Course.Pojo.ClaSs;
import com.Course.Pojo.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClaSsDAO {
    public static List<ClaSs> getALlCLassList(){
        Session session  = HibernateUtil.getSession();
        List<ClaSs> lst = null;
        try {
            final String hql = "select  st from ClaSs st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return lst;
    }



    public static ClaSs getClaSs(String idSv){
        Session session = HibernateUtil.getSession();
        ClaSs st = null;
        try{
            String hql ="select st from ClaSs st left join fetch st.students where st.nameClass = : ID";
            st = (ClaSs) session.createQuery(hql).setString("ID",idSv).uniqueResult();

        }catch (HibernateException ex){
            System.out.println(" loi ");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addClaSs(ClaSs st){
        Session session = HibernateUtil.getSession();
        if(ClaSsDAO.getClaSs(st.getNameClass()) != null){
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

    public static boolean updateClaSs(ClaSs st){
        Session session = HibernateUtil.getSession();
        if(ClaSsDAO.getClaSs(st.getNameClass()) == null){
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

    public static boolean deleteClaSs(String idStu){
        Session session = HibernateUtil.getSession();
        ClaSs sv = ClaSsDAO.getClaSs(idStu);
        if(sv  == null){
            return false;
        }
        for (Student h :  sv.getStudents()) {
            h.setIdClass(null);
            StudentDAO.updateStudent(h);

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
