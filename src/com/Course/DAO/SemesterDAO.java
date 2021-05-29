package com.Course.DAO;

import com.Course.HibernateUtil;
import com.Course.Pojo.Semester;
import com.Course.Pojo.SemesterPK;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SemesterDAO {
    public static List<Semester> getALlSemesterList(){
        Session session  = HibernateUtil.getSession();
        List<Semester> lst = null;
        try {
            final String hql = "select  st from Semester st ";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static boolean isExistsSemester(SemesterPK idSv){
        Session session  = HibernateUtil.getSession();
        List<Semester> lst = null;
        try {
            final String hql = "select  st from Semester st";
            Query query = session.createQuery(hql);
            lst = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        for (Semester n : lst) {
            if(n.getIdSemester().equals(idSv)){
                return true;
            }
        }

        return false;
    }

    public static Semester getSemester(String nam , String HK){
        Session session = HibernateUtil.getSession();
        Semester st = null;
        try{
            String hql ="select st from Semester st where st.idSemester.semeId =: hk and st.idSemester.yearSeme  =: nam ";
            st = (Semester) session.createQuery(hql).setString("hk",HK).setString("nam",nam).uniqueResult();

        }catch (HibernateException ex){
            System.out.println(" loi ");
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return st;
    }

    public static boolean addSemester(Semester st){
        Session session = HibernateUtil.getSession();
        if(SemesterDAO.isExistsSemester(st.getIdSemester())){
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

    public static boolean updateSemester(Semester st){
        Session session = HibernateUtil.getSession();
        if(SemesterDAO.getSemester(st.getIdSemester().getYearSeme(),st.getIdSemester().getSemeId()) == null){
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

    public static boolean deleteSemester(String nam , String HK){
        Session session = HibernateUtil.getSession();
        Semester sv = SemesterDAO.getSemester(nam,HK);
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
