package ua.com.alevel.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.alevel.app.dao.LessonInfo;

import javax.persistence.EntityManager;

public class AppMain {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
            EntityManager entityManager = sessionFactory.createEntityManager();
            LessonInfo nextLesson = new LessonInfo();
            nextLesson.findByStudentId(entityManager, 1L);
            entityManager.close();
        }
    }
}
