package fr.ensitech.carsprestige28.main;

import fr.ensitech.carsprestige28.repository.HibernateConnector;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args){

        try {
            Session session = HibernateConnector.getSession();
            System.out.println("Hibernate Session: " + session);
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
