package ua.com.alevel.app.dao;

import ua.com.alevel.app.model.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;

public class LessonInfo {

    public void findByStudentId(EntityManager entityManager, Long id){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("Select lesson From Lesson lesson " +
                    "join Group group_ ON lesson.group.group_id = group_.group_id " +
                    "join Student student on student.group.group_id = group_.group_id " +
                    "where student.student_id = ?1 order by lesson.date ").setParameter(1,id);

            query.setMaxResults(1);
            entityManager.getTransaction().commit();

            Lesson lesson = (Lesson) query.getSingleResult();
            LocalDateTime dateTime = lesson.getDate();

            System.out.println("\nDate: " + dateTime.getYear() + " " + dateTime.getMonth() + " " + dateTime.getDayOfMonth()
                    + "\nTime: " + dateTime.getHour() + ":" + dateTime.getMinute()
                    + "\nLesson: " + lesson.getName()
                    + "\nTopic: " + lesson.getTopic().getName()
                    + "\nTeacher: " + lesson.getTeacher().getSurname() + " " + lesson.getTeacher().getName());

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}
