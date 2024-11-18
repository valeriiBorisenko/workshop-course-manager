package se.lexicon.course_manager.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    @Autowired
    private StudentDao testObject;
    private Student student;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }


    @BeforeEach
    void setUp() {
        student = testObject.createStudent("Karl Anderson", "karl@lexicon.se", "The roof");
    }

    @Test
    void createStudent() {
        Student newStudent = testObject.createStudent("Lisa Anderson", "lisa@lexion.se", "the house");
        assertNotNull(newStudent);
    }

    @Test
    void findByEmailIgnoreCase() {
        Student findStudent = testObject.findByEmailIgnoreCase(student.getEmail());
        assertNotNull(findStudent);
        assertEquals(findStudent, student);
    }

    @Test
    void findByNameContains() {
        Collection<Student> students = testObject.findByNameContains(student.getName());
        assertNotNull(students);
        assertTrue(students.contains(student));
    }

    @Test
    void findById() {
        Student findStudent = testObject.findById(student.getId());
        assertNotNull(findStudent);
        assertEquals(findStudent, student);
    }

    @Test
    void findAll() {
        Collection<Student> students = testObject.findAll();
        assertNotNull(students);
        assertEquals(1, students.size());
    }

    @Test
    void removeStudent() {
        assertTrue(testObject.removeStudent(student));
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }
}
