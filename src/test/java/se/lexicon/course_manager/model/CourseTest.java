package se.lexicon.course_manager.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    Course testObject;
    Student student;

    @BeforeEach
    void setUp() {
        testObject = new Course(1);
        student = new Student(1);
    }

    @Test
    void setCourseName() {
        String test = "Test";
        testObject.setCourseName(test);
        assertTrue(testObject.getCourseName().trim().toLowerCase().contains(test.trim().toLowerCase()));
    }

    @Test
    void setStartDate() {
        LocalDate date = LocalDate.of(2024, 11, 15);
        testObject.setStartDate(date);
        assertSame(testObject.getStartDate(), date);
    }

    @Test
    void setWeekDuration() {
        int weekDuration = 7;
        testObject.setWeekDuration(weekDuration);
        assertEquals(testObject.getWeekDuration(), weekDuration);
    }

    @Test
    void setStudents() {
        testObject.setStudents(new HashSet<>(Collections.singletonList(student)));
        assertTrue(testObject.getStudents().contains(student));
    }

    @Test
    void enrollStudent() {
        testObject.enrollStudent(student);
        assertTrue(testObject.getStudents().contains(student));
    }

    @Test
    void unenrollStudent() {
        testObject.enrollStudent(student);
        assertTrue(testObject.getStudents().contains(student));
        testObject.unenrollStudent(student);
        assertFalse(testObject.getStudents().contains(student));
    }
}
