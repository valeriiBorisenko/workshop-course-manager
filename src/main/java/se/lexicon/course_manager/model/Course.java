package se.lexicon.course_manager.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

// TODO implement model
public class Course implements Serializable {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course() {
        this.students = new HashSet<>();
    }

    public Course(int id) {
        this();
        this.id = id;
    }

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this(id);
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public Course(int id, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this(id, courseName, startDate, weekDuration);
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        boolean statusEnroll = false;
        if (student != null && !students.contains(student)) {
            statusEnroll = students.add(student);
        }

        return statusEnroll;
    }

    public boolean unenrollStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }
}
