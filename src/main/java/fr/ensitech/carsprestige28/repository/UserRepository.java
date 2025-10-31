package fr.ensitech.carsprestige28.repository;

import fr.ensitech.carsprestige28.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.RollbackException;
import java.util.List;

public class UserRepository implements IuserRepository {

    @Override
    public void addUser(User user) throws Exception{

        Session session = null;
        Transaction tx = null;
        try {
//            Pour ajouter dans la base de données
            session = HibernateConnector.getSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();

        } catch (RollbackException e){
            if (tx !=null) {
                tx.rollback();
            }
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateUser(User user) throws Exception {

        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateConnector.getSession();
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch (RollbackException e){
            if (tx !=null) {
                tx.rollback();
            }
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }

    }

    @Override
    public void deleteUser(User user) throws Exception {

        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateConnector.getSession();
            tx = session.beginTransaction();
            session.remove(user);
            tx.commit();
        }catch (RollbackException e){
            if (tx !=null) {
                tx.rollback();
            }
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public User getUserbyEmail(String email) throws Exception {
        return null;
    }

    @Override
    public User getUserbyId(Integer id) throws Exception {
        Session session = null;
        try {
            session = HibernateConnector.getSession();
            return session.get(User.class, id);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }


    @Override
    public List<User> getAllUsers() throws Exception{

        Session session = null;
        try {
            session = HibernateConnector.getSession();

//            return session.createNativeQuery("User::findAll",User.class).list();
            return session.createQuery("FROM User u",User.class).list();


        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

}
