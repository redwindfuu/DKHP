package com.Course.DAO;

import com.Course.Pojo.Object;
import com.Course.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ObjectDAO {
    public static List<Object> getALlObjectList(){
        Session session  = HibernateUtil.getSession();
        List<Object> lst = null;
        try {
            final String hql = "select  st from Object st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return lst;
    }

    public static boolean isExistsObject(String idSv){
        Session session  = HibernateUtil.getSession();
        List<Object> lst = null;
        try {
            final String hql = "select  st from Object st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        for (Object n : lst) {
            if(n.getIdOb().equals(idSv)){
                return true;
            }
        }

        return false;
    }

    public static Object getObject(String idSv){
        Session session = HibernateUtil.getSession();
        Object st = null;
        try{
            String hql ="select st from Object st where st.idStu = : ID";
            st = (Object) session.get(Object.class,idSv);

        }catch (HibernateException ex){
            System.out.println(" loi ");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addObject(Object st){
        Session session = HibernateUtil.getSession();
        if(ObjectDAO.isExistsObject(st.getIdOb())){
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

    public static boolean updateObject(Object st){
        Session session = HibernateUtil.getSession();
        if(ObjectDAO.getObject(st.getIdOb()) == null){
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

    public static boolean deleteObject(String idStu){
        Session session = HibernateUtil.getSession();
        Object sv = ObjectDAO.getObject(idStu);
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
