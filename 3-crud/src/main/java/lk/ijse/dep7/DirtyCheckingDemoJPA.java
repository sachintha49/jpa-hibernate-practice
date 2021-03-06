package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DirtyCheckingDemoJPA {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Student sachintha = session.find(Student.class, 2);
            System.out.println(sachintha);
            sachintha.setContactNumber("12345677");
            System.out.println("Change the phone number :");
            session.detach(sachintha);
// methanadi udpdate eka wadinne nehe mokad api detach karapu nisa ethakota dirty checking feture ekat aahuw enne nethi nisa
            session.getTransaction().commit();
        }
    }
}
