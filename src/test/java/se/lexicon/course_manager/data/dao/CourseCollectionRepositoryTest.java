package se.lexicon.course_manager.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    @Autowired
    private CourseDao testObject;
    private Course testArray;
    private Course testHash;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    @BeforeEach
    void setUp() {
        testArray = testObject.createCourse("Array", LocalDate.of(2024, Month.NOVEMBER, 15), 7);
        testHash = testObject.createCourse("Hash", LocalDate.of(2024, Month.DECEMBER, 15), 2);
    }

    @Test
    void createCourse() {
        Course testMap = testObject.createCourse("Map", LocalDate.of(2024, Month.NOVEMBER, 12), 4);
        assertNotNull(testMap);
    }

    @Test
    void findById() {
        Course found = testObject.findById(testArray.getId());
        assertEquals(testArray.getId(), found.getId());
    }

    @Test
    void findByNameContains() {
        Collection<Course> courses = testObject.findByNameContains(testArray.getCourseName());
        assertNotNull(courses);
    }

    @Test
    void findByDateBefore() {
        Collection<Course> courses = testObject.findByDateBefore(LocalDate.of(2024, Month.NOVEMBER, 16));
        assertNotNull(courses);
        assertEquals(1, courses.size());
    }

    @Test
    void findByDateAfter() {
        Collection<Course> courses = testObject.findByDateAfter(LocalDate.of(2024, Month.NOVEMBER, 16));
        assertNotNull(courses);
        assertEquals(1, courses.size());
    }

    @Test
    void findAll() {
        Collection<Course> courses = testObject.findAll();
        assertNotNull(courses);
        assertEquals(2, courses.size());
    }

    @Test
    void findByStudentId() {
        Student student = new Student(1);
        testArray.enrollStudent(student);
        Collection<Course> courses = testObject.findByStudentId(student.getId());
        assertNotNull(courses);
        assertEquals(1, courses.size());
    }


    @Test
    void removeCourse() {
        assertTrue(testObject.removeCourse(testArray));
        assertNull(testObject.findById(testArray.getId()));
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}
