package ua.com.alevel.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;

    @Column(nullable = false)
    private String name;

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Column(nullable = false)
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<Lesson> lessons = new ArrayList<>();

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson_) {
        lessons.add(lesson_);
    }
}