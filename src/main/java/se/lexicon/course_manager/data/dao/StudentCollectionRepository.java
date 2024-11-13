package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.util.*;

// TODO provide proper implementation.

public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(StudentSequencer.nextStudentId(), name, email, address);
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student student: students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        HashSet<Student> findStudents = new HashSet<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                findStudents.add(student);
            }
        }
        return findStudents;
    }

    @Override
    public Student findById(int id) {
        for (Student student: students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }

    @Override
    public boolean removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
