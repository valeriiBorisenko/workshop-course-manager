package se.lexicon.course_manager.data.dao;

import se.lexicon.course_manager.data.sequencers.StudentSequencer;
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

        if (students.add(student)) {
            return student;
        }
        return null;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student student: students) {
            if (student.getEmail().trim().equalsIgnoreCase(email.trim())) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> findStudents = new HashSet<>();

        for (Student student : students) {
            if (student.getName().trim().toLowerCase().contains(name.trim().toLowerCase())) {
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
        return Collections.unmodifiableCollection(students);
    }

    @Override
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
